/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eshopping.service;

import com.eshopping.DAO.UserDAO;
import com.eshopping.db.DataSource;
import com.eshopping.model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author iamsu
 */
public class UserDAOImpl implements UserDAO{
    DataSource ds=new DataSource();
    
    @Override
    public User createUser(User u) {
        try{
        ds.setCon();
        ds.setPs("insert into Users(firstname,middleName,lastName,phoneNumber,mailId,password) values (?,?,?,?,?,?)");
        ds.getPs().setString(1,u.getFirstName());
        ds.getPs().setString(2,u.getMiddleName());
        ds.getPs().setString(3,u.getLastName());
        ds.getPs().setString(4,u.getPhoneNumber());
        ds.getPs().setString(5,u.getMailId());
        ds.getPs().setString(6,u.getPassword());
        ds.getPs().executeUpdate();
        ds.getCon().commit();
        }catch(Exception e){
            u.error=e.toString();
        }
        return u;
    }

    @Override
    public User readUser(User u) {
        try{
            ds.setCon();
            ds.setPs("select * from Users where mailId= ?");
            ResultSet rs= ds.getPs().executeQuery();
            if(rs.next()){
                if(rs.getString("password").equals(u.getPassword())){
                    u.setFirstName(rs.getString("firstName"));
                    u.setLastName(rs.getString("lastName"));
                    u.setMiddleName(rs.getString("middleName"));
                    u.setPhoneNumber(rs.getString("phoneNumber"));
                    u.setId(rs.getInt("Id"));
                }
            }
        }catch(Exception e){}
        return u;
    }

    @Override
    public void updateUser(User u) {
    }

    @Override
    public void deleteUser(User u) {
    }
    
    public void DBInsert(String query, Connection conn) {
        
    try (PreparedStatement stm = conn.prepareCall(query)){
        ds.setCon();
     conn=ds.getCon();
        stm.executeUpdate();
        conn.commit();
    } catch (SQLException ex) {
        ex.getLocalizedMessage();
    } finally {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
    
    public static void main(String[] str) throws SQLException{
        UserDAOImpl i=new UserDAOImpl();
        i.DBInsert("Insert into Users(firstName) values ('Sukesh')", DriverManager.getConnection("jdbc:odbc:Eshp"));
        
        User u=new User("A","A","A","T","G","Y");
        i.createUser(u);
    }
}
