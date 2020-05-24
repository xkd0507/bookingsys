package com.sys.bookingsys.service.impl;

import com.sys.bookingsys.domain.Login;
import com.sys.bookingsys.mapper.TeaLoginMapper;
import com.sys.bookingsys.service.TeaLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class TeaLoginServiceImpl implements TeaLoginService {

    @Autowired
    private TeaLoginMapper teaLoginMapper;

    @Override
    public Login getLoginInByUserName(String name) {
        return teaLoginMapper.getLoginInByUserName(name);
    }
}
