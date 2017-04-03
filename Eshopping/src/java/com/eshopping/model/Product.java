/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eshopping.model;

/**
 *
 * @author iamsu
 */
public class Product {
    int id;
    String name;
    String description;
    float price;
    int categoryId;
    String manufacturename;
    String image;

    public Product(String name, String description, float price, int categoryId, String manufacturename, String image) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.categoryId = categoryId;
        this.manufacturename = manufacturename;
        this.image = image;
    }
    
    
    
}
