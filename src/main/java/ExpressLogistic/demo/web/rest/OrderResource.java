package ExpressLogistic.demo.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ExpressLogistic.demo.domaine.Order;
import ExpressLogistic.demo.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderResource {
    // Propriété du service 
    private final OrderService orderService;

    //Injection du service 
    public OrderResource(OrderService orderService) {
        this.orderService = orderService;
    }

    // Création d'une resource 
    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        this.orderService.create(order);
        return ResponseEntity.ok("Commande crée avec succès ! ");
    }

    // Récupération d'une resource 
    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrder(@PathVariable String id) {
        Order order = this.orderService.findOrder(id);

        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Récupération de toutes les resources(commandes)
    @GetMapping
    public Iterable<Order> getOrders() {
        return this.orderService.findOrders();
    }

    // Mise à jour d'un resource 
    @PutMapping("/{orderId}")
    public ResponseEntity<String> updateOrder(@RequestBody Order order, @PathVariable String id) {
        // Récupération de la resource 
        Order oldOrder = this.orderService.findOrder(id);

        if (oldOrder != null) {
            oldOrder.setName(order.getName());
            oldOrder.setStatus(order.getStatus());  
            oldOrder.setCreated(order.getCreated());
            oldOrder.setDeadLine(order.getDeadLine());

            return ResponseEntity.ok("Commande mise à jour !");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Suppression d'une resource 
    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable String orderId) {
        // Récupération de la resource 
        Order order = this.orderService.findOrder(orderId);

        if (order != null ) {
            this.orderService.delete(order);
            ResponseEntity.ok("Commande supprimée avec succès ! ");
        }
        return ResponseEntity.notFound().build();
    }
}
