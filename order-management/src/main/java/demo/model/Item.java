package demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "item")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
//@Access(AccessType.FIELD)
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    private int id;

    private String itemName;
    private String note;
    private double price;
    private int quantity;


    @JsonCreator
    public Item(@JsonProperty("itemName") String itemName,
                @JsonProperty("price") double price,
                @JsonProperty("quantity") int quantity){
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", note='" + note + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
