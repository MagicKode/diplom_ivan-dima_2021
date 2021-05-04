package tms.diplom_ivan_dima.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tms.diplom_ivan_dima.model.Basket;
import tms.diplom_ivan_dima.model.Product;

import java.util.List;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Long> {

    List<Product> findAllByUserId(long id);

    Basket getByUserId(long userId);

    Basket findByUserId(long userId);

    boolean existByUserId(long userId);

    void deleteByUserId(long userId);

}
