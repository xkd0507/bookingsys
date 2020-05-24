package com.sys.bookingsys.controller;

import com.sun.media.sound.DataPusher;
import com.sys.bookingsys.domain.Result;
import com.sys.bookingsys.domain.Student;
import com.sys.bookingsys.domain.Term;
import com.sys.bookingsys.service.AdminStuService;
import com.sys.bookingsys.service.TermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TermController {


    @Autowired
    private TermService termService;

    @RequestMapping(value = "/admin/term/setTerm",method = RequestMethod.POST)
    public Result termSet(@RequestBody Term term){

        System.out.println(term.getTermStartDate());
        System.out.println(term.getTermWeek());
        boolean tag = termService.termSet(term);
        //boolean tag2 = termService.updatePreTerm();
        if(tag){
            HashMap<Object, Object> data = new HashMap<>();
            System.out.println(term.getTermStartDate());
            System.out.println(111111);
            data.put("termStartDate", term.getTermStartDate());
            data.put("termWeek",term.getTermWeek());
            return Result.success(data);
        }else{
            return Result.fail("学期设置失败");
        }
    }



    @GetMapping(value = "admin/term/getTerm")
    public Result getTerm(){
        HashMap<Object, Object> data = new HashMap<>();
        boolean tag = true;
        try{
            data.put("termStartDate", termService.getTerm().getTermStartDate());
            data.put("termWeek", termService.getTerm().getTermWeek());
        }catch (Exception e){
            tag = false;
        }
        if(tag){
            return Result.success(data);
        }else{
            return Result.fail("获取学期失败");
        }

    }

    @GetMapping(value = "admin/term/getTermWeek")
    public Result getTermWeek(){
        HashMap<Object, Object> data = new HashMap<>();
        boolean tag = true;
        try{
            for(int i=1; i<=termService.getTerm().getTermWeek(); i++){
                data.put("label"+i, i);
                data.put("value"+i, i);
            }
        }catch (Exception e){
            tag = false;
        }
        if(tag){
            return Result.success(data);
        }else{
            return Result.fail("获取学期失败");
        }

    }
}
