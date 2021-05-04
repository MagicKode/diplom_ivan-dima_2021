package tms.diplom_ivan_dima.listener;

import tms.diplom_ivan_dima.model.Cart;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class Listener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent sessionEvent){
        sessionEvent.getSession().setAttribute("cart", new Cart());
    }
}
