/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nghialh.course;

import Nghialh.utils.DBUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class CourseDAO {

    public ArrayList<CourseDTO> getAllCourse() throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT * FROM tblCourses";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                ArrayList<CourseDTO> list = null;
                while (rs.next()) {
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    String courseName = rs.getString("courseName");
                    String image = rs.getString("imageCourse");
                    String description = rs.getString("description");
                    int tuitionFee = rs.getInt("tuitionFee");
                    String category = rs.getString("category");
                    Date createDate = rs.getDate("createDate");
                    Date startDate = rs.getDate("startDate");
                    Date endDate = rs.getDate("endDate");
                    Date lastUpdateDate = rs.getDate("lastUpdateDate");
                    String lastUpdateUser = rs.getString("lastUpdateUser");
                    String createUser = rs.getString("createUser");
                    boolean status = rs.getBoolean("status");
                    int quantity = rs.getInt("quantity");
                    int maxQuantity = rs.getInt("maxQuantity");
                    CourseDTO dto = new CourseDTO(courseName, image, description, tuitionFee, category, createDate, startDate, endDate, lastUpdateDate, lastUpdateUser, createUser, status, quantity, maxQuantity);
                    list.add(dto);
                }
                return list;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }

    public CourseDTO getCourse(String courseName) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT * FROM tblCourses WHERE courseName = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, courseName);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String image = rs.getString("imageCourse");
                    String description = rs.getString("description");
                    int tuitionFee = rs.getInt("tuitionFee");
                    String category = rs.getString("category");
                    Date createDate = rs.getDate("createDate");
                    Date startDate = rs.getDate("startDate");
                    Date endDate = rs.getDate("endDate");
                    Date lastUpdateDate = rs.getDate("lastUpdateDate");
                    String lastUpdateUser = rs.getString("lastUpdateUser");
                    String createUser = rs.getString("createUser");
                    boolean status = rs.getBoolean("status");
                    int quantity = rs.getInt("quantity");
                    int maxQuantity = rs.getInt("maxQuantity");
                    CourseDTO dto = new CourseDTO(courseName, image, description, tuitionFee, category, createDate, startDate, endDate, lastUpdateDate, lastUpdateUser, createUser, status, quantity, maxQuantity);
                    return dto;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }

    public ArrayList<CourseDTO> searchCourseByNameAndCategory(String name, String cate) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT * FROM tblCourses WHERE category like ? and courseName like ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + cate + "%");
                stm.setString(2, "%" + name + "%");
                rs = stm.executeQuery();
                ArrayList<CourseDTO> list = null;
                while (rs.next()) {
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    String courseName = rs.getString("courseName");
                    String image = rs.getString("imageCourse");
                    String description = rs.getString("description");
                    int tuitionFee = rs.getInt("tuitionFee");
                    String category = rs.getString("category");
                    Date createDate = rs.getDate("createDate");
                    Date startDate = rs.getDate("startDate");
                    Date endDate = rs.getDate("endDate");
                    Date lastUpdateDate = rs.getDate("lastUpdateDate");
                    String lastUpdateUser = rs.getString("lastUpdateUser");
                    String createUser = rs.getString("createUser");
                    boolean status = rs.getBoolean("status");
                    int quantity = rs.getInt("quantity");
                    int maxQuantity = rs.getInt("maxQuantity");
                    CourseDTO dto = new CourseDTO(courseName, image, description, tuitionFee, category, createDate, startDate, endDate, lastUpdateDate, lastUpdateUser, createUser, status, quantity, maxQuantity);
                    list.add(dto);
                }
                return list;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }

    public ArrayList<String> getAllCategory() throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        ArrayList<String> list = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT DISTINCT category from tblCourses";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    String cate = rs.getString("category");
                    list.add(cate);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return list;
    }

    public boolean updateCourse(String courseName, String description, int tuitionFee, Date startDate, Date endDate, String category, int maxQuantity, boolean status, Date lastUpdateDate, String lastUpdateUser, String oldCourse) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "UPDATE tblCourses set description = ?, tuitionFee = ?, category = ?, startDate = ?, endDate = ?, maxQuantity = ?, status = ?, lastUpdateDate = ?, lastUpdateUser = ? ,courseName = ? where courseName = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, description);
                stm.setInt(2, tuitionFee);
                stm.setString(3, category);
                stm.setDate(4, startDate);
                stm.setDate(5, endDate);
                stm.setInt(6, maxQuantity);
                stm.setBoolean(7, status);
                stm.setDate(8, lastUpdateDate);
                stm.setString(9, lastUpdateUser);
                stm.setString(10, courseName);
                stm.setString(11, oldCourse);
                if (stm.executeUpdate() > 0) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
}
