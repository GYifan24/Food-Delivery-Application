package demo.service;

import demo.model.PaymentInfo;

public interface PaymentService {

    boolean isValidCard(PaymentInfo paymentInfo);

    PaymentInfo makePayment(PaymentInfo paymentInfo);

}
