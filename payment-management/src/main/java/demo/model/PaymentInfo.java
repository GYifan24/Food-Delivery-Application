package demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "payment")
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentInfo {

    @Column(name = "orderId")
    private int orderId;
    @Column(name = "totalPrice")
    private double totalPrice;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "cardNum", column = @Column(name = "cardNum")),
            @AttributeOverride(name = "expirationDate", column = @Column(name = "expirationDate")),
            @AttributeOverride(name = "securityCode", column = @Column(name = "securityCode"))
    })
    private CreditCardInfo ccInfo;

    @Column(name = "isSuccess")
    private boolean isSuccess;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "payment_id", unique = true, nullable = false)
    private long paymentId;

    @Column(name = "timestamp")
    private Date timestamp = new Date();

    @JsonCreator
    public PaymentInfo(@JsonProperty("orderId") int orderId,
                       @JsonProperty("totalPrice") double totalPrice,
                       @JsonProperty("ccInfo") CreditCardInfo ccInfo){
        this.orderId = orderId;
        this.totalPrice = totalPrice;
        this.ccInfo = ccInfo;
    }

}
