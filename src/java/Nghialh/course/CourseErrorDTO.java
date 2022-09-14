/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nghialh.course;

import java.sql.Date;

/**
 *
 * @author user
 */
public class CourseErrorDTO {
     private String courseNameError;
    private String imageCourse;
    private String descriptionError;
    private String tuitionFeeError;
    private String endDateError;
    private String startDateError;
    private String maxQuantityError;

    public CourseErrorDTO(String courseNameError, String imageCourse, String descriptionError, String tuitionFeeError, String endDateError, String startDateError, String maxQuantityError) {
        this.courseNameError = courseNameError;
        this.imageCourse = imageCourse;
        this.descriptionError = descriptionError;
        this.tuitionFeeError = tuitionFeeError;
        this.endDateError = endDateError;
        this.startDateError = startDateError;
        this.maxQuantityError = maxQuantityError;
    }

    public CourseErrorDTO() {
         this.courseNameError = "";
        this.imageCourse = "";
        this.descriptionError = "";
        this.tuitionFeeError = "";
        this.endDateError = "";
        this.startDateError = "";
        this.maxQuantityError = "";
    }

    public String getCourseNameError() {
        return courseNameError;
    }

    public void setCourseNameError(String courseNameError) {
        this.courseNameError = courseNameError;
    }

    public String getImageCourse() {
        return imageCourse;
    }

    public void setImageCourse(String imageCourse) {
        this.imageCourse = imageCourse;
    }

    public String getDescriptionError() {
        return descriptionError;
    }

    public void setDescriptionError(String descriptionError) {
        this.descriptionError = descriptionError;
    }

    public String getTuitionFeeError() {
        return tuitionFeeError;
    }

    public void setTuitionFeeError(String tuitionFeeError) {
        this.tuitionFeeError = tuitionFeeError;
    }

    public String getEndDateError() {
        return endDateError;
    }

    public void setEndDateError(String endDateError) {
        this.endDateError = endDateError;
    }


    public String getStartDateError() {
        return startDateError;
    }

    public void setStartDateError(String startDateError) {
        this.startDateError = startDateError;
    }

    public String getMaxQuantityError() {
        return maxQuantityError;
    }

    public void setMaxQuantityError(String maxQuantityError) {
        this.maxQuantityError = maxQuantityError;
    }
    
}
