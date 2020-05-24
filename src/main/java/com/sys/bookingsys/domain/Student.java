package com.sys.bookingsys.domain;

/**
 *
 */
public class Student {

    private int studentId;
    private String stuName;
    private String stuPassword;
    private int departId;

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", stuName='" + stuName + '\'' +
                ", stuPassword='" + stuPassword + '\'' +
                ", departId=" + departId +
                '}';
    }

    public int getDepartId() {
        return departId;
    }

    public void setDepartId(int departId) {
        this.departId = departId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuPassword() {
        return stuPassword;
    }

    public void setStuPassword(String stuPassword) {
        this.stuPassword = stuPassword;
    }
}
