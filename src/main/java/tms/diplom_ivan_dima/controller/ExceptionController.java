package tms.diplom_ivan_dima.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tms.diplom_ivan_dima.exceprions.UserNotFoundException;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(UserNotFoundException.class)
    public String userNotFound(UserNotFoundException userNotFoundException, Model model){
        model.addAttribute("message", userNotFoundException.getMessage());
        return "errorPage";
    }
}
