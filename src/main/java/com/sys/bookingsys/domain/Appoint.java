package com.sys.bookingsys.domain;

/**
 *
 */
public class Appoint {

    private int appointId;
    private int appointTeacherId;
    private int appointCourseId;
    private int appointLabId;
    private String appointDate;

    @Override
    public String toString() {
        return "Appoint{" +
                "appointId=" + appointId +
                ", appointTeacherId=" + appointTeacherId +
                ", appointCourseId=" + appointCourseId +
                ", appointLabId=" + appointLabId +
                ", appointDate='" + appointDate + '\'' +
                '}';
    }

    public int getAppointId() {
        return appointId;
    }

    public void setAppointId(int appointId) {
        this.appointId = appointId;
    }

    public int getAppointTeacherId() {
        return appointTeacherId;
    }

    public void setAppointTeacherId(int appointTeacherId) {
        this.appointTeacherId = appointTeacherId;
    }

    public int getAppointCourseId() {
        return appointCourseId;
    }

    public void setAppointCourseId(int appointCourseId) {
        this.appointCourseId = appointCourseId;
    }

    public int getAppointLabId() {
        return appointLabId;
    }

    public void setAppointLabId(int appointLabId) {
        this.appointLabId = appointLabId;
    }

    public String getAppointDate() {
        return appointDate;
    }

    public void setAppointDate(String appointDate) {
        this.appointDate = appointDate;
    }
}
