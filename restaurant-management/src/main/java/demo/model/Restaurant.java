package demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Restaurant {

    @Id
    @Generated
    private String id;
    private String name;
    private String address;

    private Menu menu;

}
