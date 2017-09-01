package demo.service.impl;

import demo.model.Order;
import demo.model.OrderRepository;
import demo.model.PaymentDto;
import demo.model.PaymentInfo;
import demo.service.OrderingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
@Slf4j
public class OrderingServiceImpl implements OrderingService {

    @Autowired
    OrderRepository orderRepository;

//    @Autowired
    private RestTemplate restTemplate = new RestTemplate();

    @Value("${com.cs504.payment.management}")
    private String paymentService;

    @Override
    public PaymentDto placeAnOrder(Order order) {
        order.setTotalPrice(order);
        orderRepository.save(order);
        log.info("Order Service: Read In order information" + order.getId());
        PaymentInfo paymentInfo = new PaymentInfo(order.getId(),
                order.getTotalPrice(), order.getCcInfo(), false, 0, order.getTimestamp());

        log.info("Order Service: Send payment info to payment Service");

        ResponseEntity<PaymentInfo> response =
                this.restTemplate.postForEntity(paymentService + "/order/payment", paymentInfo, PaymentInfo.class);

        if(response == null) {
            log.error("Payment Failed");
            return null;
        }
        log.info("Order Service: Get payment service response" + response);
        int EDT = (int)(Math.random() * 55 + 5);
        PaymentDto dto = new PaymentDto(response.getBody().isSuccess(), response.getBody().getPaymentId(),
                response.getBody().getTimestamp(), EDT);
        return dto;
    }

}

