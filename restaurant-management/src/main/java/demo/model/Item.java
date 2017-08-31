package demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;



@Data
@NoArgsConstructor
public class Item {

    private String itemName;

    private double price;

    @JsonCreator
    public Item(@JsonProperty("itemName") String itemName,
                @JsonProperty("price") double price){
        this.itemName = itemName;
        this.price = price;
    }

}
