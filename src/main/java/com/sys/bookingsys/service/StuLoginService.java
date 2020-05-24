package com.sys.bookingsys.service;

import com.sys.bookingsys.domain.Login;

/**
 *
 */
public interface StuLoginService {

    Login getLoginInByUserName(String name);
}
