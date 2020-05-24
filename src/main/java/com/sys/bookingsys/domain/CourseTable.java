package com.sys.bookingsys.domain;

/**
 *
 */
public class CourseTable {
    private int id;
    private int courseId;
    private int weekEst;
    private int dayEst;
    private int section;
    private int teacherId;
    private String teacherName;
    private String courseName;
    private String labName;

    @Override
    public String toString() {
        return "CourseTable{" +
                "id=" + id +
                ", courseId=" + courseId +
                ", weekEst=" + weekEst +
                ", dayEst=" + dayEst +
                ", section=" + section +
                ", teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", courseName='" + courseName + '\'' +
                ", labName='" + labName + '\'' +
                '}';
    }

    public String getlabName() {
        return labName;
    }

    public void setlabName(String labName) {
        this.labName = labName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getWeekEst() {
        return weekEst;
    }

    public void setWeekEst(int weekEst) {
        this.weekEst = weekEst;
    }

    public int getDayEst() {
        return dayEst;
    }

    public void setDayEst(int dayEst) {
        this.dayEst = dayEst;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
