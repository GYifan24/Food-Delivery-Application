package demo.model;

import lombok.AllArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@AllArgsConstructor
public class Item {

    private String id;
    private String name;
    private String note;
    private double price;
    private int quantity;

}
