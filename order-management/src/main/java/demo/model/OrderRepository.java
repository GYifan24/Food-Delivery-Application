package demo.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface OrderRepository extends JpaRepository<Order, Integer> {
//    void deleteById(@Param String id);
//
//    Order findById(@Param long id);
    Order findOrderByTimestamp(@Param("timestamp") Date timestamp);
    Order findById(@Param("id") int id);

}
