import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class StateRepositoryImpl implements StateRepository {

  @PersistenceContext
  private EntityManager manager;
  
  public List<State> findAll() {
    return manager.createQuery("from State", State.class).getResultList();  
  }
}