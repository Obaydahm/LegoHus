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
    public void execute(HttpServletRequest request, HttpServletResponse response) throws LegoException, IOException {
        Controller_Impl ctrl = new Controller_Impl();
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) response.sendRedirect("/LegoHus/index.jsp");
        int order_id = Integer.parseInt(request.getParameter("order_id"));
        request.setAttribute("order", ctrl.getOrder(order_id));
        Order order = (Order) request.getAttribute("order");

        try{
            RequestDispatcher rd = request.getRequestDispatcher("/online/showorder.jsp?order_id=" + order_id);
            rd.forward(request, response);
        }catch(ServletException e){
            e.printStackTrace();
        }
    }
    
}
