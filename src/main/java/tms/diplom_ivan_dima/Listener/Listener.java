package tms.diplom_ivan_dima.Listener;

import tms.diplom_ivan_dima.Model.Cart;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class Listener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent sessionEvent){
        sessionEvent.getSession().setAttribute("cart", new Cart());
    }
}
