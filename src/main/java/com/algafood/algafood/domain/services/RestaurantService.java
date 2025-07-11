import com.algafood.algafood.domain.repositories.RestaurantRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.algafood.algafood.domain.entities.Restaurant;

@Service
public class RestaurantService {

  @Autowired
  private RestaurantRepository restaurantRepository;

  public List<Restaurant> findAll() {
    return restaurantRepository.list();
  }

  public Optional<Restaurant> findById(String id) {
    return Optional.ofNullable(restaurantRepository.findById(id));
  }
  
  @Transactional
  public Restaurant saveOrUpdate(Restaurant restaurant) {
    return restaurantRepository.saveOrUpdate(restaurant);
  }

  @Transactional
  public void delete(String id) {
    final var restaurantToRemove = findById(id)
      .orElseThrow(() -> new EmptyResultDataAccessException(1));
    restaurantRepository.remove(restaurantToRemove);
  }

  public Restaurant update(String id, Restaurant newRestaurant) {
      final var foundRestaurant = findById(id);

      return foundRestaurant.map(oldRestaurant -> {
          BeanUtils.copyProperties(newRestaurant, oldRestaurant, "id");
          return saveOrUpdate(oldRestaurant);
      }).orElseThrow(() -> new EmptyResultDataAccessException(1));
  }

}