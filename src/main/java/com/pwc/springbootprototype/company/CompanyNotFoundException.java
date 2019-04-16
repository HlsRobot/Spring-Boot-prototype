package com.pwc.springbootprototype.company;

public class CompanyNotFoundException extends CompanyException {

    public CompanyNotFoundException(final Long id) {
        super(String.format("The company with id %d does not exist in the database.", id));
    }
}
