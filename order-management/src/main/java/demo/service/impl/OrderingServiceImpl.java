package demo.service.impl;

import demo.model.*;
import demo.service.OrderingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
@Slf4j
public class OrderingServiceImpl implements OrderingService {

    OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    private String paymentService = "localhost:9006";

    @Override
    public PaymentDto placeAnOrder(Order order) {

        log.info("Read In order information" + order.getOrderId());
        PaymentInfo paymentInfo = new PaymentInfo(order.getOrderId(),
                order.getTotalPrice(), order.getCcInfo(), false, 0, null);

        log.info("Send payment info to payment Service");
        ResponseEntity<PaymentInfo> response =
                this.restTemplate.getForEntity(paymentService + "/order/payment", PaymentInfo.class, paymentInfo);

        log.info("Get payment service response");
        double EDT = Math.random() * 55 + 5;
        PaymentDto dto = new PaymentDto(response.getBody().isSuccess(), response.getBody().getPaymentId(),
                response.getBody().getTimestamp(), EDT);
        if(response.getBody().isSuccess()) {
            order.setPaymentId(dto.getPaymentId());
            order.setSuccess(true);
            order.setTimestamp(dto.getTimestamp());
            log.info("save order %long to database" + order.getOrderId());
            orderRepository.save(order);
        }
        return dto;
    }

}

