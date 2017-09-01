package demo.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import demo.model.Item;
import demo.model.Restaurant;
import demo.model.RestaurantRepository;
import demo.service.SearchRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping(value = "/foodDeliveryAPI")
public class RestaurantSearchingController {
//    @Autowired
//    RestaurantRepository repository;

//    @Autowired
//    private MongoTemplate mongoTemplate;

    @Autowired
    private SearchRestaurantService searchRestaurantService;

//    @RequestMapping(value = "/restaurants", method = RequestMethod.POST)
//    @ResponseStatus(HttpStatus.CREATED)
//    public void upload(@RequestBody List<Restaurant> restaurantList) throws IOException{
//        ObjectMapper mapper = new ObjectMapper();
//        TypeReference<List<Restaurant>> mapType = new TypeReference<List<Restaurant>>(){};
//        InputStream is = TypeReference.class.getResourceAsStream("/json/restaurants.json");
//        try{
//            List<Restaurant> restaurantsList = mapper.readValue(is, mapType);
//            repository.save(restaurantList);
//        }
//        catch (IOException e){
//            System.out.print(e.getMessage());
//        }
////        this.searchRestaurantService.saveRestaurants(restaurantList);
//    }

//    @RequestMapping(value = "/restaurants", method = RequestMethod.POST)
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<?> add(@RequestBody String jsonString){
//        Document doc = Document.parse(jsonString);
//        mongoTemplate.insert(doc);
//        return new ResponseEntity<>( null, HttpStatus.CREATED);
//    }

//    @RequestMapping(value = "/restaurants/{name}", method = RequestMethod.GET)
//    public List<Item> findRestaurant(@PathVariable String name, @RequestParam(value = "page") int page,
//                                 @RequestParam (value = "size") int size){
//      return searchRestaurantService.findByName(name, new PageRequest(page, size));
//    }
}
