package com.adasoranina.aplikasirest.model.request;

import com.google.gson.annotations.Expose;

public class EmployeeAddRequest {

    @Expose(serialize = false)
    private final String name;

    @Expose(serialize = false)
    private final String position;

    @Expose(serialize = false)
    private final Integer salary;

    public EmployeeAddRequest(String name, String position, Integer salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public Integer getSalary() {
        return salary;
    }
}
