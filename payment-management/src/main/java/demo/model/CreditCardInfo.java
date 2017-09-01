package demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreditCardInfo {

    private String cardNum;
    private String expirationDate;
    private int securityCode;

    @JsonCreator
    public CreditCardInfo(@JsonProperty("cardNum") String cardNum,
                          @JsonProperty("expirationDate") String expirationDate,
                          @JsonProperty("securityCode") int securityCode){
        this.cardNum = cardNum;
        this.expirationDate = expirationDate;
        this.securityCode = securityCode;
    }

    public CreditCardInfo(){}

}
