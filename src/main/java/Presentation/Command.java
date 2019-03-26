/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Logic.Exceptions.LegoException;
import Presentation.Commands.AdminMarkShippedCommand;
import Presentation.Commands.AdminShowOrdersCommand;
import Presentation.Commands.CreateOrderCommand;
import Presentation.Commands.CreateUserCommand;
import Presentation.Commands.LoginCommand;
import Presentation.Commands.LogoutCommand;
import Presentation.Commands.ShowOrderCommand;
import Presentation.Commands.ShowOrdersCommand;
import Presentation.Commands.UnknownCommand;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Obaydah Mohamad
 */
public abstract class Command {
    /**
     * Abstract execute method which defines what to be done with the request and
     * response in the respecitive commands. Usually processes input from jsp-files
     * and redirects to other jsp-files.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException ServletException if a servlet-specific error occurs
     * @throws IOException IOException if an I/O error occurs
     */
    public abstract void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    
    /**
     * Searches request for the value of parameter 'command', then checks the 
     * commands-map for a key with the same value and returns the value for the key.
     * @param request servlet request 
     * @return the correct Command; the value of the key which is the value of
     * the command-parameter
     */
    
    public static Command from(HttpServletRequest request) {
        Command c;
        String origin = request.getParameter("command");
        Map<String, Command> commands = new HashMap();
        commands.put("login", new LoginCommand());
        commands.put("createuser", new CreateUserCommand());
        commands.put("logout", new LogoutCommand());
        commands.put("showorders", new ShowOrdersCommand());
        commands.put("showorder", new ShowOrderCommand());
        commands.put("createorder", new CreateOrderCommand());
        commands.put("adminshoworders", new AdminShowOrdersCommand());        
        commands.put("adminmarkshipped", new AdminMarkShippedCommand());
        c = commands.getOrDefault(origin, new UnknownCommand());

        return c;
    }
    
    
}
