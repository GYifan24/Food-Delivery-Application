package demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;

import javax.persistence.Embedded;
import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
public class PaymentInfo {
    @Id
    @Generated
    private String paymentId;
    @Embedded
    private CreditCardInfo cardInfo;
    private double totalPaid;
    private boolean isSuccess;
    private Date timestamp = new Date();

}
