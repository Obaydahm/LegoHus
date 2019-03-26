/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Commands;

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
public class CreateOrderCommand extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Controller_Impl ctrl = new Controller_Impl();
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) request.getRequestDispatcher("/index.jsp").forward(request, response);
        
        User user = (User) session.getAttribute("user");
        int height = 0;
        int width = 0;
        int length = 0;
        try {
            
            height = Integer.parseInt(request.getParameter("height"));
            width = Integer.parseInt(request.getParameter("width"));
            length = Integer.parseInt(request.getParameter("length"));
            
            if(height < 4 || width < 4 || length < 4){
                request.setAttribute("error", "Målene skal minimum være 4 hver");
                request.getRequestDispatcher("/online/neworder.jsp").forward(request, response);
            }else{
                try {
                    ctrl.createOrder(user.getId(), height, width, length);
                } catch (LegoException ex) {
                    Logger.getLogger(CreateOrderCommand.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.getRequestDispatcher("/FrontController?command=showorders").forward(request, response);
            }
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Du må kun indtaste tal");
            request.getRequestDispatcher("/online/neworder.jsp").forward(request, response);
            e.printStackTrace();
        }
    }

}
