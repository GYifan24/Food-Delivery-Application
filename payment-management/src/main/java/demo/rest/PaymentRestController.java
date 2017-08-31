package demo.rest;

import demo.model.PaymentInfo;
import demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentRestController {
    @Autowired
    PaymentService paymentService;

    @RequestMapping(value = "/order/payment", method = RequestMethod.POST)
    public PaymentInfo makePayment(@RequestBody PaymentInfo paymentInfo){
        return this.paymentService.makePayment(paymentInfo);
    }
}
