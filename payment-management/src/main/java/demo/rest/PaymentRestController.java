package demo.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import demo.model.PaymentInfo;
import demo.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
public class PaymentRestController {
    @Autowired
    PaymentService paymentService;

    @Autowired
    private ObjectMapper objectMapper;

//    @RequestMapping(path = "/order/payment", method = RequestMethod.POST)
//    public PaymentInfo makePayment(@RequestBody PaymentInfo paymentInfo){
//        return this.paymentService.makePayment(paymentInfo);
//    }
    @RequestMapping(path = "/order/payment", method = RequestMethod.POST)
    public PaymentInfo makePayment(@RequestBody String paymentInfo) throws IOException{
        PaymentInfo info = this.objectMapper.readValue(paymentInfo, PaymentInfo.class);
        PaymentInfo temp = this.paymentService.makePayment(info);
        log.info("Payment Service: Rest Layer:" + temp);
        return temp;
    }
}
