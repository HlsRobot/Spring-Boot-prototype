package com.pwc.springbootprototype.company;

import com.pwc.springbootprototype.utils.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyController.class);

    private final CompanyService companyService;

    @Autowired
    public CompanyController(final CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/all")
    public List<CompanyDto> getAllCompanies() {
        return this.companyService.getAllCompanies();
    }

    @GetMapping
    public CompanyDto getCompanyById(@RequestParam("id") @NotNull final Long id) throws CompanyNotFoundException {
        return this.companyService.getCompanyById(id);
    }

    @PostMapping
    public ResponseDto createNewCompany(@RequestBody final CompanyDto companyDto) {
        return this.companyService.createNewCompany(companyDto);
    }

    @ExceptionHandler({CompanyException.class})
    public ResponseEntity<String> handleUserAuthenticationException(final CompanyException ex) {
        LOGGER.error(ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
