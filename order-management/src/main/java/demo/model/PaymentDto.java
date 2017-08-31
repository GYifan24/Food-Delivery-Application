package demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class PaymentDto {

    private boolean isSuccess;
    private long paymentId;
    private Date timestamp = new Date();
    private double EDT;

}
