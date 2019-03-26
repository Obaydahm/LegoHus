/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Commands;

import Logic.Exceptions.LegoException;
import Presentation.Command;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Obaydah Mohamad
 */
public class LogoutCommand extends Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws LegoException, IOException {
        if(request.getSession().getAttribute("user") != null){
            request.getSession().removeAttribute("user");
            response.sendRedirect("/LegoHus");
        }else{
            response.sendRedirect("/LegoHus/online");
        }
    }
    
}
