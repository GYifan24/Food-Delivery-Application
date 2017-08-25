package demo.model;

import lombok.Data;
import lombok.Generated;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
public class Order {

    @Id
    @Generated
    private String id;
    private String note;
    private double totalPrice;
    @Generated
    private String paymentId;
    boolean isSuccess;
    @Embedded
    private List<Item> oneOrder;


    private CreditCardInfo ccInfo;
}

