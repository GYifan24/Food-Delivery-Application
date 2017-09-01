package demo.service.impl;

import demo.model.Order;
import demo.model.OrderRepository;
import demo.model.PaymentDto;
import demo.model.PaymentInfo;
import demo.service.OrderingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    private String paymentService = "http://localhost:9009";

    @Override
    public PaymentDto placeAnOrder(Order order) {
        //save to database
        orderRepository.save(order);
//        Order orderWithId = orderRepository.findOrderByTimestamp(order.getTimestamp());
        log.info("Order Service: Read In order information" + order.getId());
        PaymentInfo paymentInfo = new PaymentInfo(order.getId(),
                order.getTotalPrice(), order.getCcInfo(), false, 0, order.getTimestamp());

        log.info("Order Service: Send payment info to payment Service");
        ResponseEntity<PaymentInfo> response =
                this.restTemplate.postForEntity(paymentService + "/order/payment", paymentInfo, PaymentInfo.class);


        log.info("Order Service: Get payment service response" + response);
        double EDT = Math.random() * 55 + 5;
        PaymentDto dto = new PaymentDto(response.getBody().isSuccess(), response.getBody().getPaymentId(),
                response.getBody().getTimestamp(), EDT);
//        if(response.getBody().isSuccess()) {
//            orderWithId
//            order.setPaymentId(dto.getPaymentId());
//            order.setSuccess(true);
//            order.setTimestamp(dto.getTimestamp());
//            log.info("save order %long to database" + order.getOrderId());
//            orderRepository.save(order);
//        }
        return dto;
    }

}

