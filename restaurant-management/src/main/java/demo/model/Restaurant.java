package demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@Table(name = "Restaurants")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Restaurant {

    @Id
    @Generated
    private String id;
    @JsonProperty("name")
    private String name;

    @JsonProperty("address")
    private String address;


    @JsonProperty("menu")
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "Restaurant")
//    @AttributeOverrides({
//            @AttributeOverride(name = "ItemName", column = @Column(name = "ItemName")),
//            @AttributeOverride(name = "price", column = @Column(name = "price"))
//    })
//    @OneToMany(mappedBy = "menu")
//    @OneToMany(cascade = {CascadeType.ALL}
//    @OneToMany(targetEntity = Item.class, mappedBy = "Restaurant", fetch = FetchType.EAGER)
    private List<Item> menu;

    @JsonCreator
    public Restaurant(@JsonProperty("id") String id,
                      @JsonProperty("name") String name,
                      @JsonProperty("address") String address,
                      @JsonProperty("menu") List<Item> menu){
        this.id = id;
        this.name = name;
        this.address = address;
        this.menu = menu;
    }
}
