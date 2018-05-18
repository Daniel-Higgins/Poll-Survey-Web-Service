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
public class PollSql {
        public ArrayList getKeys() throws SQLException, ClassNotFoundException{
            String sql = "Select name from poll";
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
            PreparedStatement pst = con.prepareStatement("select * from poll where name=?");
            pst.setString(1, name);
            ResultSet rs = pst.executeQuery();
            rs.next();
            String question = rs.getString("question");
            String c1 = rs.getString("c1");
            String c2 = rs.getString("c2");
            String c3 = rs.getString("c3");
            String a1 = rs.getString("a1");
            String a2 = rs.getString("a2");
            String a3 = rs.getString("a3");
            al.add(question);
            al.add(c1);
            al.add(c2);
            al.add(c3);
            al.add(a1);
            al.add(a2);
            al.add(a3);
            return al;
        }
}

