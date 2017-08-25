package demo.service.impl;

import demo.model.Menu;
import demo.model.Restaurant;
import demo.model.RestaurantRepository;
import demo.service.SearchRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchRestaurantServiceImpl implements SearchRestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public void saveRestaurants(List<Restaurant> restaurants) {
        this.restaurantRepository.save(restaurants);
    }

    @Override
    public Menu findByName(String name, Pageable pageable) {
        Page<Restaurant> restaurant = restaurantRepository.findRestaurantByName(name, pageable);
        return restaurant.getContent().get(0).getMenu();
    }
}
