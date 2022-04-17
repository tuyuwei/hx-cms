package com.hx.cms.repository.impl;

import com.hx.cms.entity.dto.EmployeeDto;
import com.hx.cms.mapper.EmployeeDtoExtMapper;
import com.hx.cms.repository.EmployeeRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 *  employee
 *
 * @author: tywei
 * @create: 2022-04-15 8:56 下午
 **/
@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    @Resource
    private EmployeeDtoExtMapper extMapper;

    @Override
    public List<EmployeeDto> findAll() {
        return extMapper.findAll();
    }

    @Override
    public EmployeeDto findByPk(Long id) {
        return extMapper.selectByPrimaryKey(id);
    }
}
