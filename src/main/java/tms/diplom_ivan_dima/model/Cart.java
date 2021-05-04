package tms.diplom_ivan_dima.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cart {

    private float totalPrice;

    private List<Product> cartOfProducts = new ArrayList<>();

    public void addProductToCart(Product product){
        cartOfProducts.add(product);
        totalPrice += product.getProductPrice();
    }

    public void removeProductFromCart(Product product){
        cartOfProducts.remove(product);
        totalPrice = totalPrice - product.getProductPrice();
    }

    public List<Product> getAllProducts(){
        return new ArrayList<>(cartOfProducts);
    }

    public void removeAllProducts(){
        totalPrice = 0;
        cartOfProducts.clear();
    }

    public float getTotalPrice(){
        return totalPrice;
    }


}
