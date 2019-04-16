package com.pwc.springbootprototype.company;

import com.pwc.springbootprototype.employee.EmployeeDto;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class CompanyDto {

    private Long id;

    @NotBlank(message = "violation.required")
    private String name;

    private List<EmployeeDto> employeeDtoList;

    private CompanyDto(final Long id, final String name, final List<EmployeeDto> employeeDtoList) {
        this.id = id;
        this.name = name;
        this.employeeDtoList = employeeDtoList;
    }

    public static Builder builder() {
        return new Builder();
    }

    public CompanyDto() {
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public List<EmployeeDto> getEmployeeDtoList() {
        return this.employeeDtoList;
    }

    public static class Builder {
        private Long id;
        private String name;
        private List<EmployeeDto> employeeDtoList;

        public Builder id( final Long id) {
            this.id = id;
            return this;
        }

        public Builder name( final String name) {
            this.name = name;
            return this;
        }

        public Builder employeeDtoList( final List<EmployeeDto> employeeDtoList) {
            this.employeeDtoList = employeeDtoList;
            return this;
        }

        public CompanyDto build() {
            return new CompanyDto(this.id, this.name, this.employeeDtoList);
        }

    }
}
