import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/states")
public class StateController{

   @Autowired
   private StateRepository stateRepository;

   @GetMapping
   @ResponseBody
   public List<State> list() {
     return stateRepository.findAll();
   }
}