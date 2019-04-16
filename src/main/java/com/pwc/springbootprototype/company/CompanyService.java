package com.pwc.springbootprototype.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    private final CompanyMapper companyMapper;

    @Autowired
    public CompanyService(final CompanyRepository companyRepository, final CompanyMapper companyMapper) {
        this.companyRepository = companyRepository;
        this.companyMapper = companyMapper;
    }

    public List<CompanyDto> getAllCompanies() {
        return this.companyRepository.findAll()
                .stream().map(this.companyMapper::companyToCompanyDto).collect(Collectors.toList());
    }


}
