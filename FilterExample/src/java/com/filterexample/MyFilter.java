/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.filterexample;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author iamsu
 */
public class MyFilter implements Filter{

    FilterConfig fcg =null;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.fcg=filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            long service_Start = System.currentTimeMillis();
            String str=fcg.getInitParameter("user");
            request.setAttribute("UserName", str);
            chain.doFilter(request, response);
            long service_Stop = System.currentTimeMillis();
            long serviceTime = (service_Stop - service_Start);
            String path = ((HttpServletRequest)request).getRequestURI();
            fcg.getServletContext().log("Time taken to process request for:  " +path+" is: "+serviceTime+ " milliseconds");
    }

    @Override
    public void destroy() {
        this.fcg=null;
    }
    
}
