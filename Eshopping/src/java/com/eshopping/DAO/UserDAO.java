/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eshopping.DAO;

import com.eshopping.model.User;

/**
 *
 * @author iamsu
 */
public interface UserDAO {
    User createUser(User u);
    User readUser(User u);
    void updateUser(User u);
    void deleteUser(User u);
}
