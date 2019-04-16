package com.pwc.springbootprototype.employee;

import com.pwc.springbootprototype.company.Company;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "company_id", referencedColumnName = "id", nullable = false)
    private Company company;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "salary")
    private Float salary;

    public Employee(final Company company, final String firstName, final String lastName, final Float salary) {
        this.company = company;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public Employee() {
    }

    public Long getId() {
        return this.id;
    }

    public Company getCompany() {
        return this.company;
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
}
