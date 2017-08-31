package demo.service;

import demo.model.Order;
import demo.model.PaymentDto;

public interface OrderingService {
//    void saveAnOrder(Order order);
    PaymentDto placeAnOrder(Order order);

}
