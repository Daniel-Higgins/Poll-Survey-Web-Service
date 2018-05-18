/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;
import org.json.JSONWriter;
/**
 *
 * @author Danny
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String username = request.getParameter("txtusername");
            String password = request.getParameter("txtpassword");

//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/csc435","root","root");
//            PreparedStatement pst = con.prepareStatement("select * from bio where Email=?");
//            ResultSet rs = pst.executeQuery();
//            rs.next();
//            
//            HttpSession session = request.getSession();
//            System.out.println(username);
//            session.setAttribute("Name", rs.getString("Name"));
//            session.setAttribute("Email", rs.getString("Email"));
//            session.setAttribute("Age", rs.getString("Age"));
//            session.setAttribute("Gender", rs.getString("Gender"));
//            session.setAttribute("Bio", rs.getString("Bio"));
//   
            try {
                if (MySql.checkUser (username, password)) {
                   response.sendRedirect("welcome.jsp");

                } else {
                    out.print("Login Failed, try again.");
                }

            } catch (Exception e) {
                out.println("Error: " + e.getMessage());
            }
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);

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
