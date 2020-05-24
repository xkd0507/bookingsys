package com.sys.bookingsys.service;

import com.sys.bookingsys.domain.Login;

/**
 *
 */
public interface TeaLoginService {
    Login getLoginInByUserName(String name);
}
