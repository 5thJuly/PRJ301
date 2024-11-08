/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sample.user.UserDAO;
import sample.user.UserDTO;


/**
 *
 * @author Admin
 */
public class UpdateController extends HttpServlet {

    private static final String ERROR="SearchController";
    private static final String SUCCESS="SearchController";
    private static final String LOGOUT = "LogoutCOntroller";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        String url = ERROR;
        try {
            String userID = request.getParameter("userID");
            String fullName = request.getParameter("fullName");
            String roleID = request.getParameter("roleID");
            
            
            HttpSession session = request.getSession();
            
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            
            
            UserDAO dao = new UserDAO();
            UserDTO user = new UserDTO(userID, fullName, roleID, "");
           
            
            boolean check = dao.update(user);
            if(check) {
                if(userID.equals(loginUser.getUserID())) {
                    url = LOGOUT;
                }
                else {
                    url = SUCCESS;
                }
                
                
                url = SUCCESS;
                if(loginUser != null) {
                    if(loginUser.getUserID().equals(userID)){
                        loginUser.setFullName(fullName);
                        loginUser.setRoleID(roleID);
                        session.setAttribute("LOGIN_USER", loginUser);
                        }

                    }
                }
        } 
        catch(Exception e) {
            log("Error at UpdateController: " + e.toString());
        }
        finally {
            request.getRequestDispatcher(url).forward(request, response);

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
        } catch (SQLException ex) {
            Logger.getLogger(UpdateController.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(UpdateController.class.getName()).log(Level.SEVERE, null, ex);
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
