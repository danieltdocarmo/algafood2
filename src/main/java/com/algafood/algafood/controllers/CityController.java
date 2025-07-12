import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.algafood.algafood.domain.entities.City;

@RestController
@RequestMapping("/city")
public class CityController {

  @Autowired
  private CityService cityService;

  @GetMapping
  public ResponseEntity<List<City>> list() {
    return ResponseEntity.ok(cityService.list());
  }

  @GetMapping("/{id}")
  public ResponseEntity<City> findById(@PathVariable Long id) {
    final var foundCity = cityService.findById(id);

    return foundCity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<City> save(@RequestBody City city) {
    return ResponseEntity.ok(cityService.save(city));
  }

  @PutMapping("/{id}")
  public ResponseEntity<City> update(@PathVariable Long id, @RequestBody City city) {
    try {
      final var updatedCity = cityService.update(city, id);
      return ResponseEntity.status(HttpStatus.CREATED).body(updatedCity);
    } catch (EntityNotFoundException e) {
      return ResponseEntity.notFound().build();
    }
  }
}