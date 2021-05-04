package tms.diplom_ivan_dima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import tms.diplom_ivan_dima.model.User;
import tms.diplom_ivan_dima.services.UserService;

@Controller
@RequestMapping("/user")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/reg")
    public ModelAndView getRegPage(ModelAndView modelAndView) {
        modelAndView.setViewName("/user/reg");
        modelAndView.addObject("ModelAttribute", new UserService());
        return modelAndView;
    }

    @PostMapping(path = "/reg")
    public ModelAndView postRegPage(@ModelAttribute("ModelAttribute") User user, ModelAndView modelAndView) {
        modelAndView.setViewName("/iser/reg");
        if (!userService.isUserExistByUserName(user.getUserName())) {
            userService.addUser(user);
            modelAndView.setViewName("redirect:/user/outh");
        } else {
            modelAndView.addObject("userIsExistsError", "User with this " + " username is already exists!");
        }
        return modelAndView;
    }

    @GetMapping(path = "/auth")
    public ModelAndView getAuthPage(@ModelAttribute("ModelAttribute") User user, ModelAndView modelAndView) {
        modelAndView.setViewName("/user/auth");
        return modelAndView;
    }

    @PostMapping(path = "/auth")
    public ModelAndView postAuthPage(@ModelAttribute("ModelAttribute") User user, ModelAndView modelAndView) {
        modelAndView.setViewName("/user/auth");
        if (userService.isUserExistByUserName(user.getUserName())) {
            if (userService.isPasswordCorrect(user.getUserName(), user.getPassword())) {
                modelAndView.addObject("userAuthOK", "User Authorization OK");
                modelAndView.setViewName("redirect:/user/auth");
            } else {
                modelAndView.addObject("Password incorrect", "Password incorrect");
            }
        } else {
            modelAndView.addObject("Name incorrect", "Name incorrect");
        }
        return modelAndView;
    }
}
