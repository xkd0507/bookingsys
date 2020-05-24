package com.sys.bookingsys.mapper;

import com.sys.bookingsys.domain.Login;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 */
@Mapper
public interface TeaLoginMapper {
    Login getLoginInByUserName(String name);
}
