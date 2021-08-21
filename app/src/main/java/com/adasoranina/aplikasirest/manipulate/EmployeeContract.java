package com.adasoranina.aplikasirest.manipulate;

import androidx.annotation.Nullable;

import com.adasoranina.aplikasirest.model.domain.Employee;
import com.adasoranina.aplikasirest.utils.ViewState;

public interface EmployeeContract {

    interface View {
        void viewState(ViewState<Employee> state);
    }

    interface Presenter {
        void getEmployee(@Nullable Integer id);

        void addEmployee(String name, String position, Integer salary);

        void updateEmployee(Integer id, String name, String position, Integer salary);

        void delete(Integer id);
    }

}
