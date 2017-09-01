package demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Order_Table")
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", unique = true, nullable = false)
    private int id;

    @Column(name = "note")
    private String note;
    private double totalPrice;

    @Column(name = "paymentId")
    private long paymentId;

    @Column(name = "isSuccess")
    boolean isSuccess;

    @Column(name = "deliveryAddress")
    private String deliveryAddress;

    @Column(name = "timestamp")
    private Date timestamp = new Date();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "order_to_item",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items = new ArrayList<>();

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "cardNum", column = @Column(name = "cardNum")),
            @AttributeOverride(name = "expirationDate", column = @Column(name = "expirationDate")),
            @AttributeOverride(name = "securityCode", column = @Column(name = "securityCode"))
    })
    private CreditCardInfo ccInfo;


    @JsonCreator
    public Order(@JsonProperty("deliveryAddress") String deliveryAddress,
                 @JsonProperty("items") List<Item> items,
                 @JsonProperty("ccInfo") CreditCardInfo ccInfo){
        this.deliveryAddress = deliveryAddress;
        this.items = items;
        this.ccInfo = ccInfo;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", note='" + note + '\'' +
                ", totalPrice=" + totalPrice +
                ", paymentId=" + paymentId +
                ", isSuccess=" + isSuccess +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", timestamp=" + timestamp +
                ", items=" + items +
                ", ccInfo=" + ccInfo +
                '}';
    }
}
