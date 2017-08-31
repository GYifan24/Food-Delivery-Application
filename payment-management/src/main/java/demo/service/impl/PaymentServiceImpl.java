package demo.service.impl;

import demo.model.PaymentInfo;
import demo.model.PaymentRepository;
import demo.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService{

    private PaymentRepository repository;

    @Override
    public void savePaymentInfo(PaymentInfo paymentInfo) {
        this.repository.save(paymentInfo);
    }

    @Override
    public boolean isValidCard(PaymentInfo paymentInfo) {
        // should check with bank's API to see whether this is a valid card
        return true;
    }

    @Override
    public PaymentInfo makePayment(PaymentInfo paymentInfo) {
        if(isValidCard(paymentInfo)){
            paymentInfo.setSuccess(true);
            paymentInfo.setPaymentId((long)Math.random());
            paymentInfo.setTimestamp(new Date());
        }
        return paymentInfo;
    }

}
