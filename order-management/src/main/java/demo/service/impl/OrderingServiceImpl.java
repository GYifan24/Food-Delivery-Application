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

    private String paymentService = "localhost:9006";

    @Override
    public PaymentDto placeAnOrder(Order order) {
        //save to database
        orderRepository.save(order);
//        Order orderWithId = orderRepository.findOrderByTimestamp(order.getTimestamp());
        log.info("Read In order information" + order.getId());
        PaymentInfo paymentInfo = new PaymentInfo(order.getId(),
                order.getTotalPrice(), order.getCcInfo(), false, 0, order.getTimestamp());

        log.info("Send payment info to payment Service");
        ResponseEntity<PaymentInfo> response =
                this.restTemplate.getForEntity(paymentService + "/order/payment", PaymentInfo.class, paymentInfo);

        log.info("Get payment service response" + response);
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

