package demo.rest;

import demo.model.CreditCardInfo;
import demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class PaymentRestController {
    @Autowired
    PaymentService paymentService;

    @RequestMapping(value = "Order/Payment", method = RequestMethod.POST)
    public boolean makePayment(CreditCardInfo info, double amount){
        //info from
        return false;
    }



}
