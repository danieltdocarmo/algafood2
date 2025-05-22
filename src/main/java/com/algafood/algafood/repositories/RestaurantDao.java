public interface RestaurantDao {

    Restaurant save(Restaurant restaurnt);

    void remove(Restaurant restaurant);

    Restaurant update(Restaurant restaurant); 

    List<Restaurant> list();
    
}
