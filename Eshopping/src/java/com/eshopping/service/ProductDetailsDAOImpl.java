/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eshopping.service;

import com.eshopping.DAO.ProductDetailsDAO;
import com.eshopping.db.DataSource;
import com.eshopping.model.Product;
import com.eshopping.model.ProductDetails;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author iamsu
 */
public class ProductDetailsDAOImpl implements ProductDetailsDAO{

    DataSource ds=new DataSource();
    
    @Override
    public void create(ProductDetails p) {
        try{
        ds.setCon();
        ds.setPs("insert into ProductDetails(sno,productId,manufactureDate,expieryDate,size,color,sellerId) values (?,?,?,?,?,?,?)");
        ds.getPs().setInt(1,p.getSerialNumber());
        ds.getPs().setInt(2,p.getProductId());
        ds.getPs().setDate(3,p.getManufactureDate());
        ds.getPs().setDate(4,p.getExpieryDate());
        ds.getPs().setString(5,p.getSize());
        ds.getPs().setString(6,p.getColor());
        ds.getPs().setInt(7,p.getSellerId());
        ds.getPs().executeUpdate();
        ds.getCon().commit();
        ds.getCon().close();
        }catch(Exception e){
        }
    }

    @Override
    public ProductDetails read(ProductDetails pd) {
         try{
            ds.setCon();
            ds.setPs("select * from ProductDetails where SerialNumber="+pd.getSerialNumber());
             ResultSet rs= ds.getPs().executeQuery();
            while(rs.next()){
                   ProductDetails p=new ProductDetails(rs.getInt("SerialNumber"));
                   p.setSerialNumber(rs.getInt("sno"));
                   p.setProductId(rs.getInt("ProductId"));
                   p.setManufactureDate(rs.getDate("manufactureDate"));
                   p.setExpieryDate(rs.getDate("expieryDate"));
                   p.setSize(rs.getString("size"));
                   p.setColor(rs.getString("color"));
                   p.setSellerId(rs.getInt("sellerId"));
            }
            ds.getCon().close();
        }catch(Exception e){}
        return pd;
    }

    @Override
    public List<ProductDetails> read(Product pid) {
        List<ProductDetails> products=new ArrayList<>();
         try{
            ds.setCon();
            ds.setPs("select * from ProductDetails where productId="+pid.getId());
             ResultSet rs= ds.getPs().executeQuery();
            while(rs.next()){
                   ProductDetails p=new ProductDetails(rs.getInt("Id"));
                   p.setSerialNumber(rs.getInt("sno"));
                   p.setProductId(rs.getInt("ProductId"));
                   p.setManufactureDate(rs.getDate("manufactureDate"));
                   p.setExpieryDate(rs.getDate("expieryDate"));
                   p.setSize(rs.getString("size"));
                   p.setColor(rs.getString("color"));
                   p.setSellerId(rs.getInt("sellerId"));
                   products.add(p);
            }
            ds.getCon().close();
        }catch(Exception e){}
        return products;
    }

    @Override
    public List<ProductDetails> read() {
        List<ProductDetails> products=new ArrayList<>();
         try{
            ds.setCon();
            ds.setPs("select * from ProductDetails");
             ResultSet rs= ds.getPs().executeQuery();
            while(rs.next()){
                   ProductDetails p=new ProductDetails(rs.getInt("Id"));
                   p.setSerialNumber(rs.getInt("sno"));
                   p.setProductId(rs.getInt("ProductId"));
                   p.setManufactureDate(rs.getDate("manufactureDate"));
                   p.setExpieryDate(rs.getDate("expieryDate"));
                   p.setSize(rs.getString("size"));
                   p.setColor(rs.getString("color"));
                   p.setSellerId(rs.getInt("sellerId"));
                   products.add(p);
            }
            ds.getCon().close();
        }catch(Exception e){}
        return products;
    }

    @Override
    public void update(ProductDetails p) {
        try{
        ds.setCon();
        ds.setPs("update ProductDetails set productId=?,manufactureDate=?,expieryDate=?,size=?,color=?,sellerId=? where sno=?");
        
        ds.getPs().setInt(1,p.getProductId());
        ds.getPs().setDate(2,p.getManufactureDate());
        ds.getPs().setDate(3,p.getExpieryDate());
        ds.getPs().setString(4,p.getSize());
        ds.getPs().setString(5,p.getColor());
        ds.getPs().setInt(6,p.getSellerId());
        ds.getPs().setInt(7,p.getSerialNumber());
        ds.getPs().executeUpdate();
        ds.getCon().commit();
        ds.getCon().close();
        }catch(Exception e){
        }
    }

    @Override
    public void delete(ProductDetails p) {
        try{
        ds.setCon();
        ds.setPs("Delete from ProductDetails where sno=?");
        ds.getPs().setInt(1,p.getSerialNumber());
        ds.getPs().executeUpdate();
        ds.getCon().commit();
        ds.getCon().close();
        }catch(Exception e){
        }
    }
    
}
