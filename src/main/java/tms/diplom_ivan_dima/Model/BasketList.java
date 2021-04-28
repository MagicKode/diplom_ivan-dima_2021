package tms.diplom_ivan_dima.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
@AllArgsConstructor

public class BasketList { //создаем Карзину-список


    private static List<Basket> basketList = new ArrayList<>();

    public void addProductROProductList (Basket basket){
        basketList.add(basket);
    }

    public Basket getProdustByUserId(long userId){
        for (Basket basket : basketList){
            if (basket.getUserId() == userId){
                return basket;
            }
        }
        return null;
    }

    public void removeBasketByUserId (long userId){
        for (Basket basket : basketList){
            if (basket.getUserId() == userId){
                basketList.remove(basket);
            }
        }
    }

    public boolean basketExistByUserId(long userId){
        for (Basket basket : basketList){
            if (basket.getUserId() == userId){
                return true;
            }
        }
        return false;
    }
}
