package demo.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface RestaurantRepository extends PagingAndSortingRepository<Restaurant, String> {
    Page<Restaurant> findRestaurantByName(@Param("name") String name, Pageable pageable);
}
