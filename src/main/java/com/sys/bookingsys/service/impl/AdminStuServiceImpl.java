package com.sys.bookingsys.service.impl;

import com.sys.bookingsys.domain.Student;
import com.sys.bookingsys.domain.Teacher;
import com.sys.bookingsys.mapper.AdminStuMapper;
import com.sys.bookingsys.mapper.AdminTeaMapper;
import com.sys.bookingsys.service.AdminStuService;
import com.sys.bookingsys.service.AdminTeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class AdminStuServiceImpl implements AdminStuService {

    @Autowired
    private AdminStuMapper adminStuMapper;

    @Override
    public List<Student> getStuList() {
        return adminStuMapper.getStuList();
    }

    @Override
    public Student getOneStu(int studentId){
        return adminStuMapper.getOneStu(studentId);
    }

    @Override
    public boolean deleteStuByStuId(int studentId) {
        try{
            adminStuMapper.deleteStuByStuId(studentId);
        }catch (Exception e){
            return false;
        }
        return true;

    }
//
    @Override
    public boolean editStuByStuId(Student student){
        try{
            adminStuMapper.editStuByStuId(student);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean addStuByHand(Student student){

        try{
            adminStuMapper.addStuByHand(student);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
