package com.sys.bookingsys.domain;

import java.util.Date;

/**
 *
 */
public class Term {
    private int termId;
    private Date termStartDate;
    private int termWeek;
    private int termStatus;

    @Override
    public String toString() {
        return "Term{" +
                "termId=" + termId +
                ", termStartDate=" + termStartDate +
                ", termWeek=" + termWeek +
                ", termStatus=" + termStatus +
                '}';
    }

    public int getTermId() {
        return termId;
    }

    public void setTermId(int termId) {
        this.termId = termId;
    }

    public Date getTermStartDate() {
        return termStartDate;
    }

    public void setTermStartDate(Date termStartDate) {
        this.termStartDate = termStartDate;
    }

    public int getTermWeek() {
        return termWeek;
    }

    public void setTermWeek(int termWeek) {
        this.termWeek = termWeek;
    }

    public int getTermStatus() {
        return termStatus;
    }

    public void setTermStatus(int termStatus) {
        this.termStatus = termStatus;
    }
}
