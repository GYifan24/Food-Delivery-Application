package demo.service;

import demo.model.Menu;
import demo.model.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SearchRestaurantService {
    void saveRestaurants(List<Restaurant> restaurants);
    Menu findByName(String name, Pageable pageable);
}
