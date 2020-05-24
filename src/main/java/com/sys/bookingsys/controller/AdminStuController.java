package com.sys.bookingsys.controller;

import com.sys.bookingsys.domain.Result;
import com.sys.bookingsys.domain.Student;
import com.sys.bookingsys.domain.Teacher;
import com.sys.bookingsys.service.AdminStuService;
import com.sys.bookingsys.service.AdminTeaService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

/**
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class AdminStuController {


    @Autowired
    private AdminStuService adminStuService;

    @GetMapping("/admin/stu/list")
    public List<Student> getTeaList(){
        return adminStuService.getStuList();
    }

    @GetMapping("/admin/stu/getOneStu/{studentId}")
    public Student getOneStu(@PathVariable("studentId") Integer studentId){
        return adminStuService.getOneStu(studentId);
    }

    @DeleteMapping("/admin/stu/delete/{studentId}")
    public Result deleteStuByStuId(@PathVariable("studentId") Integer studentId){
        System.out.println(studentId);
        boolean tag = adminStuService.deleteStuByStuId(studentId);
        if(tag){
            HashMap<Object, Object> data = new HashMap<>();
            data.put("studentId",studentId);
            data.put("message","删除成功");
            return Result.success(data);
        }else{
            return Result.fail("未能删除成功");
        }
    }

    @RequestMapping(value = "/admin/stu/edit",method = RequestMethod.POST)
    public Result editStuByStuId(@RequestBody Student student){

        System.out.println(student.getStudentId());
        System.out.println(student.getStuName());
        boolean tag = adminStuService.editStuByStuId(student);
        if(tag){
            HashMap<Object, Object> data = new HashMap<>();
            data.put("studentId",student.getStudentId());
            data.put("message","修改成功");
            return Result.success(data);
        }else{
            return Result.fail("修改失败");
        }
    }
}
