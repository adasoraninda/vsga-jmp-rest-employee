package com.adasoranina.aplikasirest.main;

import com.adasoranina.aplikasirest.model.domain.Employee;

import java.util.List;

public interface MainContract {

    interface View {
        void showLoading();

        void getData(List<Employee> employees);

        void dismissLoading();

        void showMessage(String message);

        void showError();
    }

    interface Presenter {
        void getAllData();
    }

}
