package tms.diplom_ivan_dima.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductForBasket {

    private Product product;
    private long userId;
    private long basketId;


    public ProductForBasket(Product product, long userId) {
        this.product = product;
        this.userId = userId;
    }
}
