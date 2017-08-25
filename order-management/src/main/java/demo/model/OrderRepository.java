package demo.model;

import org.jboss.logging.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
    void deleteById(@Param String id);

    Order findById(@Param String id);



}
