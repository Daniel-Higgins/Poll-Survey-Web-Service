
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
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Reeves
 */
public class BioSql {
        public ArrayList getKeys() throws SQLException, ClassNotFoundException{
            String sql = "Select Email from bio";
            Class.forName("com.mysql.jdbc.Driver");
            Connection  conn = DriverManager.getConnection ("jdbc:mysql://localhost:3306/csc435","root","root");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<String> names = new ArrayList<String>();

            while (rs.next())
            {
                names.add(rs.getString(1));
            }
            
            return names;
        }
        
        public ArrayList getValues(String name) throws ClassNotFoundException, SQLException{
            ArrayList<String> al = new ArrayList();
            Class.forName("com.mysql.jdbc.Driver");
            Connection  con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/csc435","root","root");
            PreparedStatement pst = con.prepareStatement("select * from bio where Email=?");
            pst.setString(1, name);
            ResultSet rs = pst.executeQuery();
            rs.next();
            String email = rs.getString("Name");
            //String gender = rs.getString("Gender");
            String bio = rs.getString("Bio");
            String age = rs.getString("age");
            al.add(email);
            //al.add(gender);
            al.add(bio);
            al.add(age);
            return al;
        }
}
