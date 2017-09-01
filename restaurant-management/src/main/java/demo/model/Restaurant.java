package demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@Table(name = "Restaurants")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "restaurant_id", unique = true, nullable = false)
    private int id;

    private String name;

    private String address;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "restaurant_to_item",
            joinColumns = @JoinColumn(name = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items = new ArrayList<>();

    @JsonCreator
    public Restaurant(@JsonProperty("name") String name,
                      @JsonProperty("address") String address,
                      @JsonProperty("menu") List<Item> items){
        this.name = name;
        this.address = address;
        this.items = items;
    }
}
