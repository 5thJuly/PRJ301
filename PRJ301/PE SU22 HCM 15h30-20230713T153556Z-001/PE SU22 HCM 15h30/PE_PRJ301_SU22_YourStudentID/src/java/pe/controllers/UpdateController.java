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
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import pe.CarDAO;
import pe.CarDTO;

/**
 *
 * @author Admin
 */
public class UpdateController extends HttpServlet {

    private static final String ERROR = "SearchController";
    private static final String SUCCESS = "SearchController";
    private static final String LOGOUT = "LogoutCOntroller";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String url = ERROR;
        try {
            String id = request.getParameter("id");

            String name = request.getParameter("name");
            String description = request.getParameter("description");
            float price = Float.parseFloat(request.getParameter("price"));
            int speed = Integer.parseInt(request.getParameter("speed"));

            HttpSession session = request.getSession();

            CarDTO loginCar = (CarDTO) session.getAttribute("LOGIN_CAR");
            CarDAO dao = new CarDAO();
            CarDTO cuser = new CarDTO(id, name, description, price, speed, true);

            boolean check = dao.update(cuser);
            if (check) {
                if (name.equals(loginCar.getName())) {
                    url = LOGOUT;
                } else {
                    url = SUCCESS;
                }
                url = SUCCESS;
                if (loginCar != null) {
                    if (loginCar.getId().equals(id)) {
                        loginCar.setName(name);
                        loginCar.setDescription(description);
                        loginCar.setPrice(price);
                        loginCar.setSpeed(speed);

                    }
                }
            }
        } catch (Exception e) {
            log("Error at UpdateController: " + e.toString());
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
