package com.sys.bookingsys.service;

import com.sys.bookingsys.domain.Lab;
import com.sys.bookingsys.domain.Teacher;

import java.util.List;

/**
 *
 */
public interface AdminTeaService {
    List<Teacher> getTeaList();
    Teacher getOneTea(int teacherId);
    boolean deleteTeaByTeaId(int teacherId);
    boolean editTeaByTeaId(Teacher teacher);
    boolean addTeaByHand(Teacher teacher);
}
