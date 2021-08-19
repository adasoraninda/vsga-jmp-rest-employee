package com.adasoranina.aplikasirest.mapper;

import com.adasoranina.aplikasirest.model.domain.Employee;
import com.adasoranina.aplikasirest.model.response.ListEmployeeResponse;

import java.util.ArrayList;
import java.util.List;

public class DataMapper {

    public static List<Employee> toDomain(List<ListEmployeeResponse> employeeResponses) {
        List<Employee> employees = new ArrayList<>();

        for (ListEmployeeResponse employeeResponse : employeeResponses) {
            employees.add(new Employee(
                    employeeResponse.getId(),
                    employeeResponse.getName()));
        }

        return employees;
    }

}
