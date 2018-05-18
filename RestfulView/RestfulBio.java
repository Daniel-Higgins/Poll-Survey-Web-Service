package RestfulView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.servlet.BioSql;


/**
 *
 * @author Danny
 */
public class RestfulBio extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        try {
            response.setContentType("application/json; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            
            
            JsonObjectBuilder builder =  Json.createObjectBuilder();
            JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
            BioSql biosql = new BioSql();
            ArrayList<String> primarykeys = biosql.getKeys();
            
            for (int i = 0; i < primarykeys.size(); i++) {
                
                try {
                    ArrayList<String> values = biosql.getValues(primarykeys.get(i));
                    JsonObjectBuilder pollbuilder = Json.createObjectBuilder();
                    JsonObject pollJson = pollbuilder.add("Email",primarykeys.get(i))
                            .add("Name", values.get(0) != null ? values.get(0) : "")
                            .add("Bio", values.get(1) != null ? values.get(1) : "")
                            .add("Age", values.get(2) != null ? values.get(2) : "")
                            .build();
                   
                    arrayBuilder.add(pollJson);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(RestfulBio.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(RestfulBio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            JsonObject root = builder.add("Biodata", arrayBuilder).build();
            
            writer.print(root);
            
            
            writer.flush();
            writer.close();
        } catch (SQLException ex) {
            Logger.getLogger(RestfulBio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RestfulBio.class.getName()).log(Level.SEVERE, null, ex);
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