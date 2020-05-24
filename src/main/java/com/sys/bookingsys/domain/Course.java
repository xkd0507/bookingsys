package com.sys.bookingsys.domain;

/**
 *
 */
public class Course {
    private int courseId;
    private String courseName;
    private String courseNumber;
    private int courseOrder;
    private int courseHours;
    private int courseStuNum;
    private int courseLab;

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseNumber='" + courseNumber + '\'' +
                ", courseOrder=" + courseOrder +
                ", courseHours=" + courseHours +
                ", courseStuNum=" + courseStuNum +
                ", courseLab=" + courseLab +
                '}';
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public int getCourseOrder() {
        return courseOrder;
    }

    public void setCourseOrder(int courseOrder) {
        this.courseOrder = courseOrder;
    }

    public int getCourseHours() {
        return courseHours;
    }

    public void setCourseHours(int courseHours) {
        this.courseHours = courseHours;
    }

    public int getCourseStuNum() {
        return courseStuNum;
    }

    public void setCourseStuNum(int courseStuNum) {
        this.courseStuNum = courseStuNum;
    }

    public int getCourseLab() {
        return courseLab;
    }

    public void setCourseLab(int courseLab) {
        this.courseLab = courseLab;
    }
}
