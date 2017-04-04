/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eshopping.DAO;

import com.eshopping.model.Category;
import com.eshopping.model.Product;
import java.util.List;

/**
 *
 * @author iamsu
 */
public interface ProductDAO {
    public void create(Product c);
    public Product read(Product c);
    public List<Product> read(Category c);
    public List<Product> read();
    public void update(Product c);
    public void delete(Product c);
}
