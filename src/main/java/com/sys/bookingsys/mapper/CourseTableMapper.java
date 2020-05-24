package com.sys.bookingsys.mapper;

import com.sys.bookingsys.domain.CourseTable;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *
 */
@Mapper
public interface CourseTableMapper {
    List<CourseTable> getCourseTable(int weekEst);
}
