package demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Table;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_payment_info")
public class PaymentInfo {

    private int orderId;
    private double totalPrice;
    private CreditCardInfo ccInfo;
    private boolean isSuccess;
    private long paymentId;
    private Date timestamp;

//    public PaymentInfo() {
//
//    }

}
