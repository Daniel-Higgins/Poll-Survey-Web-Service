/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// To save as "<CATALINA_HOME>\webapps\helloservlet\WEB-INF\src\mypkg\SessionServlet.java"
package com.servlet;
 

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class vote2 extends HttpServlet {
    int a1,a2,a3;
    String c1,c2,c3;
   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)
               throws IOException, ServletException {
      // Set the response message's MIME type
        response.setContentType("text/html;charset=UTF-8");
      // Allocate a output writer to write the response message into the network socket
        PrintWriter out = response.getWriter();
 
      // Return the existing session if there is one. Create a new session otherwise.
        HttpSession session = request.getSession();
        
        
       
        
        
    
 
      // Write the response message, in an HTML page
      try {
            
            // this is not hooked up correctly
            String name = (String) session.getAttribute("name");
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection  con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/csc435","root","root");
            PreparedStatement pst = con.prepareStatement("select * from vote where name=?");
            pst.setString(1, name);
            ResultSet rs = pst.executeQuery();
            rs.next();
            String users = rs.getString("voters");
            String [] Jill = users.split("/");
            
            // set initial variables 
            pst = con.prepareStatement("select * from poll where name=?");
            pst.setString(1, name);
            rs = pst.executeQuery();
            rs.next();
            a1 = rs.getInt("a1");
            a2 = rs.getInt("a2");
            a3 = rs.getInt("a3");
            c1 = rs.getString("c1");
            c2 = rs.getString("c2");
            c3 = rs.getString("c3");
            for (int i = 0; i < Jill.length; i++) {
                out.println((String)session.getAttribute("Email"));
              if(Jill[i].equals((String)session.getAttribute("Email"))){
                  out.println("You cannot vote in a poll you have already voted for");
                  out.println(request.getParameter("options"));
                  break;
              }
              
              else if(i==Jill.length-1){
                  out.println("You can vote on this poll because you havent voted");
                  
                  pst = con.prepareStatement("Update vote set voters = ? where name = ?");
                  
                  pst.setString(1, users + "/" + (String)session.getAttribute("Email"));
                  pst.setString(2, name);
                  pst.executeUpdate();
                  
                  
                  if(request.getParameter("options").equals("c1")){
                        con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/csc435","root","root");

                        pst = con.prepareStatement("Update poll set a1 = ? where name = ?");
                        pst.setInt(1, a1+1);
                        pst.setString(2, name);
                        pst.executeUpdate();
                  }
                  
                  else if (request.getParameter("options").equals("c2")){

                        pst = con.prepareStatement("Update poll set a2 = ? where name = ?");
                        pst.setInt(1, a2+1);
                        pst.setString(2, name);
                        pst.executeUpdate();
                  }
                  
                  else if (request.getParameter("options").equals("c3")){
                        a3 = rs.getInt("a3");
                        pst = con.prepareStatement("Update poll set a3 = ? where name = ?");
                        pst.setInt(1, a3+1);
                        pst.setString(2, name);
                        pst.executeUpdate();
                  }
                  
                  

                  
                  
                  
                  
              }
                    
                  // Update the variables originally set
                  
                  
                 pst = con.prepareStatement("select * from poll where name=?");
                 pst.setString(1, name);
                 rs = pst.executeQuery();
                 rs.next();
                a1 = rs.getInt("a1");
                a2 = rs.getInt("a2");
                a3 = rs.getInt("a3");
                c1 = rs.getString("c1");
                c2 = rs.getString("c2");
                c3 = rs.getString("c3");
                session.setAttribute("c1", c1);
                session.setAttribute("c2", c2);
                session.setAttribute("c3", c3);
                session.setAttribute("a1", Integer.toString(a1));
                session.setAttribute("a2", Integer.toString(a2));
                session.setAttribute("a3", Integer.toString(a3));
                RequestDispatcher rd = request.getRequestDispatcher("viewresults.jsp");
                rd.include(request, response);
          }
            
            
            
              

      } catch (SQLException ex) {
           Logger.getLogger(vote2.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(vote2.class.getName()).log(Level.SEVERE, null, ex);
       } finally {
         out.close();  // Always close the output writer
      }
   }
}