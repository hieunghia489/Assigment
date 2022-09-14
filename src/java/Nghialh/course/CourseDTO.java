/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nghialh.course;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author user
 */
public class CourseDTO implements Serializable{

    private String courseName;
    private String imageCourse;
    private String description;
    private int tuitionFee;
    private String category;
    private Date createDate;
    private Date startDate;
    private Date endDate;
    private Date lastUpdateDate;
    private String lastUpdateUser;
    private String createUser;
    private boolean status;
    private int quantity;
    private int maxQuantity;

    public CourseDTO() {
        this.courseName = "";
        this.imageCourse = "";
        this.description = "";
        this.tuitionFee = 0;
        this.category = "";
        this.createDate = null;
        this.startDate = null;
        this.endDate = null;
        this.lastUpdateDate = null;
        this.lastUpdateUser = "";
        this.createUser = "";
        this.status = true;
        this.quantity = 0;
        this.maxQuantity = 0;
    }

    public CourseDTO(String courseName, String imageCourse, String description, int tuitionFee, String category, Date createDate, Date startDate, Date endDate, Date lastUpdateDate, String lastUpdateUser, String createUser, boolean status, int quantity, int maxQuantity) {
        this.courseName = courseName;
        this.imageCourse = imageCourse;
        this.description = description;
        this.tuitionFee = tuitionFee;
        this.category = category;
        this.createDate = createDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.lastUpdateDate = lastUpdateDate;
        this.lastUpdateUser = lastUpdateUser;
        this.createUser = createUser;
        this.status = status;
        this.quantity = quantity;
        this.maxQuantity = maxQuantity;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getImageCourse() {
        return imageCourse;
    }

    public void setImageCourse(String imageCourse) {
        this.imageCourse = imageCourse;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(int tuitionFee) {
        this.tuitionFee = tuitionFee;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(int maxQuantity) {
        this.maxQuantity = maxQuantity;
    }

}
