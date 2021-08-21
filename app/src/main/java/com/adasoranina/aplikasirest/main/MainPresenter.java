package com.adasoranina.aplikasirest.main;

import com.adasoranina.aplikasirest.model.domain.Employee;
import com.adasoranina.aplikasirest.network.EmployeeServiceImpl;
import com.adasoranina.aplikasirest.utils.NetworkCallback;
import com.adasoranina.aplikasirest.utils.SuccessState;
import com.adasoranina.aplikasirest.utils.ViewState;

import java.util.List;

public class MainPresenter implements MainContract.Presenter {

    private final MainContract.View view;
    private final EmployeeServiceImpl service;

    public MainPresenter(MainContract.View view, EmployeeServiceImpl service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public void getAllData() {
        view.viewState(ViewState.loading(true));

        service.getAllEmployee(new NetworkCallback<List<Employee>>() {
            @Override
            public void success(List<Employee> data) {
                String message = null;

                if (data.isEmpty()) {
                    message = "Data kosong";
                }

                view.viewState(ViewState.success(new SuccessState<>(message, data)));
            }

            @Override
            public void error(String message) {
                view.viewState(ViewState.error(message));
            }
        });

        view.viewState(ViewState.loading(false));
    }

}
