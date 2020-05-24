package com.sys.bookingsys.controller;

import com.sys.bookingsys.domain.Login;
import com.sys.bookingsys.domain.Result;
import com.sys.bookingsys.service.AdminLoginService;
import com.sys.bookingsys.service.StuLoginService;
import com.sys.bookingsys.service.TeaLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {

    @Autowired
    private AdminLoginService adminLoginService;

    @Autowired
    private StuLoginService stuLoginService;

    @Autowired
    private TeaLoginService teaLoginService;

    private Login login = new Login();

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Result login(@RequestBody Map<String ,Object> map){
        //System.out.print(test.toString());
        String name = (String)map.get("name");
        String password = (String)map.get("password");
        String role = (String) map.get("role");
        System.out.println(name + password + role);
        if(role.equals("0")){         //管理员登录
            System.out.println(123);
            login = adminLoginService.getLoginInByUserName(name);
        }else if(role.equals("1")){   //教师登录
            System.out.println(234);
            login = teaLoginService.getLoginInByUserName(name);
        }else if(role.equals("2")){                 //学生代表登录
            System.out.println(345);
            login = stuLoginService.getLoginInByUserName(name);
        }

        if(login == null || !login.getPassword().equals(password)){
            return Result.fail("用户名或密码错误");
        }

        //如果登陆成功，则获取用户信息
        HashMap<Object, Object> data = new HashMap<>();
        data.put("id",login.getId());
        data.put("name",login.getName());
        data.put("role",role);
        return Result.success(data);
    }
}
