package demo.service;

import demo.model.PaymentInfo;

public interface PaymentService {
    // save payment info to database
    void savePaymentInfo(PaymentInfo paymentInfo);

    boolean isValidCard(PaymentInfo paymentInfo);

    PaymentInfo makePayment(PaymentInfo paymentInfo);

}
