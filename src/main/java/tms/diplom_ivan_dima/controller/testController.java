package tms.diplom_ivan_dima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import tms.diplom_ivan_dima.Model.Basket;
import tms.diplom_ivan_dima.Model.Product;

@Controller
@RequestMapping(path = "/product")
public class testController {

    @GetMapping(path = "/test")
    public ModelAndView modelAndView(@ModelAttribute Basket prod, ModelAndView modelAndView) {
        modelAndView.setViewName("/product/test");
        return modelAndView;
    }

    @PostMapping(path = "/test")
    public ModelAndView modelAndViewPost(@ModelAttribute("prod") Basket prod, ModelAndView modelAndView) {
        modelAndView.setViewName("/product/test");
        return modelAndView;
    }
}
