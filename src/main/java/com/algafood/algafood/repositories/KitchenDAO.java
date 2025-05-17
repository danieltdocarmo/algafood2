import com.algafood.algafood.domain.entities.Kitchen;

@Repository
public class KitchenDao{

    @PersistenceContext
    private EntityManager persistence;


    public List<Kitchen> list() {
        return persistence.createQuery("from Kitchen", Kitchen.class).getResultList();
    }
}