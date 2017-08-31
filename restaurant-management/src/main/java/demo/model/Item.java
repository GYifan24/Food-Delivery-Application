package demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@NoArgsConstructor
public class Item {


    private long itemId;
    private String itemName;

    private double price;

    @JsonCreator
    public Item(@JsonProperty("itemName") String itemName,
                @JsonProperty("price") double price){
        this.itemName = itemName;
        this.price = price;
    }

}
