package demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@Entity
public class PaymentInfo {

    private long orderId;
    private double totalPrice;
    @Embedded
    private CreditCardInfo ccInfo;
    private boolean isSuccess;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long paymentId;

    private Date timestamp = new Date();

}
