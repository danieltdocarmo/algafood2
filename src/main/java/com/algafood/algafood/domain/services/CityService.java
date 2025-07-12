import com.algafood.algafood.domain.repositories.CityRepository;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.algafood.algafood.domain.entities.City;
import java.util.List;

@Service
public class CityService{

   @Autowired
   private CityRepository cityRepository;

   public List<City> list() {
     return cityRepository.list();
   }

  public Optional<City> findById(Long id) {
    return Optional.ofNullable(cityRepository.findById(id));
  }

  public City save(City city) {
    return cityRepository.saveOrUpdate(city);
  }

  public City update(City city, Long id) {
    final var foundCity = findById(id).orElseThrow(() -> new EntityNotFoundException("City not found"));

    BeanUtils.copyProperties(city, foundCity, "id");
    
    return cityRepository.saveOrUpdate(foundCity);
  }

  public void delete(Long id) {
    cityRepository.delete(id);
  }
}