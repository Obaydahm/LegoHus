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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Obaydah Mohamad
 */
public class ShowOrdersCommand extends Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("ahlen");
        Controller_Impl ctrl = new Controller_Impl();
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) request.getRequestDispatcher("/index.jsp").forward(request, response);
        User user = (User) session.getAttribute("user");
        try {
            user.setOrders(ctrl.getOrders(user.getId()));
            System.out.println("hej");
        } catch (LegoException ex) {
            request.setAttribute("error", "Noget gik galt. Prøv igen.");
            ex.printStackTrace();
            System.out.println("farvel");
        }
        session.setAttribute("user", user);
        request.getRequestDispatcher("/online/showorders.jsp").forward(request, response);
    }
    
}
