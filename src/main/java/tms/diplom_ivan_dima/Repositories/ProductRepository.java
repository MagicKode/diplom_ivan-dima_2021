package tms.diplom_ivan_dima.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tms.diplom_ivan_dima.Model.Product;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {

    void deleteProductByName(String Name);

    Product getProductByName(String name);

}
