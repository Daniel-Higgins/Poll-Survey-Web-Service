/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestfulDispatch;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.servlet.CheckEmail;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



/**
 *
 * @author Danny
 */
public class addBio extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException, JSONException  {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
          StringBuilder buffer = new StringBuilder();
                BufferedReader reader = request.getReader();
                String line;
                while ((line = reader.readLine()) != null) {
                buffer.append(line);
                }
                String data = buffer.toString();
                JSONObject obj = new JSONObject(data);
                
                String Email = obj.getJSONObject("bio").getString("Email");
                String Name = obj.getJSONObject("bio").getString("Name");
                //String Gender = obj.getJSONObject("bio").getString("Gender");
                String Bio = obj.getJSONObject("bio").getString("Bio"); 
                String Age = obj.getJSONObject("bio").getString("Age");      
                String Password = obj.getJSONObject("bio").getString("Password");
                
                // Connect to sql database 
                
                
                Class.forName("com.mysql.jdbc.Driver");
//creating connection with the database 
        Connection  con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/csc435","root","root");
        String query = "insert into accounts values(?,?,?,?,?)";
        PreparedStatement ps= con.prepareStatement(query);
        if(!Email.equals("") && !Password.equals("") && !CheckEmail.CheckUsernameExists(Email) && !Bio.equals("") && !Age.equals("")){
            ps.executeUpdate();
            ps.setString(1, Name);
            ps.setString(2, Password);
            ps.setString(3, Email);
            ps.setString(4,Bio);
            ps.setString(5, Age);
            ps.executeUpdate();
            
            RequestDispatcher rd = request.getRequestDispatcher("/jsonbio");
            rd.include(request, response);
        }
        
        else{
            System.out.println("Invalid login");
  
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(addBio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(addBio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(addBio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(addBio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(addBio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(addBio.class.getName()).log(Level.SEVERE, null, ex);
        }
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
