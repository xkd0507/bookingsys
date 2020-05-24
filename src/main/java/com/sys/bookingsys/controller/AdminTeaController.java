package com.sys.bookingsys.controller;

import com.sys.bookingsys.domain.Course;
import com.sys.bookingsys.domain.Result;
import com.sys.bookingsys.domain.Teacher;
import com.sys.bookingsys.service.AdminTeaService;
import com.sys.bookingsys.service.CourseService;
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
public class AdminTeaController {


    @Autowired
    private AdminTeaService adminTeaService;

    @GetMapping("/admin/tea/list")
    public List<Teacher> getTeaList(){
        return adminTeaService.getTeaList();
    }


    @GetMapping("admin/tea/getOneTea/{teacherId}")
    public Teacher getOneTea(@PathVariable("teacherId") Integer teacherId){
        return adminTeaService.getOneTea(teacherId);
    }

    @PostMapping("/admin/tea/addtea")
    public Result addTeaByHand(@RequestBody Teacher teacher){
        System.out.println(teacher.getTeacherId()+teacher.getTeacherName()+teacher.getTelephone());
        boolean tag = adminTeaService.addTeaByHand(teacher);
        if(tag){
            HashMap<Object, Object> data = new HashMap<>();
            //data.put("labId",lab.getLabId());
            data.put("teacherName",teacher.getTeacherName());
            data.put("telephone",teacher.getTelephone());
            data.put("teacherId",teacher.getTeacherId());
            return Result.success(data);
        }else{
            return Result.fail("未能添加成功");
        }
    }

    @PostMapping("/admin/tea/addTeaByFile")
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
                Teacher teacher = new Teacher();
                try{
                    Row row = sheet.getRow(i);
                    teacher.setTeacherName(String.valueOf(row.getCell(0)));
                    if(row.getCell(1).getCellType() != HSSFCell.CELL_TYPE_NUMERIC){
                        teacher.setTeacherPassword(String.valueOf(row.getCell(1)));
                    }else{
                        teacher.setTeacherPassword(String.valueOf((int)row.getCell(1).getNumericCellValue()));
                    }
                    if(row.getCell(2).getCellType() != HSSFCell.CELL_TYPE_NUMERIC){
                        teacher.setTelephone(String.valueOf(row.getCell(2)));
                    }else{
                        teacher.setTelephone(new BigDecimal(row.getCell(2).getNumericCellValue()).toString() );
                    }
//                    System.out.println(String.valueOf(row.getCell(2)));
//                    System.out.println(row.getCell(2).getCellType() == HSSFCell.CELL_TYPE_NUMERIC);
//                    teacher.setTelephone(String.valueOf(row.getCell(2)));
                    if(row.getCell(3).getCellType() != HSSFCell.CELL_TYPE_NUMERIC){
                        throw new Exception();
                    }else{
                        teacher.setDepartId((int)row.getCell(3).getNumericCellValue());
                    }
                }catch (Exception e){
                    tag = true;
                    info += "第" + (i+1) + "行信息错误" + "\n";
                }
                //System.out.println(lab1);
                adminTeaService.addTeaByHand(teacher);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        if(tag){
            info += "请仔细查看，并手动添加\n其余行正确已导入";
        }
        return Result.success(info);
    }


    @DeleteMapping("/admin/tea/delete/{teacherId}")
    public Result deleteTeaByTeaId(@PathVariable("teacherId") Integer teacherId){
        System.out.println(teacherId);
        boolean tag = adminTeaService.deleteTeaByTeaId(teacherId);
        if(tag){
            HashMap<Object, Object> data = new HashMap<>();
            data.put("teacherId",teacherId);
            data.put("message","删除成功");
            return Result.success(data);
        }else{
            return Result.fail("未能删除成功");
        }
    }

    @RequestMapping(value = "/admin/tea/edit",method = RequestMethod.POST)
    public Result editTeaByTeaId(@RequestBody Teacher teacher){

        System.out.println(teacher.getTeacherId());
        System.out.println(teacher.getTeacherName());
        boolean tag = adminTeaService.editTeaByTeaId(teacher);
        if(tag){
            HashMap<Object, Object> data = new HashMap<>();
            data.put("teacherId",teacher.getTeacherId());
            data.put("message","修改成功");
            return Result.success(data);
        }else{
            return Result.fail("修改失败");
        }
    }
}
