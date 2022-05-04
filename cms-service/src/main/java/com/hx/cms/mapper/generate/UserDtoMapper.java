package com.hx.cms.mapper.generate;

import com.hx.cms.entity.dto.UserDto;

public interface UserDtoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserDto record);

    int insertSelective(UserDto record);

    UserDto selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserDto record);

    int updateByPrimaryKey(UserDto record);
}