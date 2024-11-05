/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.controllers;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.food.FoodDAO;
import pe.food.FoodDTO;
import pe.user.UserDAO;
import pe.user.UserDTO;

/**
 *
 * @author hd
 */
public class MainController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String LOGIN_VALUE = "Login";
    private static final String LOGIN_CONTROLLER = "LoginController";
    private static final String SEARCH_VALUE = "Search";
    private static final String SEARCH_CONTROLLER = "SearchController";
    private static final String SEARCH_AVAILABLE_VALUE = "GetAllAvailable";
    private static final String SEARCH_AVAILABLE_CONTROLLER = "SearchController";
    private static final String REMOVE_VALUE = "Remove";
    private static final String REMOVE_CONTROLLER = "RemoveController";
    private static final String LOGOUT_VALUE = "Logout";
    private static final String LOGOUT_CONTROLLER = "LogoutController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("action");

            if (action.equals("login")) {
                String user = request.getParameter("user");
                String pass = request.getParameter("pass");
                UserDTO userdto = UserDAO.login(user, pass);
                if (userdto != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("user", userdto);
                    url = "admin.jsp";
                } else {
                    request.setAttribute("loginfail", "Incorrect UserID ỏr PAssword");
                    url = "login.jsp";
                }

            } else if (action.equals("logout")) {
                HttpSession session = request.getSession();
                session.removeAttribute("user");
                url = "login.jsp";
            } else if (action.equals("search")) {
                String name = request.getParameter("name");
                ArrayList<FoodDTO> list = FoodDAO.search(name);
                System.out.println(list);
                if (list != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("list", list);
                    url = "admin.jsp";
                }

            } else if (action.equals("delete")) {
                String name = request.getParameter("name");
                int check = FoodDAO.delete(name);
                System.out.println(check);
                if (check==1) {
                    HttpSession session = request.getSession();
                    ArrayList<FoodDTO> list = FoodDAO.search("");
                    session.setAttribute("list", list);
                    url = "admin.jsp";
                }

            }

        } catch (Exception e) {
            log("Error at MainController: " + e.toString());
        } finally {
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
