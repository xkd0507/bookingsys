package com.sys.bookingsys.service;

import com.sys.bookingsys.domain.CourseTable;

import java.util.List;

/**
 *
 */
public interface CourseTableService {
    List<CourseTable> getCourseTable(int weekEst);
}
