/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nghialh.controller;

import Nghialh.booking.BookingDAO;
import Nghialh.booking.BookingDTO;
import Nghialh.bookingDetail.BookingDetailDAO;
import Nghialh.cart.CartDTO;
import Nghialh.course.CourseDAO;
import Nghialh.course.CourseDTO;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
@WebServlet(name = "ConfirmController", urlPatterns = {"/ConfirmController"})
public class ConfirmController extends HttpServlet {

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
        try {
            HttpSession session = request.getSession();
            BookingDAO daoBook = new BookingDAO();
            BookingDetailDAO daoDetail = new BookingDetailDAO();
            CourseDAO daoCourse = new CourseDAO();
            CartDTO cart = (CartDTO) session.getAttribute("CART");
            Map<String, Integer> items = cart.getItems();
            String customer = request.getParameter("customer");
            Calendar cal = Calendar.getInstance();
            Date d = new Date(cal.getTimeInMillis());
            String money = request.getParameter("money");
            BookingDTO booking = daoBook.confirmBooking(customer, d, Integer.parseInt(money));
            if(booking!=null){
            for (String name : items.keySet()) {
                CourseDTO course = daoCourse.getCourse(name);
                daoDetail.createBookingDetail(name, items.get(name), course.getStartDate(), course.getEndDate(), course.getMaxQuantity(), booking.getID(), course.getTuitionFee());
            }
            session.removeAttribute("CART");
            }
            
        } catch (ClassNotFoundException | NumberFormatException | SQLException e) {
            log("Error at ConfirmController "+e.toString());
        } finally {
            request.getRequestDispatcher("customer.jsp").forward(request, response);
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
