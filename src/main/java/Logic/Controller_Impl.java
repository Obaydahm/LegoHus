/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.Mappers.OrderMapper;
import Logic.Exceptions.LegoException;
import Data.Mappers.UserMapper;
import Data.Order;
import Data.User;
import Logic.Exceptions.LegoException;
import java.util.ArrayList;

/**
 *
 * @author Obaydah Mohamad
 */
public class Controller_Impl implements Controller{

    @Override
    public User validateLogin(String username, String password) throws LegoException {
        return UserMapper.validateLogin(username, password);
    }

    @Override
    public void createUser(String username, String password, String passwordAgain) throws LegoException {
        UserMapper.CreateUser(username, password, passwordAgain);
    }

    @Override
    public void createOrder(int user_id, int height, int width, int length) throws LegoException {
        OrderMapper.createOrder(user_id, height, width, length);
    }

    @Override
    public Order getOrder(int id) throws LegoException {
        return OrderMapper.getOrder(id);
    }

    @Override
    public ArrayList<Order> getOrders(int user_id) throws LegoException {
        return OrderMapper.getOrders(user_id);
    }

    @Override
    public ArrayList<Order> getOrdersAdmin() throws LegoException {
        return OrderMapper.getOrdersAdmin();
    }

    @Override
    public void markShippedAdmin(int id) throws LegoException {
        OrderMapper.markShippedAdmin(id);
    }
    
}
