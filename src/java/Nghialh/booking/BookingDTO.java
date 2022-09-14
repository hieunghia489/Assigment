/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nghialh.booking;

import java.sql.Date;

/**
 *
 * @author user
 */
public class BookingDTO {
    private int ID;
    private String username;
    private Date bookDate;
    private int money;

    public BookingDTO(int ID, String username, Date bookDate, int money) {
        this.ID = ID;
        this.username = username;
        this.bookDate = bookDate;
        this.money = money;
    }

    public BookingDTO() {
         this.ID = 0;
        this.username = "";
        this.bookDate = null;
        this.money = 0;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBookDate() {
        return bookDate;
    }

    public void setBookDate(Date bookDate) {
        this.bookDate = bookDate;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
    
}
