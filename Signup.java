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
import java.lang.ClassNotFoundException;
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
public class Signup extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {

            PrintWriter out = response.getWriter();
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String bio = request.getParameter("instruction");
            String age = request.getParameter("age");
            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/csc435","root", "root");
            String query = "insert into accounts values(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);

            if ((email = htmlFilter(email.trim())).length() != 0 && (password = htmlFilter(password.trim())).length() != 0 && !CheckEmail.CheckUsernameExists(email)) {
                ps.setString(1, username);
                ps.setString(2, password);
                ps.setString(3, email);
                ps.setString(5, age);
                ps.setString(4, bio);
                ps.executeUpdate();
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.include(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("Signup.jsp");
                rd.include(request, response);
            }
        } catch (ClassNotFoundException se) {
            se.printStackTrace();

        } catch (SQLException ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    
    
    

   // Filter the string for special HTML characters to prevent
    // command injection attack
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
}
