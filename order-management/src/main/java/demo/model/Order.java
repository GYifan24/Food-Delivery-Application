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
@Table(name = "OrderTable")
@NoArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id", unique = true)
    private int id;

    private String note;
    private double totalPrice;

    private long paymentId;
    boolean isSuccess;
    private String deliveryAddress;
    private Date timestamp = new Date();

    @OneToMany
    @JoinTable(name = "items", joinColumns = @JoinColumn(name = "order_id"),
    inverseJoinColumns = @JoinColumn(name = "id"))
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

    public void setTotalPrice(){
        for(Item i: items)
            totalPrice += i.getPrice();
    }

    @Override
    public String toString() {
        String result = String.format(
                "Order[id=%d, deliveryAddress='%s']%n",
                id, deliveryAddress);
        if (items != null) {
            for(Item i : items) {
                result += String.format(
                        "Item[id=%d, name='%s']%n",
                        i.getId(), i.getItemName());
            }
        }

        return result;
    }

}
