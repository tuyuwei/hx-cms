package com.hx.cms.repository.impl;

import cn.hutool.core.lang.Snowflake;
import com.hx.cms.entity.dto.UserDto;
import com.hx.cms.exception.OperateException;
import com.hx.cms.exception.RequestException;
import com.hx.cms.mapper.UserDtoExtMapper;
import com.hx.cms.repository.UserRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Objects;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Resource
    private UserDtoExtMapper mapper;

    @Resource
    private Snowflake snowflake;

    @Override
    public UserDto findByOpenId(String openId) {
        return mapper.findByOpenId(openId);
    }

    @Override
    public UserDto findById(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public void save(UserDto userDto) {
        if (Objects.isNull(userDto)) {
            throw new RequestException("record is null");
        }
        int row;
        if (Objects.isNull(userDto.getId())) {
            userDto.setId(snowflake.nextId());
            row = mapper.insertSelective(userDto);
        } else {
            row = mapper.updateByPrimaryKey(userDto);
        }

        if (row != 1) {
            throw new OperateException("更新失败. id:" + userDto.getId());
        }
    }
}
