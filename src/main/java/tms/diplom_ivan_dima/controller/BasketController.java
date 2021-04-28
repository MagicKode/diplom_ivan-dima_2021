package tms.diplom_ivan_dima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import tms.diplom_ivan_dima.Model.Basket;
import tms.diplom_ivan_dima.Services.BasketService;
import tms.diplom_ivan_dima.Services.OrderService;
import tms.diplom_ivan_dima.Services.UserService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(params = "/order")
public class BasketController {

    @Autowired
    BasketService basketService;

    @Autowired
    OrderService orderService;

    @Autowired
    UserService userService;

    @GetMapping(params = "/basket")
    public ModelAndView showBasket(ModelAndView modelAndView, HttpSession httpSession) {
        Basket userBasket = (Basket) httpSession.getAttribute("userBasket");
        modelAndView.addObject("userBasket", userBasket);
        modelAndView.setViewName("/order/basket");
        return modelAndView;
    }
}
