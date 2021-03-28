package tms.diplom_ivan_dima.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import tms.diplom_ivan_dima.Model.Order;

@Component
@Repository
public interface OrderRepository extends JpaRepository <Order, Long>{
}
