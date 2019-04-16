package com.pwc.springbootprototype.employee;

public class EmployeeDto {

    private Long id;

    private Long companyId;

    private String firstName;

    private String lastName;

    private Float salary;

    public EmployeeDto(final Long id, final Long companyId, final String firstName, final String lastName, final Float salary) {
        this.id = id;
        this.companyId = companyId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public static Builder builder() { return new Builder(); }

    public EmployeeDto() {
    }

    public Long getId() {
        return this.id;
    }

    public Long getCompanyId() {
        return this.companyId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Float getSalary() {
        return this.salary;
    }

    public static class Builder {

        private Long id;
        private Long companyId;
        private String firstName;
        private String lastName;
        private Float salary;

        public Builder id( final Long id) {
            this.id = id;
            return this;
        }

        public Builder companyId( final Long companyId) {
            this.companyId = companyId;
            return this;
        }

        public Builder firstName( final String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName( final String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder salary( final Float salary) {
            this.salary = salary;
            return this;
        }

        public EmployeeDto build() {
            return new EmployeeDto(this.id, this.companyId, this.firstName, this.lastName, this.salary);
        }

    }
}
