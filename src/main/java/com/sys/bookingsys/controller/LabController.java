package com.sys.bookingsys.controller;

import com.sys.bookingsys.domain.Lab;
import com.sys.bookingsys.domain.Result;
import com.sys.bookingsys.service.LabService;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
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
public class LabController {

    @Autowired
    private LabService labService;

    @GetMapping("/admin/lab/list")
    public List<Lab> getLabList(){
        return labService.getLabList();
    }

    @PostMapping("/admin/lab/addlab")
    public Result addLabByHand(@RequestBody Lab lab){
        System.out.println(lab.getLabName()+lab.getLabCap()+lab.getLabAddition());
        boolean tag = labService.addLabByHand(lab);
        if(tag){
            HashMap<Object, Object> data = new HashMap<>();
            //data.put("labId",lab.getLabId());
            data.put("labName",lab.getLabName());
            data.put("labCap",lab.getLabCap());
            data.put("labAddition",lab.getLabAddition());
            return Result.success(data);
        }else{
            return Result.fail("未能添加成功");
        }
    }

    @PostMapping("/admin/lab/addLabByFile")
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
            InputStream  inputStream = excelFile.getInputStream();
            //创建工作簿并载入excel文件流
            org.apache.poi.ss.usermodel.Workbook wb = WorkbookFactory.create(inputStream);
            //通过索引或者名称获取Sheet
            org.apache.poi.ss.usermodel.Sheet sheet = wb.getSheetAt(0);
            //获取行数
            int rowNum = sheet.getLastRowNum() + 1;

            System.out.println(rowNum);

            for(int i=1; i<rowNum; i++){
                Lab lab1 = new Lab();
                try{
                    Row row = sheet.getRow(i);
                    if(row.getCell(0).getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                        lab1.setLabName(String.valueOf((int)row.getCell(0).getNumericCellValue()));
                    }else{
                        lab1.setLabName(String.valueOf(row.getCell(0)));
                    }
                    if(row.getCell(1).getCellType() != HSSFCell.CELL_TYPE_NUMERIC){
                        throw new Exception();
                    }else{
                        lab1.setLabCap((int)row.getCell(1).getNumericCellValue());
                    }
                    lab1.setLabAddition(String.valueOf(row.getCell(2)));
                }catch (Exception e){
                    tag = true;
                    info += "第" + (i+1) + "行信息错误" + "\n";
                }
                //System.out.println(lab1);
                labService.addLabByHand(lab1);

            }

        }catch (Exception e){
            e.printStackTrace();
        }
        if(tag){
            info += "请仔细查看，并手动添加\n其余行正确已导入";
        }
        return Result.success(info);
    }

    @DeleteMapping("/admin/lab/delete/{labId}")
    public Result deleteLabByLabId(@PathVariable("labId") Integer labId){
        System.out.println(labId);
        boolean tag = labService.deleteLabByLabId(labId);
        if(tag){
            HashMap<Object, Object> data = new HashMap<>();
            data.put("labId",labId);
            data.put("message","删除成功");
            return Result.success(data);
        }else{
            return Result.fail("未能删除成功");
        }
    }

    @RequestMapping(value = "/admin/lab/edit",method = RequestMethod.POST)
    public Result editLabByLabId(@RequestBody Lab lab){

        System.out.println(lab.getLabId());
        System.out.println(lab.getLabName());
        boolean tag = labService.editLabByLabId(lab);
        if(tag){
            HashMap<Object, Object> data = new HashMap<>();
            data.put("labId",lab.getLabId());
            data.put("message","修改成功");
            return Result.success(data);
        }else{
            return Result.fail("修改失败");
        }
    }
}
