package demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order {

    @Id
    @Generated
    private long orderId;

    private String note;
    private double totalPrice;

    private long paymentId;
    boolean isSuccess;
    private String deliveryAddress;
    private Date timestamp = new Date();
    @ManyToOne
    private Item[] items;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "cardNum", column = @Column(name = "cardNum")),
            @AttributeOverride(name = "expirationDate", column = @Column(name = "expirationDate")),
            @AttributeOverride(name = "securityCode", column = @Column(name = "securityCode"))
    })
    private CreditCardInfo ccInfo;

    @JsonCreator
    public Order(@JsonProperty("orderId") long orderId,
                 @JsonProperty("deliveryAddress") String deliveryAddress,
                 @JsonProperty("items") Item[] items){
        this.orderId = orderId;
        this.deliveryAddress = deliveryAddress;
        this.items = items;
    }

}
