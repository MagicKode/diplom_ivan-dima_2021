package tms.diplom_ivan_dima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import tms.diplom_ivan_dima.model.Basket;
import tms.diplom_ivan_dima.services.ProductService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/book")
public class RemoveProductFromBasketController {

    @Autowired
    ProductService productService;

    @PostMapping(path = "/removeProductFromBasket/{productId}")
    public ModelAndView removeProductFromBasket(@PathVariable long productId, ModelAndView modelAndView, HttpSession httpSession) {
        Basket userBasket = (Basket) httpSession.getAttribute("userBasket");
        ((Basket) httpSession.getAttribute("userBasket")).getProductSet().remove(productService.getProductById(productId));
        modelAndView.addObject("userBasket", httpSession.getAttribute("userBasket"));
        modelAndView.setViewName("/order/basket");
        return modelAndView;
    }
}
