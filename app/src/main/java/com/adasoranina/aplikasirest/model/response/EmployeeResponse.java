package com.adasoranina.aplikasirest.model.response;

import com.adasoranina.aplikasirest.utils.FormatOutput;
import com.google.gson.annotations.SerializedName;

public class EmployeeResponse {

    @SerializedName(value="id")
    private Integer id;

    @SerializedName(value="name")
    private String name;

    @SerializedName(value="position")
    private String position;

    @SerializedName(value="salary")
    private Integer salary;

    public EmployeeResponse(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public EmployeeResponse(Integer id, String name, String position, Integer salary) {
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


}
