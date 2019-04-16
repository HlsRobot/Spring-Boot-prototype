package com.pwc.springbootprototype.company;

import com.pwc.springbootprototype.utils.DataValidator;
import com.pwc.springbootprototype.utils.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
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

    public CompanyDto getCompanyById(final Long id) throws CompanyNotFoundException {

        final Company company = this.companyRepository.findById(id).orElseThrow(() -> new CompanyNotFoundException(id));
        return this.companyMapper.companyToCompanyDto(company);
    }

    public ResponseDto createNewCompany(final CompanyDto companyDto) {
        final Map<String, String> violations = DataValidator.DtoValidator(companyDto);
        if (violations.isEmpty()) {
            this.companyRepository.save(this.companyMapper.companyDtoToCompany(companyDto));
            return new ResponseDto.Builder().httpStatus(HttpStatus.OK.value()).build();
        }
        return new ResponseDto.Builder().httpStatus(HttpStatus.BAD_REQUEST.value()).violations(violations).build();
    }

}
