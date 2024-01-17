package ExpressLogistic.demo.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ExpressLogistic.demo.domaine.Order;
import ExpressLogistic.demo.repository.OrderRepository;

@Service
public class OrderService {
    // Propriété du repository 
    private OrderRepository orderRepository; 

    // Injection du repository 
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // Création d'un resource 
    public Order create(Order order) {
        return this.orderRepository.save(order);
    }

    // Récupération d'une resource 
    public Order findOrder(String id) {
        Optional<Order> order =  this.orderRepository.findById(id);

        if (order.isPresent()) {
            return order.get(); 
        }
        return null;
    }

    // Récupération de toutes les resources (orders)
    public Iterable<Order> findOrders() {
        return this.orderRepository.findAll();
    }

    // Suppression d'une resource (commande)
    public ResponseEntity<Void> delete(Order order) {
        this.orderRepository.delete(order);
        return ResponseEntity.noContent().build();
    }
}
