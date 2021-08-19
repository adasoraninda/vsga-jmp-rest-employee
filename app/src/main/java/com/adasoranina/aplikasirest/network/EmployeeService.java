package com.adasoranina.aplikasirest.network;

import com.adasoranina.aplikasirest.model.response.ListEmployeeResponse;
import com.adasoranina.aplikasirest.model.response.ResultResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface EmployeeService {

    @GET(value = EmployeeEndPoint.URL_GET_ALL)
    Call<ResultResponse<List<ListEmployeeResponse>>> getAllEmployee();

    @GET(value = EmployeeEndPoint.URL_GET_EMP)
    Call<ResultResponse<List<ListEmployeeResponse>>> getEmployeeById(
            @Query(value = "id") Integer id);

}
