package tms.diplom_ivan_dima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import tms.diplom_ivan_dima.Model.Order;
import tms.diplom_ivan_dima.Services.OrderService;

@Controller
@RequestMapping(path = {"/order", "/user", "/"})
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(path = "/newOrder")
    public ModelAndView newOrderPage(@ModelAttribute("ModelAttribute")Order order, ModelAndView modelAndView){
        modelAndView.setViewName("/order/newOrder");
        return modelAndView;
    }

    @PostMapping(path = "/newOrder")
    public ModelAndView createNewOrder(@ModelAttribute("ModelAttribute") Order order, ModelAndView modelAndView){
        modelAndView.setViewName("redirect:/userCabinet");
        orderService.addNewOrder(order);
        return modelAndView;
    }
}
