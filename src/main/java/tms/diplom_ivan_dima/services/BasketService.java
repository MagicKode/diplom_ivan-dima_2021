package tms.diplom_ivan_dima.services;

import org.springframework.stereotype.Service;
import tms.diplom_ivan_dima.model.Product;

import java.util.Set;

@Service
public class BasketService {

    public boolean isProductExistInBasket(Set<Product> productSet, Product product) {
        for (Product productInBasketSet : productSet) {
            return productInBasketSet.equals(product);
        }
        return false;
    }
}
