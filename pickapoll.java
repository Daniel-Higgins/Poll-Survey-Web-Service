/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Danny
 */
public class pickapoll extends HttpServlet{
    /*
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            HttpSession session = request.getSession();
            Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost:3306/csc435","root","root");;
           
            Statement st = conn.createStatement();
            String sql = "Select name from poll";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<String> names = new ArrayList<String>();
            while (rs.next())
            {
                names.add(rs.getString(1));
            }
   
            session.setAttribute("pollNames", names.toString());
            
            
            rs.close();
            stmt.close();
            RequestDispatcher rd = request.getRequestDispatcher("pickapoll.jsp");
            rd.include(request, response);

            
        } catch (SQLException ex) {
            Logger.getLogger(pickapoll.class.getName()).log(Level.SEVERE, null, ex);
        }
              

    }


}


