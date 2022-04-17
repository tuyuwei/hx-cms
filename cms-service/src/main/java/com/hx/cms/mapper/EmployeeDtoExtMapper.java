package com.hx.cms.mapper;

import com.hx.cms.entity.dto.EmployeeDto;
import com.hx.cms.mapper.generate.EmployeeDtoMapper;

import java.util.List;

/**
 * @author: tywei
 * @create: 2022-04-15 8:52 下午
 **/
public interface EmployeeDtoExtMapper extends EmployeeDtoMapper {

    List<EmployeeDto> findAll();

}
