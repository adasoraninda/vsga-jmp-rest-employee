package com.adasoranina.aplikasirest.main;

import com.adasoranina.aplikasirest.model.domain.Employee;
import com.adasoranina.aplikasirest.utils.ViewState;

import java.util.List;

public interface MainContract {

    interface View {
        void viewState(ViewState<List<Employee>> state);
    }

    interface Presenter {
        void getAllData();
    }

}
