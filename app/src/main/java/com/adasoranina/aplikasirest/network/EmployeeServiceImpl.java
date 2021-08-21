package com.adasoranina.aplikasirest.network;

import androidx.annotation.NonNull;

import com.adasoranina.aplikasirest.utils.mapper.DataMapper;
import com.adasoranina.aplikasirest.model.domain.Employee;
import com.adasoranina.aplikasirest.model.response.EmployeeResponse;
import com.adasoranina.aplikasirest.model.response.ListEmployeeResponse;
import com.adasoranina.aplikasirest.model.response.ResultResponse;
import com.adasoranina.aplikasirest.utils.NetworkCallback;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeeServiceImpl {

    private final EmployeeService service;

    public EmployeeServiceImpl() {
        service = RetrofitInstance.getService();
    }

    public void createEmployee(Employee employee, NetworkCallback<String> networkCallback) {
        Call<String> createEmployeeCall = service.createEmployee(
                employee.getName(),
                employee.getPosition(),
                employee.getSalary());

        createEmployeeCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(
                    @NonNull Call<String> call,
                    @NonNull Response<String> response) {

                if (!response.isSuccessful()) {
                    networkCallback.error(response.message());
                }

                if (response.code() == 200 && response.body() != null) {
                    String responseBody = response.body();

                    if (responseBody.isEmpty()) {
                        networkCallback.success(null);
                        return;
                    }

                    networkCallback.success(responseBody);
                }

            }

            @Override
            public void onFailure(
                    @NonNull Call<String> call,
                    @NonNull Throwable t) {
                t.printStackTrace();

                networkCallback.error(t.getLocalizedMessage());
            }
        });
    }

    public void updateEmployee(Employee employee, NetworkCallback<String> networkCallback) {
        Call<String> updateEmployeeCall = service.updateEmployee(
                employee.getId(),
                employee.getName(),
                employee.getPosition(),
                employee.getSalary());

        updateEmployeeCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(
                    @NonNull Call<String> call,
                    @NonNull Response<String> response) {

                if (!response.isSuccessful()) {
                    networkCallback.error(response.message());
                }

                if (response.code() == 200 && response.body() != null) {
                    String responseBody = response.body();

                    if (responseBody.isEmpty()) {
                        networkCallback.success(null);
                        return;
                    }

                    networkCallback.success(responseBody);
                }

            }

            @Override
            public void onFailure(
                    @NonNull Call<String> call,
                    @NonNull Throwable t) {
                t.printStackTrace();

                networkCallback.error(t.getLocalizedMessage());
            }
        });
    }

    public void deleteEmployeeById(Integer id, NetworkCallback<String> networkCallback) {
        Call<String> deleteEmployeeCall = service.deleteEmployeeById(id);

        deleteEmployeeCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(
                    @NonNull Call<String> call,
                    @NonNull Response<String> response) {

                if (!response.isSuccessful()) {
                    networkCallback.error(response.message());
                }

                if (response.code() == 200 && response.body() != null) {
                    String responseBody = response.body();

                    if (responseBody.isEmpty()) {
                        networkCallback.success(null);
                        return;
                    }

                    networkCallback.success(responseBody);
                }

            }

            @Override
            public void onFailure(
                    @NonNull Call<String> call,
                    @NonNull Throwable t) {
                t.printStackTrace();

                networkCallback.error(t.getLocalizedMessage());
            }
        });
    }

    public void getEmployeeById(Integer id, NetworkCallback<Employee> networkCallback) {
        Call<ResultResponse<List<EmployeeResponse>>> getEmployeeByIdCall = service.getEmployeeById(id);

        getEmployeeByIdCall.enqueue(new Callback<ResultResponse<List<EmployeeResponse>>>() {
            @Override
            public void onResponse(
                    @NonNull Call<ResultResponse<List<EmployeeResponse>>> call,
                    @NonNull Response<ResultResponse<List<EmployeeResponse>>> response) {

                if (!response.isSuccessful()) {
                    networkCallback.error(response.message());
                }

                if (response.code() == 200 && response.body() != null) {
                    List<EmployeeResponse> employeeResponse = response.body().getResult();

                    if (employeeResponse.isEmpty()) {
                        networkCallback.success(null);
                        return;
                    }

                    networkCallback.success(DataMapper.toDomain(response.body().getResult().get(0)));
                }

            }

            @Override
            public void onFailure(
                    @NonNull Call<ResultResponse<List<EmployeeResponse>>> call,
                    @NonNull Throwable t) {
                t.printStackTrace();

                networkCallback.error(t.getLocalizedMessage());
            }
        });
    }

    public void getAllEmployee(NetworkCallback<List<Employee>> networkCallback) {
        Call<ResultResponse<List<ListEmployeeResponse>>> getAllEmployeeCall = service.getAllEmployee();

        getAllEmployeeCall.enqueue(new Callback<ResultResponse<List<ListEmployeeResponse>>>() {
            @Override
            public void onResponse(
                    @NonNull Call<ResultResponse<List<ListEmployeeResponse>>> call,
                    @NonNull Response<ResultResponse<List<ListEmployeeResponse>>> response) {

                if (!response.isSuccessful()) {
                    networkCallback.error(response.message());
                }

                if (response.code() == 200 && response.body() != null) {
                    List<ListEmployeeResponse> listEmployeeResponses = response.body().getResult();

                    if (listEmployeeResponses.isEmpty()) {
                        networkCallback.success(Collections.emptyList());
                        return;
                    }

                    networkCallback.success(DataMapper.toDomain(response.body().getResult()));
                }

            }

            @Override
            public void onFailure(
                    @NonNull Call<ResultResponse<List<ListEmployeeResponse>>> call,
                    @NonNull Throwable t) {
                t.printStackTrace();

                networkCallback.error(t.getLocalizedMessage());
            }
        });
    }


}
