/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nghialh.booking;

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
public class BookingDAO {

    public ArrayList<BookingDTO> getAllBookingByUserName(String username) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT * FROM tblBooking WHERE username =?";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                rs = stm.executeQuery();
                ArrayList<BookingDTO> list = new ArrayList<>();
                while (rs.next()) {
                    int ID = rs.getInt("ID");
                    Date bookDate = rs.getDate("bookDate");
                    int totalFee = rs.getInt("totalFee");
                    BookingDTO dto = new BookingDTO(ID, username, bookDate, totalFee);
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

    public BookingDTO confirmBooking(String username, Date d, int totalFee) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "INSERT into tblBooking (username, bookDate, totalFee) values ( ?, ?, ?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setDate(2, d);
                stm.setInt(3, totalFee);
                if (stm.executeUpdate() > 0) {
                    int id = getBookingID(username, d, totalFee);
                    BookingDTO dto = new BookingDTO(id, username, d, totalFee);
                    return dto;
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
        return null;
    }

    public int getBookingID(String username, Date d, int totalFee) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT ID from tblBooking where username = ? AND bookDate = ? AND totalFee = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setDate(2, d);
                stm.setInt(3, totalFee);
                rs = stm.executeQuery();
                if (rs.next()) {
                    return rs.getInt("ID");
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
        return -1;
    }
}
