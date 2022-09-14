/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nghialh.bookingDetail;

import java.sql.Date;

/**
 *
 * @author user
 */
public class BookingDetailDTO {

    private int ID;
    private String courseName;
    private int quantity;
    private Date startDate;
    private Date endDate;
    private int maxQuantity;
    private int bookingID;
    private int fee;
    

    public BookingDetailDTO(int ID, String courseName, int quantity, Date startDate, Date endDate, int maxQuantity, int bookingID, int fee) {
        this.ID = ID;
        this.courseName = courseName;
        this.quantity = quantity;
        this.startDate = startDate;
        this.endDate = endDate;
        this.maxQuantity = maxQuantity;
        this.bookingID = bookingID;
        this.fee=fee;
    }

    public BookingDetailDTO() {
        this.ID = 0;
        this.courseName = "";
        this.quantity = 0;
        this.startDate = null;
        this.endDate = null;
        this.maxQuantity = 0;
        this.bookingID = 0;
        this.fee=0;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(int maxQuantity) {
        this.maxQuantity = maxQuantity;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

}
