
package pe.controllers;

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

import pe.user.UserDAO;
import pe.user.UserDTO;


/**
 *
 * @author Admin
 */
public class LoginController extends HttpServlet {

    private static final String LOGIN_PAGE="login.jsp";
    private static final String AD="AD";
    private static final String ADMIN_PAGE="admin.jsp";
    private static final String US="US";

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        String url = LOGIN_PAGE;
        try{
           String userID= request.getParameter("userID");
            String password= request.getParameter("password");
            UserDAO dao= new UserDAO();
            UserDTO loginUser= dao.checkLogin(userID, password);
            if(loginUser== null){
                request.setAttribute("ERROR", "Incorrect userID or password");
            }
            else {
                String roleID= loginUser.getRoleID();
                
                HttpSession session=request.getSession();
                session.setAttribute("LOGIN_USER", loginUser);
                
                if(AD.equals(roleID)){
                    url= ADMIN_PAGE;
                }else if(US.equals(roleID)){
                    url=LOGIN_PAGE;
                }else{
                    request.setAttribute("ERROR", "Your role is not supported yet !");
                    url= LOGIN_PAGE;
                }
            }
        }
        catch(Exception e) {
            log("Error at LoginController "+ e.toString());
        }
        finally{
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
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
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
