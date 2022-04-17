package com.hx.cms.mapper.generate;

import com.hx.cms.entity.dto.EmployeeDto;

public interface EmployeeDtoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(EmployeeDto record);

    int insertSelective(EmployeeDto record);

    EmployeeDto selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(EmployeeDto record);

    int updateByPrimaryKey(EmployeeDto record);
}