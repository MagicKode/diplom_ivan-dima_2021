package tms.diplom_ivan_dima.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table

public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long userId;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Product> productSet;

    public Basket(Set<Product> productSet) {
        this.productSet = productSet;
    }

    public Set<Product> getProductSet() {
        return productSet;
    }

    public Basket(long userId, Set<Product> productSet) {
        this.userId = userId;
        this.productSet = productSet;
    }

    public Basket(long userId) {
        this.userId = userId;
    }
}
