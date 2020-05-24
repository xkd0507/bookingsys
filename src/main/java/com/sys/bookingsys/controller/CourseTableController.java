package com.sys.bookingsys.controller;

import com.sys.bookingsys.domain.CourseTable;
import com.sys.bookingsys.service.CourseTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 */
@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
public class CourseTableController {

    @Autowired
    private CourseTableService courseTableService;

    @GetMapping("/coursetable/{weekEst}")
    public List<CourseTable> getCourseTable(@PathVariable("weekEst") int weekEst){
        return courseTableService.getCourseTable(weekEst);
    }
}
