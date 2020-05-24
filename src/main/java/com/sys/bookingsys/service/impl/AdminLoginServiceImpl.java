package com.sys.bookingsys.service.impl;

import com.sys.bookingsys.domain.Login;
import com.sys.bookingsys.mapper.AdminLoginMapper;
import com.sys.bookingsys.service.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class AdminLoginServiceImpl implements AdminLoginService {


    @Autowired
    private AdminLoginMapper loginMapper;

    @Override
    public Login getLoginInByUserName(String name) {
        return loginMapper.getLoginInByUserName(name);
    }
}
