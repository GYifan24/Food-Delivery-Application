package demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreditCardInfo {
    private String cardNum;
    private String expirationDate;
    private int securityCode;

    public CreditCardInfo(String cardNum, String expirationDate, int securityCode){
        this.cardNum = cardNum;
        this.expirationDate = expirationDate;
        this.securityCode = securityCode;
    }

    public CreditCardInfo(){}

}
