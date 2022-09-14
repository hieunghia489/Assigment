/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nghialh.controller;

import Nghialh.course.CourseDAO;
import Nghialh.course.CourseDTO;
import Nghialh.course.CourseErrorDTO;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
@WebServlet(name = "UpdateController", urlPatterns = {"/UpdateController"})
public class UpdateController extends HttpServlet {

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
        String courseName = request.getParameter("courseName");
        String description = request.getParameter("description");
        String tuitionFee = request.getParameter("tuitionFee");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String category = request.getParameter("category");
        String maxQuantity = request.getParameter("maxQuantity");
        String quantity = request.getParameter("quantity");
        String oldCourse=request.getParameter("oldCourseName");
        CourseErrorDTO error = new CourseErrorDTO();
        int fee = 0, max = 0;

        boolean check = false;
        request.removeAttribute("MESSAGE");
        try {
            if (courseName.length() < 3 || courseName.length() > 10) {
                check = true;
                error.setCourseNameError("Course name must have 3-10 character");
            }
            if (description.length() < 5 || description.length() > 50) {
                check = true;
                error.setDescriptionError("Course name must have 5-50 character");
            }
            if (!tuitionFee.isEmpty()) {
                fee = (int) Float.parseFloat(tuitionFee);
                if (fee < 100000 || fee > 10000000) {
                    check = true;
                    error.setTuitionFeeError("Fee must between 100k - 10M");
                }
            } else {
                check = true;
                error.setTuitionFeeError("Fee must between 100k - 10M");
            }
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date start = new Date(df.parse(startDate).getTime());
            Date end = new Date(df.parse(endDate).getTime());
            String create=request.getParameter("createDate");
            if (start.compareTo(df.parse(create)) != 1) {
                check = true;
                error.setStartDateError("Start date must before create date at least 1 day");
            } else {
                long distance =  end.getTime()- start.getTime() ;
                if (distance / (86400000 ) < 5) {
                    error.setEndDateError("Course must open at least 5 days");
                    check = true;
                }
            }
            if (!maxQuantity.isEmpty()) {
                max = Integer.parseInt(maxQuantity);
                int quan = Integer.parseInt(quantity);
                if (max < quan) {
                    check = true;
                    error.setMaxQuantityError("Max quantity can't be smaller than signed quantity");
                }
            } else {
                check = true;
                error.setMaxQuantityError("Max quantity can't be smaller than signed quantity");
            }
            String status = request.getParameter("status");
            boolean bit = true;
            if (status.equals("Close")) {
                bit = false;
            }
            String userUpdate = request.getParameter("lastUserUpdate");
            CourseDAO daoCourse = new CourseDAO();
            HttpSession session=request.getSession();
            ArrayList<CourseDTO> listCourse = daoCourse.getAllCourse();
            session.setAttribute("LIST_COURSE", listCourse);
            ArrayList<String> listCate = daoCourse.getAllCategory();
            session.setAttribute("CATEGORY", listCate);
            if (check) {
                request.setAttribute("MESSAGE", error);
            } else {
                Calendar cal = Calendar.getInstance();
            Date presentDate = new Date(cal.getTimeInMillis());
                if (daoCourse.updateCourse(courseName, description, fee, start, end, category, max, bit, presentDate, userUpdate,oldCourse)) {
                    listCourse = daoCourse.getAllCourse();
                    session.setAttribute("LIST_COURSE", listCourse);
                    listCate = daoCourse.getAllCategory();
                    session.setAttribute("CATEGORY", listCate);
                }
            } 
        } catch (NumberFormatException | ParseException | ClassNotFoundException | SQLException e) {
            log("Update controller " + e.toString());
            if(e.toString().contains("duplicate")){
                error.setCourseNameError("This course name is already existed");
                 request.setAttribute("MESSAGE", error);
            }
        } finally {
            request.getRequestDispatcher("admin.jsp").forward(request, response);
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
