package com.sys.bookingsys.service;

import com.sys.bookingsys.domain.Login;

/**
 *
 */
public interface AdminLoginService {

    Login getLoginInByUserName(String name);
}
