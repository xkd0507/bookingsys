package com.sys.bookingsys.service.impl;

import com.sys.bookingsys.domain.Course;
import com.sys.bookingsys.domain.Lab;
import com.sys.bookingsys.mapper.CourseMapper;
import com.sys.bookingsys.mapper.LabMapper;
import com.sys.bookingsys.service.CourseService;
import com.sys.bookingsys.service.LabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> getCourseList() {
        return courseMapper.getCourseList();
    }
//
    @Override
    public boolean deleteCourseByCourseId(int labId) {
        try{
            courseMapper.deleteCourseByCourseId(labId);
        }catch (Exception e){
            return false;
        }
        return true;

    }
//
    @Override
    public boolean editCourseByCourseId(Course course) {
        try{
            courseMapper.editCourseByCourseId(course);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean addCourseByHand(Course course) {

        try{
            courseMapper.addCourseByHand(course);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
