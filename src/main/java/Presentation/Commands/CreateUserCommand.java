/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Commands;

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
public class CreateUserCommand extends Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Controller_Impl ctrl = new Controller_Impl();
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) request.getRequestDispatcher("/index.jsp").forward(request, response);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String passwordAgain = request.getParameter("passwordagain");
        
        try{
            ctrl.createUser(username, password, passwordAgain);
            request.setAttribute("error", "Din bruger er blevet oprettet");
            request.getRequestDispatcher("/").forward(request, response);
        }catch(LegoException e){
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
        
    }
    
}
