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
public class LoginCommand extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws LegoException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) response.sendRedirect("LegoHus/index.jsp");
        
        Controller_Impl ctrl = new Controller_Impl();
        User user = null;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        user = ctrl.validateLogin(username, password);
        if (user != null) {
            session.setAttribute("user", user);
        } else {
            request.setAttribute("error", "Brugernavn og/eller adgangskode stemmer ikke!");
        }
        RequestDispatcher rd = request.getRequestDispatcher("/");
        try {
            rd.forward(request, response);
        } catch (ServletException ex) {
            ex.printStackTrace();
        }

    }

}
