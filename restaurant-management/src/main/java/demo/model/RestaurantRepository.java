package demo.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;


public interface RestaurantRepository extends JpaRepository<Restaurant, Serializable> {
    Page<Restaurant> findRestaurantByName(@Param("name") String name, Pageable pageable);
}