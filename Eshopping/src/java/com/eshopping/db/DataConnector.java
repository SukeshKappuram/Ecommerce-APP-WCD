/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eshopping.db;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
/**
 *
 * @author iamsu
 */
public class DataConnector {
    private DataSource ds=null;
    private Connection con;
    
    public void getDataSource() throws SQLException, NamingException
    {
        System.out.println("get Datasourcemethod called");
        SQLServerDataSource dataSource=new SQLServerDataSource();
        dataSource.setUser("sa");
        dataSource.setPassword("iluVirat#100");
        dataSource.setServerName("DESKTOP-H4HBQ7U");
        dataSource.setDatabaseName("Eshop");
        dataSource.setPortNumber(1433);
        con = dataSource.getConnection();
        System.out.println("connected");
        Context ctx=new InitialContext();
        ctx.bind("jdbc/sql", dataSource);
        
    }
    
    public void setConnection() throws NamingException, SQLException{
        Context ctx=new InitialContext();
        ds=(DataSource)ctx.lookup("jdbc/sql");
        Connection con=ds.getConnection("sa", "iluVIrat#100");
    }
    
    public static void main(String[] arg) throws NamingException, SQLException{
        DataConnector dc=new DataConnector();
        dc.setConnection();
        Statement st=dc.con.createStatement();
        ResultSet rs=st.executeQuery("Select * from Employee");
        while(rs.next()){
            System.out.println(rs.getString(1));
        }
    }
}

