/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eshopping.service;
import com.eshopping.model.User;
import com.eshopping.DAO.CartDAO;
import com.eshopping.DAO.ProductDAO;
import com.eshopping.db.DataSource;
import com.eshopping.model.Cart;
import com.eshopping.model.CartItem;
import com.eshopping.model.Product;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author iamsu
 */
public class CartDAOImpl implements CartDAO{

    DataSource ds=new DataSource();
    
    @Override
    public Cart create(Cart c) {
        try{
        ds.setCon();
        ds.setPs("insert into Cart(Userid) values (?)");
        ds.getPs().setInt(1,c.getUser().getId());
        ds.getPs().executeUpdate();
        ds.getCon().commit();
        ds.getCon().close();
        }catch(Exception e){
            System.out.println(e);
        }
        c=read(c);
        return c;
    }
    
    public static void main(String[] arg){
        CartDAO cd=new CartDAOImpl();
        
    }

    @Override
    public Cart read(Cart c) {
        try{
            ds.setCon();
            ds.setPs("select * from Cart where userId= ?");
            ds.getPs().setInt(1, c.getUser().getId());
            ResultSet rs= ds.getPs().executeQuery();
            if(rs.next()){
                    c.setId(rs.getInt("Id"));
            }
        }catch(Exception e){}
        return c;
    }

    @Override
    public Set<CartItem> read(Cart cart,User u) {
        Set<CartItem> cartItems = new HashSet<>();
             try{
            ds.setCon();
            ds.setPs("select * from CartItem where cartId= ?");
            ds.getPs().setInt(1, cart.getId());
            ResultSet rs= ds.getPs().executeQuery();
            while(rs.next()){
                CartItem ci=new CartItem();
                ci.setId(rs.getInt("Id"));
                Cart c=new Cart();
                c.setId(rs.getInt("cartId"));
                ci.setCart(c);
                Product p=new Product(rs.getInt("productId"));
                ProductDAO pd=new ProductDAOImpl();
                ci.setProduct(pd.read(p));
                ci.setQuantity(rs.getInt("quantity"));
                cartItems.add(ci);
            }
        }catch(Exception e){}
        return cartItems;
    }

    @Override
    public void update(Cart c) {
    }

    @Override
    public void delete(Cart c) {
    }

    @Override
    public void add(Cart c) {
        try{
        ds.setCon();
        for(CartItem i:c.getCartItems()){
            System.out.println("Cartitem "+i);
            try{
            for(CartItem ci:read(c,c.getUser())){
                System.out.println("Comparing");
                if(ci.getId()==i.getId()){
                    ds.setPs("Update CartItem set quantity=? where id=?");
                    ds.getPs().setInt(1,ci.getQuantity());
                    ds.getPs().setInt(2,ci.getId());
                    ds.getPs().executeUpdate();
                    System.out.println("updating");
                }
            }}catch(Exception ex){
                System.out.println("no previous Cartitems "+ex);
            }
            System.out.println("no previous Cartitems");
            if(i.getId()==0){
                System.out.println("adding new Item");
                    ds.setPs("insert into CartItem(cartId,productId,quantity) values(?,?,?)");
                    ds.getPs().setInt(1,i.getCart().getId());System.out.println("set");
                    ds.getPs().setInt(2,i.getProduct().getId());System.out.println("set");
                    ds.getPs().setInt(3,i.getQuantity());System.out.println("set");
                    ds.getPs().executeUpdate();
                    System.out.println("adding");
            }
            
        }
        ds.getCon().commit();
        ds.getCon().close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
