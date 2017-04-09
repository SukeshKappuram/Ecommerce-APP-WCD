/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eshopping.DAO;

import com.eshopping.model.ProductDetails;
import com.eshopping.model.Product;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author iamsu
 */
public interface ProductDetailsDAO {
    public void create(ProductDetails p) throws SQLException;
    public ProductDetails read(ProductDetails p);
    public List<ProductDetails> read(Product p);
    public List<ProductDetails> read();
    public void update(ProductDetails p);
    public void delete(ProductDetails p);
}
