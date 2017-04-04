/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eshopping.service;

import com.eshopping.DAO.ProductDAO;
import com.eshopping.db.DataSource;
import com.eshopping.model.Category;
import com.eshopping.model.Product;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author iamsu
 */
public class ProductDAOImpl implements ProductDAO{
    
    DataSource ds=new DataSource();

    @Override
    public void create(Product p) {
        try{
        ds.setCon();
        ds.setPs("insert into Products(name,description,price,categoryId,manufacturename) values (?,?,?,?,?)");
        ds.getPs().setString(1,p.getName());
        ds.getPs().setString(2,p.getDescription());
        ds.getPs().setFloat(3,p.getPrice());
        ds.getPs().setInt(4,p.getCategoryId());
        ds.getPs().setString(5,p.getManufacturename());
        ds.getPs().executeUpdate();
        ds.getCon().commit();
        ds.getCon().close();
        }catch(Exception e){
        }
    }

    @Override
    public Product read(Product p) {
        try{
            ds.setCon();
            ds.setPs("select * from Products where Id= ?");
            ds.getPs().setInt(1, p.getId());
            ResultSet rs= ds.getPs().executeQuery();
            if(rs.next()){
                    p.setName(rs.getString("name"));
                    p.setDescription(rs.getString("description"));
                    p.setPrice(rs.getFloat("price"));
                    p.setCategoryId(rs.getInt("categoryId"));
                    p.setManufacturename(rs.getString("manufacturename"));
            }
        }catch(Exception e){}
        return p;
    }
    
    @Override
    public List<Product> read(Category c) {
        List<Product> products=new ArrayList<>();
         try{
            ds.setCon();
            ds.setPs("select * from Products where categoryId=?");
            ds.getPs().setInt(1, c.getId());
            ResultSet rs= ds.getPs().executeQuery();
            while(rs.next()){
                   Product p=new Product(rs.getInt("Id"));
                   p.setName(rs.getString("name"));
                   p.setDescription(rs.getString("description"));
                   p.setPrice(rs.getFloat("price"));
                   p.setCategoryId(rs.getInt("categoryId"));
                   p.setManufacturename(rs.getString("manufacturename"));
                   products.add(p);
            }
            ds.getCon().close();
        }catch(Exception e){}
        return products;
    }

    @Override
    public List<Product> read() {
        List<Product> products=new ArrayList<>();
         try{
            ds.setCon();
            ds.setPs("select * from Products");
             ResultSet rs= ds.getPs().executeQuery();
            while(rs.next()){
                   Product p=new Product(rs.getInt("Id"));
                   p.setName(rs.getString("name"));
                   p.setDescription(rs.getString("description"));
                   p.setPrice(rs.getFloat("price"));
                   p.setCategoryId(rs.getInt("categoryId"));
                   p.setManufacturename(rs.getString("manufacturename"));
                   products.add(p);
            }
            ds.getCon().close();
        }catch(Exception e){}
        return products;
    }

    @Override
    public void update(Product p) {
        try{
        ds.setCon();
        ds.setPs("update Products set name=?,description=?,price=?,categoryId=?,manufacturename=? where id=?");
        ds.getPs().setString(1,p.getName());
        ds.getPs().setString(2,p.getDescription());
        ds.getPs().setFloat(3, p.getPrice());
        ds.getPs().setInt(4, p.getCategoryId());
        ds.getPs().setString(5,p.getManufacturename());
        ds.getPs().setInt(6, p.getId());
        ds.getPs().executeUpdate();
        ds.getCon().commit();
        ds.getCon().close();
        }catch(Exception e){
        }
    }

    @Override
    public void delete(Product p) {
        try{
        ds.setCon();
        ds.setPs("Delete from Products where id=?");
        ds.getPs().setInt(1,p.getId());
        ds.getPs().executeUpdate();
        ds.getCon().commit();
        ds.getCon().close();
        }catch(Exception e){
        }
    }
    
}
