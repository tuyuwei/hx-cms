package com.hx.cms.repository;

import com.hx.cms.entity.dto.UserDto;

public interface UserRepository {


    UserDto findByOpenId(String openId);

    UserDto findById(Long id);

    void save(UserDto userDto);

}
