package com.sys.bookingsys.controller;

import com.sys.bookingsys.domain.Course;
import com.sys.bookingsys.domain.Lab;
import com.sys.bookingsys.domain.Result;
import com.sys.bookingsys.service.CourseService;
import com.sys.bookingsys.service.LabService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/admin/course/list")
    public List<Course> getCourseList(){
        return courseService.getCourseList();
    }

    @PostMapping("/admin/course/addcourse")
    public Result addCourseByHand(@RequestBody Course course){
        System.out.println(course.getCourseName()+course.getCourseNumber()+course.getCourseOrder());
        boolean tag = courseService.addCourseByHand(course);
        if(tag){
            HashMap<Object, Object> data = new HashMap<>();
            //data.put("labId",lab.getLabId());
            data.put("courseName",course.getCourseName());
            data.put("courseNumber",course.getCourseNumber());
            data.put("courseOrder",course.getCourseOrder());
            return Result.success(data);
        }else{
            return Result.fail("未能添加成功");
        }
    }

    @PostMapping("/admin/course/addCourseByFile")
    @ResponseBody
    public Result addLabByFile(@RequestParam("excelFile")MultipartFile excelFile){

        String name = excelFile.getOriginalFilename();
        System.out.println(name);
        if(!name.contains(".xlsx") ||
                !name.contains(".xls")){
            return Result.fail("文件格式错误");
        }
        boolean tag = false;//用来标记文件中是否有问题行
        String info = "";   //返回给前端的信息
        try{
            InputStream inputStream = excelFile.getInputStream();
            //创建工作簿并载入excel文件流
            org.apache.poi.ss.usermodel.Workbook wb = WorkbookFactory.create(inputStream);
            //通过索引或者名称获取Sheet
            org.apache.poi.ss.usermodel.Sheet sheet = wb.getSheetAt(0);
            //获取行数
            int rowNum = sheet.getLastRowNum() + 1;

            System.out.println(rowNum);

            for(int i=1; i<rowNum; i++){
                Course course1 = new Course();
                try{
                    Row row = sheet.getRow(i);
                    course1.setCourseName(String.valueOf(row.getCell(0)));
                    course1.setCourseNumber(String.valueOf(row.getCell(1)));
                    if(row.getCell(2).getCellType() != HSSFCell.CELL_TYPE_NUMERIC){
                        throw new Exception();
                    }else{
                        course1.setCourseOrder((int)row.getCell(2).getNumericCellValue());
                    }
                    if(row.getCell(3).getCellType() != HSSFCell.CELL_TYPE_NUMERIC){
                        throw new Exception();
                    }else{
                        course1.setCourseHours((int)row.getCell(3).getNumericCellValue());
                    }
                    if(row.getCell(4).getCellType() != HSSFCell.CELL_TYPE_NUMERIC){
                        throw new Exception();
                    }else{
                        course1.setCourseStuNum((int)row.getCell(4).getNumericCellValue());
                    }
                    if(row.getCell(5).getCellType() != HSSFCell.CELL_TYPE_NUMERIC){
                        throw new Exception();
                    }else{
                        course1.setCourseLab((int)row.getCell(5).getNumericCellValue());
                    }
                }catch (Exception e){
                    tag = true;
                    info += "第" + (i+1) + "行信息错误" + "\n";
                }
                //System.out.println(lab1);
                courseService.addCourseByHand(course1);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        if(tag){
            info += "请仔细查看，并手动添加\n其余行正确已导入";
        }
        return Result.success(info);
    }

    @DeleteMapping("/admin/course/delete/{courseId}")
    public Result deleteCourseByCourseId(@PathVariable("courseId") Integer courseId){
        System.out.println(courseId);
        boolean tag = courseService.deleteCourseByCourseId(courseId);
        if(tag){
            HashMap<Object, Object> data = new HashMap<>();
            data.put("courseId",courseId);
            data.put("message","删除成功");
            return Result.success(data);
        }else{
            return Result.fail("未能删除成功");
        }
    }

    @RequestMapping(value = "/admin/course/edit",method = RequestMethod.POST)
    public Result editCourseByCourseId(@RequestBody Course course){

        System.out.println(course.getCourseId());
        System.out.println(course.getCourseName());
        boolean tag = courseService.editCourseByCourseId(course);
        if(tag){
            HashMap<Object, Object> data = new HashMap<>();
            data.put("labId",course.getCourseId());
            data.put("message","修改成功");
            return Result.success(data);
        }else{
            return Result.fail("修改失败");
        }
    }
}
