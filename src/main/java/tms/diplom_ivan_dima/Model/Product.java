package tms.diplom_ivan_dima.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Objects;
@Data
@Entity
@Component
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;// ID товара
    private String name; //наименование товара
    private String description;

    @ManyToOne
    private double productPtice;


    private Category category; //категория товара
    private ProductStatus productStatus; //статус товара

    public Product(String name) {
        this.name = name;
    }

    public Product(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                Double.compare(product.productPtice, productPtice) == 0 &&
                Objects.equals(name, product.name) &&
                Objects.equals(description, product.description) &&
                Objects.equals(category, product.category) &&
                productStatus == product.productStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, productPtice, category, productStatus);
    }
}
