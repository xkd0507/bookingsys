package com.sys.bookingsys.mapper;

import com.sys.bookingsys.domain.Course;
import com.sys.bookingsys.domain.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *
 */
@Mapper
public interface AdminTeaMapper {
    List<Teacher> getTeaList();
    Teacher getOneTea(int teacherId);
    void deleteTeaByTeaId(int teacherId);
    void editTeaByTeaId(Teacher teacher);
    void addTeaByHand(Teacher teacher);
}
