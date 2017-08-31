package demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Embeddable;

@Data
public class Item {

    private String itemId;
    private String itemName;
    private String note;
    private double price;
    private int quantity;

    public Item(String itemId, String itemName, double price, int quantity){
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

}
