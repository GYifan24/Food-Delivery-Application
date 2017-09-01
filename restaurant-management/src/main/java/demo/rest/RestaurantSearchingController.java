package demo.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ArrayIterator;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import demo.model.Item;
import demo.model.Restaurant;
import demo.model.RestaurantRepository;
import demo.service.SearchRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path ="/foodDeliveryAPI")
public class RestaurantSearchingController {
    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    private SearchRestaurantService searchRestaurantService;

    @RequestMapping(path = "/restaurants", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload() throws IOException{
        System.out.println("post");
        InputStream is = getClass().getResourceAsStream("/json/restaurants.json");

        ObjectMapper mapper = new ObjectMapper();
        Restaurant[] restaurantsList =
                mapper.readValue(new InputStreamReader(is),
                        TypeFactory.defaultInstance().constructArrayType(Restaurant.class)
                );

        List<Restaurant> list = new ArrayList<Restaurant>();
        for (Restaurant res: restaurantsList) {
            System.out.println(res);
            list.add(res);
        }
        restaurantRepository.save(list);
    }

    @RequestMapping(value = "/restaurants/{name}", method = RequestMethod.GET)
    public List<Item> findRestaurant(@PathVariable String name) {
        Restaurant restaurant = restaurantRepository.findRestaurantByName(name);
        System.out.println(restaurant);
        return restaurant.getItems();
    }
}
