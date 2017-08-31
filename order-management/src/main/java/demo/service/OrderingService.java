package demo.service;

import demo.model.Item;
import demo.model.Order;
import demo.model.PaymentDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface OrderingService {
//    void saveAnOrder(Order order);
    PaymentDto placeAnOrder(Order order);

}
