package demo.service;

import demo.model.Item;
import demo.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface OrderingService {

    void deleteByOrderId(String id);

    Order findAnOrder(String id);

    void placeAnOrder(Order order);

    // save an order to database
    void saveAnOrder(Order order);


}
