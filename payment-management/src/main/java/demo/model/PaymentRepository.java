package demo.model;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface PaymentRepository extends JpaRepository<PaymentInfo, Long> {
    PaymentInfo findPaymentInfoByOrderId(@Param("orderId") long orderId);

}
