package com.adasoranina.aplikasirest.manipulate;

import androidx.annotation.Nullable;

import com.adasoranina.aplikasirest.model.domain.Employee;
import com.adasoranina.aplikasirest.network.EmployeeServiceImpl;
import com.adasoranina.aplikasirest.utils.NetworkCallback;
import com.adasoranina.aplikasirest.utils.SuccessState;
import com.adasoranina.aplikasirest.utils.ViewState;

public class EmployeePresenter implements EmployeeContract.Presenter {

    private final EmployeeContract.View view;
    private final EmployeeServiceImpl service;

    public EmployeePresenter(EmployeeContract.View view, EmployeeServiceImpl service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public void getEmployee(@Nullable Integer id) {
        view.viewState(ViewState.loading(true));

        service.getEmployeeById(id, new NetworkCallback<Employee>() {
            @Override
            public void success(Employee data) {
                String message = null;

                if (data == null) {
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

    @Override
    public void addEmployee(String name, String position, Integer salary) {

    }

    @Override
    public void updateEmployee(Integer id, String name, String position, Integer salary) {

    }

    @Override
    public void delete(Integer id) {

    }
}
