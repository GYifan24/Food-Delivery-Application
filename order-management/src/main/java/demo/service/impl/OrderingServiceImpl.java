package demo.service.impl;

import demo.model.Item;
import demo.model.Order;
import demo.model.OrderRepository;
import demo.service.OrderingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

public class OrderingServiceImpl implements OrderingService {

    OrderRepository orderRepository;
    @Override
    public void deleteByOrderId(String id) {

    }

    @Override
    public Order findAnOrder(String id) {
        return null;
    }

    @Override
    public void placeAnOrder(Order order) {
        // order.price + id -> payment service
        // rest template

        // sanity check if the order is valid

        // call payment to charge
//        paymentService.makePayment(order.getCcInfo(), order.getTotalPrice());
//
//        if returned_true {
//            saveToDB;
//            return ETA;
//        }
//        else {
//            saveToDB;
//            return "please try another card and order again"
        }

    @Override
    public void saveAnOrder(Order order) {

    }
}

