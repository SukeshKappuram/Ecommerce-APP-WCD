/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eshopping.service;

import com.eshopping.DAO.CategoryDAO;
import com.eshopping.db.DataSource;
import com.eshopping.model.Category;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author iamsu
 */
public class CategoryDAOImpl implements CategoryDAO{

    DataSource ds=new DataSource();
    
    @Override
    public void create(Category c) {
        try{
        ds.setCon();
        ds.setPs("insert into Categories(name,description) values (?,?)");
        ds.getPs().setString(1,c.getName());
        ds.getPs().setString(2,c.getDescription());
        ds.getPs().executeUpdate();
        ds.getCon().commit();
        ds.getCon().close();
        }catch(Exception e){
        }
    }

    @Override
    public Category read(Category c) {
        try{
            ds.setCon();
            ds.setPs("select * from Categories where Id= ?");
            ds.getPs().setInt(1, c.getId());
            ResultSet rs= ds.getPs().executeQuery();
            if(rs.next()){
                    c.setName(rs.getString("name"));
                    c.setDescription(rs.getString("description"));
            }
        }catch(Exception e){}
        return c;
    }

    @Override
    public void update(Category c) {
        try{
        ds.setCon();
        ds.setPs("update Categories set name=?,description=? where id=?");
        ds.getPs().setString(1,c.getName());
        ds.getPs().setString(2,c.getDescription());
        ds.getPs().setInt(3, c.getId());
        ds.getPs().executeUpdate();
        ds.getCon().commit();
        ds.getCon().close();
        }catch(Exception e){
        }
    }

    @Override
    public void delete(Category c) {
        try{
        ds.setCon();
        ds.setPs("Delete from Categories where id=?");
        ds.getPs().setInt(1,c.getId());
        ds.getPs().executeUpdate();
        ds.getCon().commit();
        ds.getCon().close();
        }catch(Exception e){
        }
    }

    @Override
    public List<Category> read() {
        List<Category> catgories=new ArrayList<>();
         try{
            ds.setCon();
            ds.setPs("select * from Categories");
             ResultSet rs= ds.getPs().executeQuery();
            while(rs.next()){
                   Category c=new Category(rs.getInt("Id"));
                   c.setName(rs.getString("name"));
                   c.setDescription(rs.getString("description"));
                   catgories.add(c);
            }
            ds.getCon().close();
        }catch(Exception e){}
        return catgories;
    }
    
}
