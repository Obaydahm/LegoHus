/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Mappers;

import Data.DB;
import Data.User;
import Logic.Exceptions.LegoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Obaydah Mohamad
 */
public class UserMapper {
    public static User validateLogin(String username, String password) throws LegoException{
        User user = null;
        try{
            Connection conn = DB.connection();
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement p = conn.prepareStatement(query);
            p.setString(1, username);
            p.setString(2, password);
            ResultSet rs = p.executeQuery();
            
            if(rs.next()){
                int user_id = rs.getInt("id");
                String username_ = rs.getString("username");
                String password_ = rs.getString("password");
                int admin = rs.getInt("admin");
                user = new User(user_id, username, password, admin);
            }
            
        }catch(ClassNotFoundException | SQLException e){
            throw new LegoException(e.getMessage());
        }
        return user;
    }
    
    public static void CreateUser(String username, String password, String passwordAgain) throws LegoException{
        try{
            if(!password.equals(passwordAgain)) throw new LegoException("Adgangskoderne er ikke ens");
            if(username.isEmpty() || password.isEmpty() || passwordAgain.isEmpty()) throw new LegoException("Alle felter skal udfyldes");
            Connection conn = DB.connection();
            String query = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement p = conn.prepareStatement(query);
            p.setString(1, username);
            p.setString(2, password);
            p.executeUpdate();
        }catch(ClassNotFoundException | SQLException e){
            throw new LegoException("Brugernavnet eksisterer allerede");
        }
    }
}
