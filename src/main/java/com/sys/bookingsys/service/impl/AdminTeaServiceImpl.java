package com.sys.bookingsys.service.impl;

import com.sys.bookingsys.domain.Course;
import com.sys.bookingsys.domain.Lab;
import com.sys.bookingsys.domain.Teacher;
import com.sys.bookingsys.mapper.AdminTeaMapper;
import com.sys.bookingsys.mapper.CourseMapper;
import com.sys.bookingsys.service.AdminTeaService;
import com.sys.bookingsys.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class AdminTeaServiceImpl implements AdminTeaService {

    @Autowired
    private AdminTeaMapper adminTeaMapper;

    @Override
    public List<Teacher> getTeaList() {
        return adminTeaMapper.getTeaList();
    }

    @Override
    public Teacher getOneTea(int teacherId){
        return adminTeaMapper.getOneTea(teacherId);
    }

    @Override
    public boolean deleteTeaByTeaId(int teacherId) {
        try{
            adminTeaMapper.deleteTeaByTeaId(teacherId);
        }catch (Exception e){
            return false;
        }
        return true;

    }
//
    @Override
    public boolean editTeaByTeaId(Teacher teacher){
        try{
            adminTeaMapper.editTeaByTeaId(teacher);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean addTeaByHand(Teacher teacher){

        try{
            adminTeaMapper.addTeaByHand(teacher);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
