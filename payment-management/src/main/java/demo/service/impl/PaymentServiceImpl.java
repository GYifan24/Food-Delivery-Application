package demo.service.impl;

import demo.model.CreditCardInfo;
import demo.model.PaymentInfo;
import demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PaymentServiceImpl implements PaymentService{
    @Autowired
    CreditCardRepository creditCardRepository;

    @Override
    public void upload(List<CreditCardInfo> creditCardInfoList) {
        this.creditCardRepository.save(creditCardInfoList);
    }

    @Override
    public boolean isValidCard(CreditCardInfo creditCardInfo) {
        CreditCardInfo userCard = this.creditCardRepository.findCreditCardInfoByCardNum(creditCardInfo.getCardNum());
        if(userCard != null)
            if(userCard.getExpirationDate().hashCode() == creditCardInfo.getExpirationDate().hashCode()
                    && userCard.getSecurityCode() == creditCardInfo.getSecurityCode())
                return true;
        return false;
    }

    @Override
    public void makePayment(PaymentInfo paymentInfo) {


        // call bank
        Chase.api.change("api.chase.com/us/credit-card/charge/?dajflk;akl&djflkjad;f");

        saveToDB()


        if success {
            return ok
        }
        else {
            return not_ok
        }
        // if sccess
        if(isValidCard(paymentInfo.getCardInfo()))
            paymentInfo.setSucceed(true);
        else
            paymentInfo.setSucceed(false);
    }
}
