package com.adasoranina.aplikasirest.utils.mapper;

import com.adasoranina.aplikasirest.model.domain.Employee;
import com.adasoranina.aplikasirest.model.request.EmployeeAddRequest;
import com.adasoranina.aplikasirest.model.request.EmployeeUpdateRequest;
import com.adasoranina.aplikasirest.model.response.EmployeeResponse;
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

    public static Employee toDomain(EmployeeResponse employeeResponse) {
        return new Employee(
                employeeResponse.getId(),
                employeeResponse.getName(),
                employeeResponse.getPosition(),
                employeeResponse.getSalary());
    }

    public static EmployeeAddRequest toAddRequest(Employee employee) {
        return new EmployeeAddRequest(
                employee.getName(),
                employee.getPosition(),
                employee.getSalary());
    }

    public static EmployeeUpdateRequest toUpdateRequest(Employee employee) {
        return new EmployeeUpdateRequest(
                employee.getId(),
                employee.getName(),
                employee.getPosition(),
                employee.getSalary());
    }


}
