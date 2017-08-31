package demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Embedded;
import java.util.Date;

@Data
@AllArgsConstructor
public class PaymentInfo {

    private long orderId;
    private double totalPrice;
    @Embedded
    private CreditCardInfo ccInfo;
    private boolean isSuccess;
    private long paymentId;
    private Date timestamp;

}
