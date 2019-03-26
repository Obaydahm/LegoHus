/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Commands;

import Data.Order;
import Data.User;
import Logic.Controller_Impl;
import Logic.Exceptions.LegoException;
import Presentation.Command;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Obaydah Mohamad
 */
public class ShowOrderCommand extends Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Controller_Impl ctrl = new Controller_Impl();
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) request.getRequestDispatcher("/").forward(request, response);
        int order_id = Integer.parseInt(request.getParameter("order_id"));
        try {
            request.setAttribute("order", ctrl.getOrder(order_id));
        } catch (LegoException | NullPointerException ex) {
            request.setAttribute("error", "Noget gik galt. Prøv igen.");
        }
        Order order = (Order) request.getAttribute("order");

        request.getRequestDispatcher("/online/showorder.jsp?order_id=" + order_id).forward(request, response);
    }
    
}
