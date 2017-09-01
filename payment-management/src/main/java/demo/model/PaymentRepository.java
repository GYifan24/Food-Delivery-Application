package demo.model;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PaymentRepository extends CrudRepository<PaymentInfo, Long> {
    PaymentInfo findPaymentInfoByOrderId(@Param("orderId") int orderId);

}
