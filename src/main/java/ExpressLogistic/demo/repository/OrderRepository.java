package ExpressLogistic.demo.repository;

import org.springframework.data.repository.CrudRepository;

import ExpressLogistic.demo.domaine.Order;

public interface OrderRepository extends CrudRepository<Order, String> {
    
    
}
