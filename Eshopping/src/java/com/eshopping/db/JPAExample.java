/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eshopping.db;

import com.eshopping.model.Category;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author iamsu
 */
public class JPAExample {
    public static void main(String arg[]){
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("CreateDb");
        EntityManager em=emf.createEntityManager();
        EntityTransaction et=em.getTransaction();
        
        et.begin();
        Category category=new Category();
        category.setName("ED");
        category.setDescription("Electronic Devices");
        em.persist(category);
        et.commit();
        em.close();
        emf.close();
    }
}
