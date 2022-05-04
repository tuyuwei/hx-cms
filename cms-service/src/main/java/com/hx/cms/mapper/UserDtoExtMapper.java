package com.hx.cms.mapper;

import com.hx.cms.entity.dto.UserDto;
import com.hx.cms.mapper.generate.UserDtoMapper;
import org.apache.ibatis.annotations.Param;

public interface UserDtoExtMapper extends UserDtoMapper {

    UserDto findByOpenId(@Param("openId") String openId);

}