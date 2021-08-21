package com.adasoranina.aplikasirest.model.domain;

import com.adasoranina.aplikasirest.utils.FormatOutput;

import java.util.Objects;

public class Employee {

    private Integer id;
    private String name;
    private String position;
    private Integer salary;

    public Employee(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employee(String name, String position, Integer salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public Employee(Integer id, String name, String position, Integer salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return FormatOutput.formatEmptyDataString(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return FormatOutput.formatEmptyDataString(position);
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(name, employee.name) && Objects.equals(position, employee.position) && Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, position, salary);
    }

}
