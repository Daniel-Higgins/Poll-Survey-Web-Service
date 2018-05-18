/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Danny
 */
public class CheckEmail {
    String user = "root";
    String password = "root";
    
 public static boolean CheckUsernameExists(String username){
    boolean status = false;
    try
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/csc435","root", "root");

        PreparedStatement st = connection.prepareStatement("select * from accounts where username=?");
        st.setString(1, username);
        ResultSet rs = st.executeQuery();
        status = rs.next();
     }

     catch (Exception e){
         System.out.println(e);
     }

    return status;
 }
}
