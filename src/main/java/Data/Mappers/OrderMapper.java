/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Mappers;

import Data.DB;
import Data.House;
import Data.Order;
import Logic.Calculator;
import Logic.Exceptions.LegoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Obaydah Mohamad
 */
public class OrderMapper {
    
    /*public static void main(String[] args) {
        for(int i = 0; i < 26; i++){
            try {
                OrderMapper.createOrder(1, new Random().nextInt(22) + 4, new Random().nextInt(22) + 4, new Random().nextInt(22) + 4);
            } catch (LegoException ex) {
                ex.printStackTrace();
            }
        }
    }*/

    public static void createOrder(int user_id, int height, int width, int length) throws LegoException {
        try {
            LocalDateTime date = LocalDateTime.now();
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            Connection conn = DB.connection();
            String query = "INSERT INTO orders (user_id, dateplaced, height, width, length) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement p = conn.prepareStatement(query);
            p.setInt(1, user_id);
            p.setString(2, date.format(dateFormat));
            p.setInt(3, height);
            p.setInt(4, width);
            p.setInt(5, length);
            p.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new LegoException(e.getMessage());
        }
    }

    public static Order getOrder(int id) throws LegoException {
        Calculator calc = new Calculator();
        Order order = null;

        try {
            Connection conn = DB.connection();
            String query = "SELECT * FROM `orders` WHERE id = ?";
            PreparedStatement p = conn.prepareStatement(query);
            p.setInt(1, id);
            ResultSet rs = p.executeQuery();

            if (rs.next()) {
                int id_ = rs.getInt("id");
                int user_id = rs.getInt("user_id");
                String datePlaced = rs.getString("dateplaced");
                String dateShipped = rs.getString("dateshipped");
                int height = rs.getInt("height");
                int width = rs.getInt("width");
                int length = rs.getInt("length");
                order = new Order(id, height, width, length, datePlaced, dateShipped, calc.buildHouse(height, width, length));
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new LegoException(e.getMessage());
        }

        return order;
    }

    public static ArrayList<Order> getOrders(int user_id) throws LegoException {
        ArrayList<Order> orders = new ArrayList<Order>();

        try {
            Connection conn = DB.connection();
            String query = "SELECT * FROM `orders` WHERE user_id = ? ORDER BY id DESC";
            PreparedStatement p = conn.prepareStatement(query);
            p.setInt(1, user_id);
            ResultSet rs = p.executeQuery();
            
            Order order = null;
            int id = 0;
            int user_id_ = 0;
            String datePlaced = "";
            String dateShipped = null;
            int height = 0;
            int width = 0;
            int length = 0;

            while (rs.next()) {
                id = rs.getInt("id");
                datePlaced = rs.getString("dateplaced");
                dateShipped = rs.getString("dateshipped");
                height = rs.getInt("height");
                width = rs.getInt("width");
                length = rs.getInt("length");
                orders.add(new Order(id, height, width, length, datePlaced, dateShipped));
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new LegoException(e.getMessage());
        }

        return orders;
    }
    
    public static ArrayList<Order> getOrdersAdmin() throws LegoException {
        ArrayList<Order> orders = new ArrayList<Order>();

        try {
            Connection conn = DB.connection();
            String query = "SELECT * FROM `orders` ORDER BY id DESC";
            PreparedStatement p = conn.prepareStatement(query);
            ResultSet rs = p.executeQuery();
            
            Order order = null;
            int id = 0;
            int user_id_ = 0;
            String datePlaced = "";
            String dateShipped = null;
            int height = 0;
            int width = 0;
            int length = 0;

            while (rs.next()) {
                id = rs.getInt("id");
                datePlaced = rs.getString("dateplaced");
                dateShipped = rs.getString("dateshipped");
                height = rs.getInt("height");
                width = rs.getInt("width");
                length = rs.getInt("length");
                orders.add(new Order(id, height, width, length, datePlaced, dateShipped));
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new LegoException(e.getMessage());
        }

        return orders;
    }
    
    public static void markShippedAdmin(int id) throws LegoException{
        String query = "UPDATE orders SET dateshipped = ? WHERE id = ?";
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        try{
            Connection conn = DB.connection();
            PreparedStatement p = conn.prepareStatement(query);
            p.setString(1, date.format(dateFormat));
            p.setInt(2, id);
            p.executeUpdate();
        }catch(ClassNotFoundException | SQLException e){
            throw new LegoException(e.getMessage());
        }
    }

}
