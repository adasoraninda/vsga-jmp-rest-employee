package com.adasoranina.aplikasirest.model.request;

import com.google.gson.annotations.Expose;

public class EmployeeUpdateRequest {

    @Expose(serialize = false)
    private final Integer id;

    @Expose(serialize = false)
    private final String name;

    @Expose(serialize = false)
    private final String position;

    @Expose(serialize = false)
    private final Integer salary;

    public EmployeeUpdateRequest(Integer id, String name, String position, Integer salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
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
