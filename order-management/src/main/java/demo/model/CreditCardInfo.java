package demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class CreditCardInfo {
    private String cardNum;
    private String expirationDate;
    private int securityCode;

    public CreditCardInfo(String cardNum, String expirationDate, int securityCode){
        this.cardNum = cardNum;
        this.expirationDate = expirationDate;
        this.securityCode = securityCode;
    }
}
