package tms.diplom_ivan_dima.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import tms.diplom_ivan_dima.model.Order;
import tms.diplom_ivan_dima.model.OrderStatus;
import tms.diplom_ivan_dima.model.Product;
import tms.diplom_ivan_dima.model.User;

import java.util.List;

@Component
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findOrderByUser(User user);

    List<Order> findOrderByOrderStatus(OrderStatus orderStatus);

    List<Order> findOrdersByProductListIsContaining(Product product);

    void deleteOrderByUser(User user);

    void deleteOrderByOrderStatus(OrderStatus orderStatus);
}
