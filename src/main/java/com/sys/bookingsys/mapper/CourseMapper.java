package com.sys.bookingsys.mapper;

import com.sys.bookingsys.domain.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *
 */
@Mapper
public interface CourseMapper {
    List<Course> getCourseList();
    void deleteCourseByCourseId(int courseId);
    void editCourseByCourseId(Course course);
    void addCourseByHand(Course course);
}
