package com.sys.bookingsys.service.impl;

import com.sys.bookingsys.domain.Login;
import com.sys.bookingsys.mapper.StuLoginMapper;
import com.sys.bookingsys.service.StuLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class StuLoginServiceImpl implements StuLoginService {

    @Autowired
    private StuLoginMapper stuLoginMapper;

    @Override
    public Login getLoginInByUserName(String name) {
        return stuLoginMapper.getLoginInByUserName(name);
    }
}
