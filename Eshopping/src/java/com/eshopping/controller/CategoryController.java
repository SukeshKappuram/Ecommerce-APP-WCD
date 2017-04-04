/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eshopping.controller;

import com.eshopping.DAO.CategoryDAO;
import com.eshopping.model.Category;
import com.eshopping.service.CategoryDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author iamsu
 */
@WebServlet(name = "CategoryController", urlPatterns = {"/Category"})
public class CategoryController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        String mode=request.getParameter("m");
        Category c;
        CategoryDAO cd=new CategoryDAOImpl();
        HttpSession session=request.getSession();
        out.println(mode);
        String name=request.getParameter("name");
        String description=request.getParameter("description");
        if(mode.equals("c")){
            c=new Category(name, description);
            cd.create(c);
        }
        else{
            int id=Integer.parseInt(request.getParameter("id"));
            if(mode.equals("e")){
                c=new Category(id);
                c=cd.read(c);
                session.setAttribute("category",c);
            }else if(mode.equals("u")){
                c=new Category(name, description);
                c.setId(id);
                cd.update(c);
                session.setAttribute("category",null);
            }else{
                c=new Category(id);
                out.print("Delete"+id);
                cd.delete(c);
            }
        }
        session.setAttribute("categories",cd.read());
        response.sendRedirect("manage.jsp");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
