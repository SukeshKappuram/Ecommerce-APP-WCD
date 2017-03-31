/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eshopping.controller;

import com.eshopping.DAO.UserDAO;
import com.eshopping.model.User;
import com.eshopping.service.UserDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author iamsu
 */
@WebServlet(name = "UserController", urlPatterns = {"/User.do"})
public class UserController extends HttpServlet {

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
        String req=request.getHeader("referer");
        out.print(req);
        String mailId=request.getParameter("mailId");
        String password=request.getParameter("password");
        UserDAO ud=new UserDAOImpl();
        User user;
        RequestDispatcher rd=getServletContext().getRequestDispatcher("/index.jsp");
        if(req.contains("Login")){
            user=new User(mailId,password);
            user=ud.readUser(user);
            if(user.getId()!=0){  
                Cookie c=new Cookie("mail",user.getMailId());
                response.addCookie(c);
                HttpSession session=request.getSession();
                session.setAttribute("user", user);
                  response.sendRedirect("Welcome.jsp?n="+user.getFirstName());
                }
            else{
                out.println("User Id or password Incorrect");
                rd.include(request, response);
            }
            }
            else if(req.contains("index")){
            String firstName=request.getParameter("firstName");
            String middleName=request.getParameter("middleName");
            String lastName=request.getParameter("lastName");
            String phoneNumber=request.getParameter("phoneNumber");
            
            user=new User(firstName, "y", lastName, mailId, phoneNumber, password);
            user=ud.createUser(user);
            if(user.error!=null){
                out.print(user.error);
                rd.include(request, response);
            }
            rd.forward(request, response);
        }
        
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
