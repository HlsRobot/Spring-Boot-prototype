package com.pwc.springbootprototype.employee;

import org.mapstruct.Mapper;

@Mapper
public interface EmployeeMapper {

    public EmployeeDto employeeToEmployeeDto( final Employee employee);
}
