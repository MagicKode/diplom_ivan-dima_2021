package tms.diplom_ivan_dima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import tms.diplom_ivan_dima.model.Cart;
import tms.diplom_ivan_dima.model.Product;
import tms.diplom_ivan_dima.services.ProductService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/cart")
public class CartController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ModelAndView getCart(ModelAndView modelAndView, HttpSession httpSession){
        Cart cart = (Cart)httpSession.getAttribute("cart");
        modelAndView.addObject("totalPrice", cart.getTotalPrice());
        if(!cart.getAllProducts().isEmpty()){
            modelAndView.addObject("cartItems", cart.getAllProducts());
        } else {
            modelAndView.addObject("cartIsEmpty", "Your cart is empty");
        }
        modelAndView.setViewName("cart");
        return modelAndView;
    }

    @PostMapping
    public ModelAndView cartAction(@RequestParam(value = "productId", required = false)Long productId,
                                   ModelAndView modelAndView, HttpSession httpSession){
        Product byId = productService.getProductById(productId);
        Cart cart = (Cart)httpSession.getAttribute("cart");
        cart.addProductToCart(byId);
        modelAndView.setViewName("redirect:/store/item/view/" + productId);
        return modelAndView;
    }

    @PostMapping("/remove")
    public ModelAndView removeFromCart(@RequestParam(value = "productId", required = false)Long productId,
                                       ModelAndView modelAndView, HttpSession httpSession){
        Product removeById = productService.getProductById(productId);
        Cart cart = (Cart)httpSession.getAttribute("cart");
        cart.removeProductFromCart(removeById);
        modelAndView.setViewName("redirect:/cart");
        return modelAndView;
    }
}
