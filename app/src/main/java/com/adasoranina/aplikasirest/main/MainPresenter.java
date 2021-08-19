package com.adasoranina.aplikasirest.main;

import androidx.annotation.NonNull;

import com.adasoranina.aplikasirest.mapper.DataMapper;
import com.adasoranina.aplikasirest.model.response.ListEmployeeResponse;
import com.adasoranina.aplikasirest.model.response.ResultResponse;
import com.adasoranina.aplikasirest.network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainContract.Presenter {

    private final MainContract.View view;

    public MainPresenter(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void getAllData() {
        view.showLoading();

        Call<ResultResponse<List<ListEmployeeResponse>>> getAllEmployeeCall =
                RetrofitInstance.getService().getAllEmployee();

        getAllEmployeeCall.enqueue(new Callback<ResultResponse<List<ListEmployeeResponse>>>() {
            @Override
            public void onResponse(
                    @NonNull Call<ResultResponse<List<ListEmployeeResponse>>> call,
                    @NonNull Response<ResultResponse<List<ListEmployeeResponse>>> response) {

                if (response.isSuccessful()) {
                    if (response.code() == 200 && response.body() != null) {
                        if (!response.body().getResult().isEmpty()) {
                            view.getData(DataMapper.toDomain(response.body().getResult()));
                        } else {
                            view.showMessage("Data is Empty");
                        }

                        view.showMessage("Success get data");
                    }
                }
            }

            @Override
            public void onFailure(
                    @NonNull Call<ResultResponse<List<ListEmployeeResponse>>> call,
                    @NonNull Throwable t) {
                t.printStackTrace();

                view.showError();
                view.showMessage(t.getLocalizedMessage());
            }
        });

        view.dismissLoading();
    }

}
