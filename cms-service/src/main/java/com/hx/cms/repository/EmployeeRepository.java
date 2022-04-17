package com.hx.cms.repository;

import com.hx.cms.entity.dto.EmployeeDto;

import java.util.List;

public interface EmployeeRepository {


    List<EmployeeDto> findAll();


    EmployeeDto findByPk(Long id);

}
