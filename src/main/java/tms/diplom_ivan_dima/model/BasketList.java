package tms.diplom_ivan_dima.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Component
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "basket")

public class BasketList {


    private static List<Basket> basketList = new ArrayList<>();

    public void addProductToProductList(Basket basket) {
        basketList.add(basket);
    }

    public Basket getProdustByUserId(long userId) {
        for (Basket basket : basketList) {
            if (basket.getUserId() == userId) {
                return basket;
            }
        }
        return null;
    }

    public void removeBasketByUserId(long userId) {
        for (Basket basket : basketList) {
            if (basket.getUserId() == userId) {
                basketList.remove(basket);
            }
        }
    }

    public boolean basketExistByUserId(long userId) {
        for (Basket basket : basketList) {
            if (basket.getUserId() == userId) {
                return true;
            }
        }
        return false;
    }
}
