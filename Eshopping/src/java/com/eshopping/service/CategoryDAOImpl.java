/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eshopping.service;

import com.eshopping.DAO.CategoryDAO;
import com.eshopping.db.DataSource;
import com.eshopping.model.Category;

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
        ds.setPs("insert into Category(name,description) values (?,?)");
        ds.getPs().setString(1,c.getName());
        ds.getPs().setString(2,c.getDescription());
        ds.getPs().executeUpdate();
        ds.getCon().commit();
        ds.getCon().close();
        }catch(Exception e){
        }
    }

    @Override
    public void read(Category c) {
    }

    @Override
    public void update(Category c) {
    }

    @Override
    public void delete(Category c) {
    }
    
}
