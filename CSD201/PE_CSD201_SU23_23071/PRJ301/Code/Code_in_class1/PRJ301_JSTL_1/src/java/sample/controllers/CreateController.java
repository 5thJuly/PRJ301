
package sample.controllers;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import sample.user.UserDAO;
import sample.user.UserDTO;
import sample.user.UserError;


/**
 *
 * @author Admin
 */
public class CreateController extends HttpServlet {

    private static final String ERROR = "create.jsp";
    private static final String SUCCESS = "login.html";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        UserError userERROR = new UserError();
        try{
            UserDAO dao = new UserDAO();
            boolean checkValidation = true;
            String userID = request.getParameter("userID");
            String fullName = request.getParameter("fullName");
            String roleID = request.getParameter("roleID");
            String password = request.getParameter("password");
            String confirm = request.getParameter("confirm");
            if(userID.length() < 2 || userID.length() > 10) {
                userERROR.setUserIDError("User ID must be in (2,10)");
                checkValidation = false;
            }
//            boolean checkDuplicate = dao.checkDuplicate(userID);
//            if(checkDuplicate){
//                userERROR.setUserIDError("User ID is existed!");
//                checkValidation = false;
//            }
            if(fullName.length() < 5 || fullName.length() > 20){
                userERROR.setFullNameError("Full Name must be in (5,20)!");
                checkValidation = false;
            } 
            if(!password.equals(confirm)){
                userERROR.setConfirmError("Password does not match!");
                checkValidation = false;
            }
            if(checkValidation) {
                UserDTO user = new UserDTO(userID, fullName, roleID, password);
//                boolean checkInsert = dao.insert(user);
                  boolean checkInsert = dao.insertV2(user);
                if(checkInsert) {
                    url = SUCCESS;  
                }
                else{
                    userERROR.setError("Unknow error!");
                    request.setAttribute("USER_ERROR", userERROR);
                }
            }
            else {
                request.setAttribute("USER_ERROR", userERROR);

            }
            
        }
        catch(Exception e) {
            log("Error at CreateController: " + e.toString());
            if(e.toString().contains("duplicate")) {
                 userERROR.setUserIDError("Trung khoa chinh roi kia, sua lai di >< ");
                 request.setAttribute("USER_ERROR", userERROR);
            }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
