/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eshopping.service;

import com.eshopping.DAO.RoleDAO;
import com.eshopping.db.DataSource;
import com.eshopping.model.Role;
import java.sql.ResultSet;

/**
 *
 * @author iamsu
 */
public class RoleDAOImpl implements RoleDAO{
    
    DataSource ds=new DataSource();
    
    @Override
    public void createRole(Role role) {
        try{
        ds.setCon();
        ds.setPs("insert into Roles(RoleName,userId) values (?,?)");
        ds.getPs().setString(1,role.getRoleName());
        ds.getPs().setInt(2,role.getUserId());
        ds.getPs().executeUpdate();
        ds.getCon().commit();
        ds.getCon().close();
        }catch(Exception e){
        }
    }

    @Override
    public Role[] readRole(Role role) {
        Role[] roles=new Role[3];
        int i=0;
        try{
            ds.setCon();
            ds.setPs("select * from Roles where userId= ?");
            ds.getPs().setInt(1, role.getUserId());
            ResultSet rs= ds.getPs().executeQuery();
            while(rs.next()){
                    role=new Role();
                    role.setRoleName(rs.getString("roleName"));
                    role.setId(rs.getInt("Id"));
                    roles[i]=role;
                    i++;
            }
        }catch(Exception e){}
        return roles;
    }

    @Override
    public void updateRole(Role role) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteRole(Role role) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
