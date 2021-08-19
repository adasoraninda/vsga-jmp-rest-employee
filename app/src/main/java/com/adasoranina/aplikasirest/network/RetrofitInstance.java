package com.adasoranina.aplikasirest.network;

import static com.adasoranina.aplikasirest.network.EmployeeEndPoint.BASE_URL;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static EmployeeService getService() {
        return getRetrofit().create(EmployeeService.class);
    }

}
