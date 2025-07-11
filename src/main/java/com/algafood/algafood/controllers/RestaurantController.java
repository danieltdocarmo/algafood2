import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.algafood.algafood.domain.entities.Restaurant;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

   @Autowired
   private RestaurantService restaurantService;

   @GetMapping
   public List<Restaurant> getAllRestaurants()   {
       return restaurantService.findAll();
   }

  @GetMapping("/{id}")
  public ResponseEntity<Restaurant> getRestaurantById(@PathVariable String id) {
      final var restaurantFound = restaurantService.findById(id);

    return restaurantFound.map(restaurant -> ResponseEntity.ok(restaurant)).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Restaurant> create(@RequestBody Restaurant restaurant) {
    return ResponseEntity.ok(restaurantService.saveOrUpdate(restaurant));
  }
}