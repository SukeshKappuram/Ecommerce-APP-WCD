/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eshopping.DAO;

import com.eshopping.model.User;
import com.eshopping.model.Cart;
import com.eshopping.model.CartItem;
import java.util.Set;

/**
 *
 * @author iamsu
 */
public interface CartDAO {
    public Cart create(Cart c);
    public void add(Cart c);
    public Cart read(Cart c);
    public Set<CartItem> read(Cart c,User Id);
    public void update(Cart c);
    public void delete(Cart c);
}
