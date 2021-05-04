package tms.diplom_ivan_dima.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tms.diplom_ivan_dima.model.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {

    void deleteProductByName(String Name);

    Product getProductByName(String name);

}
