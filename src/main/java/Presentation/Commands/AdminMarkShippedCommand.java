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
public class AdminMarkShippedCommand extends Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Controller_Impl ctrl = new Controller_Impl();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null || user.getAdmin() == 0) request.getRequestDispatcher("/index.jsp").forward(request, response);
        try{
            int id = Integer.parseInt(request.getParameter("order_id"));
            
            try {
                ctrl.markShippedAdmin(id);
            } catch (LegoException | NullPointerException ex) {
                request.setAttribute("error", "Noget gik galt. Prøv venligst igen");
            }
            
            RequestDispatcher rd = request.getRequestDispatcher("/FrontController?command=showorder&order_id=" + id);
            rd.forward(request, response);
        }catch(NumberFormatException ex){
            request.setAttribute("error", "Ordrenummeret er ikke gyldigt");
            request.getRequestDispatcher("/FrontController?command=showorders").forward(request, response);
        }
        
        
    }
    
}
