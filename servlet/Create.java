/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Danny
 */
public class Create extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String name = request.getParameter("name");
            String question = request.getParameter("question");
            String c1 = request.getParameter("choice1");
            String c2 = request.getParameter("choice2");
            String c3 = request.getParameter("choice3");
            
            
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/csc435","root", "root");
            String query = "insert into poll values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);

            if ((question = htmlFilter(question.trim())).length() != 0 && (c1 = htmlFilter(c1.trim())).length() != 0 && (c2 = htmlFilter(c2.trim())).length() != 0 && (c3 = htmlFilter(c3.trim())).length() != 0) {
                ps.setString(1, name);
                ps.setString(2, question);
                ps.setString(3, c1);
                ps.setString(4, c2);
                ps.setString(5, c3);
                ps.setInt(6, 0);
                ps.setInt(7, 0);
                ps.setInt(8, 0);
                ps.executeUpdate();
                RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
                rd.include(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
                rd.include(request, response);
            }
        } catch (ClassNotFoundException se) {
            se.printStackTrace();

        } catch (SQLException ex) {
            Logger.getLogger(Create.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static String htmlFilter(String message) {
        if (message == null) {
            return null;
        }
        int len = message.length();
        StringBuffer result = new StringBuffer(len + 20);
        char aChar;

        for (int i = 0; i < len; ++i) {
            aChar = message.charAt(i);
            switch (aChar) {
                case '<':
                    result.append("&lt;");
                    break;
                case '>':
                    result.append("&gt;");
                    break;
                case '&':
                    result.append("&amp;");
                    break;
                case '"':
                    result.append("&quot;");
                    break;
                default:
                    result.append(aChar);
            }
        }
        return (result.toString());
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
