package com.hx.cms.mapper.generate;

import com.hx.cms.entity.dto.UserDto;

public interface UserDtoMapper {
    int deleteByPrimaryKey(String openId);

    int insert(UserDto record);

    int insertSelective(UserDto record);

    UserDto selectByPrimaryKey(String openId);

    int updateByPrimaryKeySelective(UserDto record);

    int updateByPrimaryKey(UserDto record);
}