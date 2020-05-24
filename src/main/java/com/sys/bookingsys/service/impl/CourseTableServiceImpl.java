package com.sys.bookingsys.service.impl;

import com.sys.bookingsys.domain.CourseTable;
import com.sys.bookingsys.mapper.CourseTableMapper;
import com.sys.bookingsys.service.CourseTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class CourseTableServiceImpl implements CourseTableService {

    @Autowired
    private CourseTableMapper courseTableMapper;

    @Override
    public List<CourseTable> getCourseTable(int weekEst) {

        return courseTableMapper.getCourseTable(weekEst);
    }

}
