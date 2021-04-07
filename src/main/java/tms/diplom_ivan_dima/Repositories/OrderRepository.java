package tms.diplom_ivan_dima.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import tms.diplom_ivan_dima.Model.Order;
import tms.diplom_ivan_dima.Model.OrderStatus;
import tms.diplom_ivan_dima.Model.User;

import java.util.List;

@Component
@Repository
public interface OrderRepository extends JpaRepository <Order, Long>{

    List<Order> findOrderByUser(User user);
    List<Order> findOrderByOrderStatus(OrderStatus orderStatus);

    void deleteOrderByUser(User user);
    void deleteOrderByOrderStatus(OrderStatus orderStatus);
}
