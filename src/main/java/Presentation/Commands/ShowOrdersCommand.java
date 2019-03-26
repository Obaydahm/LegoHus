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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Obaydah Mohamad
 */
public class ShowOrdersCommand extends Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws LegoException, IOException {
        Controller_Impl ctrl = new Controller_Impl();
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) response.sendRedirect("/LegoHus/index.jsp");
        User user = (User) session.getAttribute("user");
        user.setOrders(ctrl.getOrders(user.getId()));
        session.setAttribute("user", user);
        response.sendRedirect("/LegoHus/online/showorders.jsp");
    }
    
}
