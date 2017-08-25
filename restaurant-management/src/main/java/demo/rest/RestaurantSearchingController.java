package demo.rest;

import demo.model.Menu;
import demo.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import demo.service.SearchRestaurantService;

import java.util.List;

@RestController
@RequestMapping(value = "/foodDeliveryAPI")
public class RestaurantSearchingController {

    @Autowired
    private SearchRestaurantService searchRestaurantService;

    @RequestMapping(value = "/restaurants", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<Restaurant> restaurantList){
        this.searchRestaurantService.saveRestaurants(restaurantList);
    }

    @RequestMapping(value = "/restaurants/{name}", method = RequestMethod.GET)
    public Menu findRestaurant(@PathVariable String name, @RequestParam(value = "page") int page,
                               @RequestParam (value = "size") int size){
      return searchRestaurantService.findByName(name, new PageRequest(page, size));
    }
}
