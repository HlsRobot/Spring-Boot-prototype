package com.pwc.springbootprototype.company;

import com.pwc.springbootprototype.employee.Employee;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "company")
@Getter
@Setter
public class Company {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company", cascade = CascadeType.REFRESH)
    private List<Employee> employeeList;

    public Company(final String name, final List<Employee> employeeList) {
        this.name = name;
        this.employeeList = employeeList;
    }

    public Company() {
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public List<Employee> getEmployeeList() {
        return this.employeeList;
    }

    public void setEmployeeList(final List<Employee> employeeList) {
        this.employeeList = employeeList != null ? Collections.unmodifiableList(employeeList) : Collections.emptyList();
    }
}
