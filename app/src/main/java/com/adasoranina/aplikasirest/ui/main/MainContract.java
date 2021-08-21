package com.adasoranina.aplikasirest.ui.main;

import com.adasoranina.aplikasirest.model.domain.Employee;
import com.adasoranina.aplikasirest.model.state.ViewState;

import java.util.List;

public interface MainContract {

    interface View {
        void viewState(ViewState<List<Employee>> state);
    }

    interface Presenter {
        void getAllData();
    }

}
