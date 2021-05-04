package tms.diplom_ivan_dima.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tms.diplom_ivan_dima.model.Order;
import tms.diplom_ivan_dima.model.OrderStatus;
import tms.diplom_ivan_dima.model.User;
import tms.diplom_ivan_dima.repositories.OrderRepository;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public void addNewOrder(Order order) { //добавляем (созраняем) заказ
        orderRepository.save(order);
    }

    public void deleteOrderById(long id) { //удаление заказа по id
        orderRepository.deleteById(id);
    }

    public void deleteAllOrdersByUser(User user) { //удаление заказа по Юзеру
        orderRepository.deleteOrderByUser(user);
    }

    public void deleteAllOrdersByStatus(OrderStatus orderStatus) {
        orderRepository.deleteOrderByOrderStatus(orderStatus);
    }

    public Order findOrderById(long id) { //найти заказ по id
        return orderRepository.getOne(id);
    }

    public List<Order> findOrderByUser(User user) { //найти заказ по Юзеру
        return orderRepository.findOrderByUser(user);
    }

    public List<Order> findOrderByStatus(OrderStatus orderStatus) {
        return orderRepository.findOrderByOrderStatus(orderStatus);
    }

    public void updateOrderStatusBuId(long id, OrderStatus orderStatus) {
        orderRepository.getOne(id).setOrderStatus(orderStatus);
    }

    public void changeUserInOrderById(long id, User newUser) { // изменить (обновить) юзера в заказе по ID
        orderRepository.getOne(id).setUser(newUser);
    }

    public List<Order> findAllOrders(Order order) { //вывести Все заказы
        return orderRepository.findAll();
    }

}
