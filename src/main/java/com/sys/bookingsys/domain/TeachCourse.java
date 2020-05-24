package com.sys.bookingsys.domain;

/**
 *
 */
public class TeachCourse {

    private int id;
    private int teacherId;
    private int courseId;

    @Override
    public String toString() {
        return "TeachCourse{" +
                "id=" + id +
                ", teacherId=" + teacherId +
                ", courseId=" + courseId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
