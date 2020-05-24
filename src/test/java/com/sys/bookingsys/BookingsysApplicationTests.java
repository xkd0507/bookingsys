package com.sys.bookingsys;

import com.sys.bookingsys.mapper.AdminLoginMapper;
import com.sys.bookingsys.service.AdminLoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookingsysApplicationTests {

    @Autowired
    private AdminLoginMapper adminLoginService;

    @Test
    void contextLoads() {
        System.out.println(adminLoginService.getLoginInByUserName("admin1"));
    }

}
