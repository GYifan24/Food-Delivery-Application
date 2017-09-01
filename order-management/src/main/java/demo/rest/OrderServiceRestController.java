package demo.rest;

import demo.model.Order;
import demo.model.PaymentDto;
import demo.service.OrderingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderServiceRestController {

    @Autowired
    OrderingService orderingService;

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public PaymentDto placeAnOrder(@RequestBody Order order){
        System.out.println(order);
        return orderingService.placeAnOrder(order);
    }


}
