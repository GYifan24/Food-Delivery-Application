package demo.model;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    Restaurant findRestaurantByName(@Param("name") String name);
}