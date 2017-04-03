/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eshopping.DAO;

import com.eshopping.model.Category;

/**
 *
 * @author iamsu
 */
public interface CategoryDAO {
    public void create(Category c);
    public void read(Category c);
    public void update(Category c);
    public void delete(Category c);
}
