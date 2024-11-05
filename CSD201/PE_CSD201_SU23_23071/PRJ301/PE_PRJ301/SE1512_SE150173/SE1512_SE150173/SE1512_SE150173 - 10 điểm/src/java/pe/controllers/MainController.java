/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


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
            switch (action) {
                case LOGIN_VALUE:
                    url = LOGIN_CONTROLLER;
                    break;
                case SEARCH_VALUE:
                    url = SEARCH_CONTROLLER;
                    break;
                case SEARCH_AVAILABLE_VALUE:
                    url = SEARCH_AVAILABLE_CONTROLLER;
                    break;
                case REMOVE_VALUE:
                    url = REMOVE_CONTROLLER;
                    break;
                case LOGOUT_VALUE:
                    url = LOGOUT_CONTROLLER;
                    break;
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
