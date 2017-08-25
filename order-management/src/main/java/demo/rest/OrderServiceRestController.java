package demo.rest;

import demo.model.Order;
import demo.service.OrderingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderServiceRestController {

    @Autowired
    OrderingService orderingService;

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public double placeAnOrder(Order order){
        orderingService.placeAnOrder(order);
        // if order failed, return -1;
        // if order succeed, return ETA;
        return -1;
    }


}
