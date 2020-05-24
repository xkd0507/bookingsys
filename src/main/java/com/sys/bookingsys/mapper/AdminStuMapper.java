package com.sys.bookingsys.mapper;

import com.sys.bookingsys.domain.Student;
import com.sys.bookingsys.domain.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *
 */
@Mapper
public interface AdminStuMapper {
    List<Student> getStuList();
    Student getOneStu(int studentId);
    void deleteStuByStuId(int studentId);
    void editStuByStuId(Student student);
    void addStuByHand(Student student);
}
