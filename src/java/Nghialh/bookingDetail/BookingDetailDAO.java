/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nghialh.bookingDetail;

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
public class BookingDetailDAO {

    public void createBookingDetail(String courseName, int quantity, Date startDate, Date endDate, int maxQuantity, int bookingID, int fee) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "INSERT into tblBookingDetail (courseName, quantity, startDate, endDate, maxQuantity, bookingID, fee) values ( ?, ?, ?, ?, ?, ?, ?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, courseName);
                stm.setInt(2, quantity);
                stm.setDate(3, startDate);
                stm.setDate(4, endDate);
                stm.setInt(5, maxQuantity);
                stm.setInt(6, bookingID);
                stm.setInt(7, fee);
                stm.execute();
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public ArrayList<BookingDetailDTO> getDetailByID(int bookingID) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT * FROM tblBookingDetail WHERE bookingID = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, bookingID);
                rs = stm.executeQuery();
                ArrayList<BookingDetailDTO> list = new ArrayList<>();
                while (rs.next()) {
                    int id = rs.getInt("ID");
                    String courseName = rs.getString("courseName");
                    int quantity = rs.getInt("quantity");
                    Date start = rs.getDate("startDate");
                    Date end = rs.getDate("endDate");
                    int max = rs.getInt("maxQuantity");
                    int fee=rs.getInt("fee");
                    BookingDetailDTO dto = new BookingDetailDTO(id, courseName, quantity, start, end, max, bookingID, fee);
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
}
