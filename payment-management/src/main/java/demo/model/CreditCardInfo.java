package demo.model;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class CreditCardInfo {
    private String cardNum;
    private String expirationDate;
    private int securityCode;
}
