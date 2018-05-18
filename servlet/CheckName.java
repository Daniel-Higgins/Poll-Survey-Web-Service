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

/**
 *
 * @author Danny
 */
public class CheckName {
  public static boolean CheckUsernameExists(String Name){
  boolean status = false;

    try
    {

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/csc435","root", "root");

        PreparedStatement st = connection.prepareStatement("select * from poll where name=?");
        st.setString(1, Name);
        ResultSet rs = st.executeQuery();
        status = rs.next();

     }

     catch (Exception e){
         System.out.println(e);
     }

    return status;
 }
    
}


    

