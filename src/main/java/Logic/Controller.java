/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.Order;
import Data.User;
import Logic.Exceptions.LegoException;
import java.util.ArrayList;

/**
 *
 * @author Obaydah Mohamad
 */
public interface Controller {
    public User validateLogin(String username, String password) throws LegoException;
    public void createUser(String username, String password, String passwordAgain) throws LegoException;
    public void createOrder(int user_id, int height, int width, int length) throws LegoException;
    public Order getOrder(int id) throws LegoException;
    public ArrayList<Order> getOrders(int user_id) throws LegoException;    
    public ArrayList<Order> getOrdersAdmin() throws LegoException;
    public void markShippedAdmin(int id) throws LegoException;

    
}
