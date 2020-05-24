package com.sys.bookingsys.domain;

/**
 *
 */
public class Lab {

    private int labId;
    private String labName;
    private int labCap;
    private String labAddition;

    @Override
    public String toString() {
        return "Lab{" +
                "labId=" + labId +
                ", labName='" + labName + '\'' +
                ", labCap=" + labCap +
                ", labAddition='" + labAddition + '\'' +
                '}';
    }

    public int getLabId() {
        return labId;
    }

    public void setLabId(int labId) {
        this.labId = labId;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public int getLabCap() {
        return labCap;
    }

    public void setLabCap(int labCap) {
        this.labCap = labCap;
    }

    public String getLabAddition() {
        return labAddition;
    }

    public void setLabAddition(String labAddition) {
        this.labAddition = labAddition;
    }
}
