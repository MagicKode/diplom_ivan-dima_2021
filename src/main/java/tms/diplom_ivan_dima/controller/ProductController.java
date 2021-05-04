package tms.diplom_ivan_dima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import tms.diplom_ivan_dima.model.Basket;
import tms.diplom_ivan_dima.model.BasketList;
import tms.diplom_ivan_dima.model.Product;
import tms.diplom_ivan_dima.services.BasketService;
import tms.diplom_ivan_dima.services.ProductService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping({"/product", "/order"})
public class ProductController {

    @Autowired
    BasketService basketService;

    @Autowired
    BasketList basketList;

    @Autowired
    ProductService productService;

    @GetMapping(path = "/product/{productId}")  //??
    public ModelAndView showProductTicket(@PathVariable Long productId, ModelAndView modelAndView) {
        Product productfoForBasket = productService.getProductById(productId);
        modelAndView.addObject("productForBasket", productfoForBasket);
        modelAndView.setViewName("/product/productTicket");
        return modelAndView;
    }

    @PostMapping(path = "/productTicket/{productId}")
    public ModelAndView putProductInBasket(@PathVariable Long productId, ModelAndView modelAndView, HttpSession httpSession) {
        Product productForBasket = productService.getProductById(productId);
        Basket userBasket = (Basket) httpSession.getAttribute("userBasket");
        if (!basketService.isProductExistInBasket(userBasket.getProductSet(), productForBasket)) {
            userBasket.getProductSet().add(productForBasket);
            modelAndView.addObject("addedProductToBasketMessage", "product " + productForBasket.getName() + " added");
        } else {
            modelAndView.addObject("productAlreadyAdded", "Product " + " is already int basket");
        }
        modelAndView.addObject("productForBasket", productForBasket);
        modelAndView.setViewName("/product/productTicket");
        return modelAndView;

    }


}
