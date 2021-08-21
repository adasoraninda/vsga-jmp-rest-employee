package com.adasoranina.aplikasirest.network;

import com.adasoranina.aplikasirest.model.response.EmployeeResponse;
import com.adasoranina.aplikasirest.model.response.ListEmployeeResponse;
import com.adasoranina.aplikasirest.model.response.ResultResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface EmployeeService {

    @GET(value = EmployeeEndPoint.URL_GET_ALL)
    Call<ResultResponse<List<ListEmployeeResponse>>> getAllEmployee();

    @GET(value = EmployeeEndPoint.URL_GET_EMP)
    Call<ResultResponse<List<EmployeeResponse>>> getEmployeeById(
            @Query(value = EmployeeEndPoint.VARIABLE_ID) Integer id);

    @FormUrlEncoded
    @POST(value = EmployeeEndPoint.URL_ADD)
    Call<String> createEmployee(
            @Field(value = "name") String name,
            @Field(value = "position") String position,
            @Field(value = "salary") Integer salary);

    @FormUrlEncoded
    @POST(value = EmployeeEndPoint.URL_UPDATE_EMP)
    Call<String> updateEmployee(
            @Field(value = "id") Integer id,
            @Field(value = "name") String name,
            @Field(value = "position") String position,
            @Field(value = "salary") Integer salary);

    @GET(value = EmployeeEndPoint.URL_DELETE_EMP)
    Call<String> deleteEmployeeById(
            @Query(value = EmployeeEndPoint.VARIABLE_ID) Integer id);

}
