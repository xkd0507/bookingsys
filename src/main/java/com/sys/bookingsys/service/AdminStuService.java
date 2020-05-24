package com.sys.bookingsys.service;

import com.sys.bookingsys.domain.Lab;
import com.sys.bookingsys.domain.Student;

import java.util.List;

/**
 *
 */
public interface AdminStuService {
    List<Student> getStuList();
    Student getOneStu(int studentId);
    boolean deleteStuByStuId(int studentId);
    boolean editStuByStuId(Student student);
    boolean addStuByHand(Student student);
}
