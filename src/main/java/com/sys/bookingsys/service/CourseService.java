package com.sys.bookingsys.service;

import com.sys.bookingsys.domain.Course;
import com.sys.bookingsys.domain.Lab;

import java.util.List;

/**
 *
 */
public interface CourseService {
    List<Course> getCourseList();
    boolean deleteCourseByCourseId(int courseId);
    boolean editCourseByCourseId(Course course);
    boolean addCourseByHand(Course course);
}
