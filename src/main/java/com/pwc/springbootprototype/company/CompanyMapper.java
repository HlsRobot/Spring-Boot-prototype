package com.pwc.springbootprototype.company;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    public CompanyDto companyToCompanyDto( final Company company);

    public Company companyDtoToCompany( final CompanyDto companyDto);
}
