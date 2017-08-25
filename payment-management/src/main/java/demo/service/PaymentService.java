package demo.service;

import demo.model.CreditCardInfo;
import demo.model.PaymentInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaymentService {
    // save payment info to database
    void savePaymentInfo(PaymentInfo paymentInfo);

}
