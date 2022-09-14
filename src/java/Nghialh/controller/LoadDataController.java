/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nghialh.controller;

import Nghialh.booking.BookingDAO;
import Nghialh.booking.BookingDTO;
import Nghialh.course.CourseDAO;
import Nghialh.course.CourseDTO;
import Nghialh.registration.RegistrationDAO;
import Nghialh.registration.RegistrationDTO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
@WebServlet(name = "LoadDataController", urlPatterns = {"/LoadDataController"})
public class LoadDataController extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = "customer.jsp";
        CourseDAO daoCourse = new CourseDAO();
        HttpSession session = request.getSession();
        try {
            String username = "";
            String password = "";
            Cookie[] allCookie = request.getCookies();
            if (allCookie != null) {
                for (Cookie cookie : allCookie) {
                    if (cookie.getName().equals("USER")) {
                        username = cookie.getValue();
                    } else {
                        if (cookie.getName().equals("PASSWORD")) {
                            password = cookie.getValue();
                        }
                    }
                }
                RegistrationDAO daoUser = new RegistrationDAO();
                RegistrationDTO user = daoUser.checkLogin(username, password);
                if (user != null) {
                    session.setAttribute("NAME", user.getFullName());
                    if (user.isIsAdmin()) {
                        url = "admin.jsp";
                    }
                }
            }
            ArrayList<CourseDTO> listCourse = daoCourse.getAllCourse();
            session.setAttribute("LIST_COURSE", listCourse);
            ArrayList<String> category = daoCourse.getAllCategory();
            session.setAttribute("CATEGORY", category);
        } catch (ClassNotFoundException | SQLException e) {
            log("Error at LoadDataController " + e.toString());
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
