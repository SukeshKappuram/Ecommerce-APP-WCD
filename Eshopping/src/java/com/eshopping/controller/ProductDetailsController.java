/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eshopping.controller;

import com.eshopping.DAO.ProductDAO;
import com.eshopping.DAO.ProductDetailsDAO;
import com.eshopping.model.ProductDetails;
import com.eshopping.service.ProductDAOImpl;
import com.eshopping.service.ProductDetailsDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "ProductDetailsController", urlPatterns = {"/ProductDetails"})
public class ProductDetailsController extends HttpServlet {

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
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();
        ProductDetailsDAO pd=new ProductDetailsDAOImpl();
        ProductDetails p;
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        //Category c=new Category(0);
        String mode=request.getParameter("m");
        String manufactureDate="",expieryDate="",size="",color="";
        long serialNumber=0;
        int productId=0,sellerId=0;
        out.println(mode);
        
        try{
            serialNumber=Integer.parseInt(request.getParameter("serialNumber"));
            productId=Integer.parseInt(request.getParameter("productId"));
            manufactureDate=request.getParameter("manufactureDate");
            expieryDate=request.getParameter("expieryDate");
            size=request.getParameter("size");
            color=request.getParameter("color");
            sellerId=Integer.parseInt(request.getParameter("sellerId"));
            
            if(mode.equals("c")){
                p=new ProductDetails(serialNumber, productId, new Date(sdf1.parse(manufactureDate).getTime()),new Date(sdf1.parse(expieryDate).getTime()),size , color, sellerId);
                pd.create(p);
            }
            if(mode.equals("e")){
                serialNumber=Integer.parseInt(request.getParameter("id"));
                p=new ProductDetails(serialNumber);
                p=pd.read(p);
                session.setAttribute("productDetail",p);
            }
        }catch(Exception e){out.println(e);}
        
        session.setAttribute("productDetails",pd.read());
        response.sendRedirect("ProductDetails.jsp");
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ProductDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ProductDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
