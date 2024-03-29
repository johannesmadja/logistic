package ExpressLogistic.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ExpressLogistic.demo.domaine.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, String> {
    
    
}
