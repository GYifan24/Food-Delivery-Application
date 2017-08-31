package demo.service.impl;

import demo.model.PaymentInfo;
import demo.model.PaymentRepository;
import demo.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private PaymentRepository repository;


    @Override
    public boolean isValidCard(PaymentInfo paymentInfo) {
        // should check with bank's API to see whether this is a valid card
        return true;
    }

    @Override
    public PaymentInfo makePayment(PaymentInfo paymentInfo) {
        if(isValidCard(paymentInfo)){
            paymentInfo.setSuccess(true);
            //save to db
            repository.save(paymentInfo);
            PaymentInfo paymentInfoWithId = repository.findPaymentInfoByOrderId(paymentInfo.getOrderId());
            return paymentInfoWithId;
        }
        else
            return null;

    }
}
