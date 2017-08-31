package demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ItemsTable")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Item {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int itemOrderId;
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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

}
