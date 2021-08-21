package com.adasoranina.aplikasirest.ui.manipulate;

import androidx.annotation.Nullable;

import com.adasoranina.aplikasirest.model.domain.Employee;
import com.adasoranina.aplikasirest.model.state.SuccessState;
import com.adasoranina.aplikasirest.model.state.ViewState;
import com.adasoranina.aplikasirest.network.EmployeeServiceImpl;
import com.adasoranina.aplikasirest.utils.NetworkCallback;

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

        if (name == null || name.isEmpty()) {
            view.viewState(ViewState.error("Nama harus di isi"));
            return;
        }

        if (position == null || position.isEmpty()) {
            view.viewState(ViewState.error("Posisi harus di isi"));
            return;
        }

        if (salary == null) {
            view.viewState(ViewState.error("Gaji harus di isi"));
            return;
        }

        view.viewState(ViewState.loading(true));

        Employee employee = new Employee(name, position, salary);

        service.createEmployee(employee, new NetworkCallback<String>() {
            @Override
            public void success(String data) {
                StringBuilder messageBuilder = new StringBuilder();

                if (data == null) {
                    messageBuilder.append("Gagal menambah karayawan");
                }

                messageBuilder.append(data);
                view.viewState(ViewState.success(new SuccessState<>(messageBuilder.toString(), null)));
            }

            @Override
            public void error(String message) {
                view.viewState(ViewState.error(message));
            }
        });

        view.viewState(ViewState.loading(false));
    }

    @Override
    public void updateEmployee(Integer id, String name, String position, Integer salary) {
        if (id == null) {
            view.viewState(ViewState.error("Id harus di isi"));
            return;
        }

        if (name == null || name.isEmpty()) {
            view.viewState(ViewState.error("Nama harus di isi"));
            return;
        }

        if (position == null || position.isEmpty()) {
            view.viewState(ViewState.error("Posisi harus di isi"));
            return;
        }

        if (salary == null) {
            view.viewState(ViewState.error("Gaji harus di isi"));
            return;
        }

        view.viewState(ViewState.loading(true));

        Employee employee = new Employee(id, name, position, salary);

        service.updateEmployee(employee, new NetworkCallback<String>() {
            @Override
            public void success(String data) {
                StringBuilder messageBuilder = new StringBuilder();

                if (data == null) {
                    messageBuilder.append("Gagal mengubah karayawan");
                }

                messageBuilder.append(data);
                view.viewState(ViewState.success(new SuccessState<>(messageBuilder.toString(), null)));
            }

            @Override
            public void error(String message) {
                view.viewState(ViewState.error(message));
            }
        });

        view.viewState(ViewState.loading(false));
    }

    @Override
    public void deleteEmployee(Integer id) {
        if (id == null) {
            view.viewState(ViewState.error("Id harus di isi"));
            return;
        }

        view.viewState(ViewState.loading(true));

        service.deleteEmployeeById(id, new NetworkCallback<String>() {
            @Override
            public void success(String data) {
                StringBuilder messageBuilder = new StringBuilder();

                if (data == null) {
                    messageBuilder.append("Gagal menghapus karayawan");
                }

                messageBuilder.append(data);
                view.viewState(ViewState.success(new SuccessState<>(messageBuilder.toString(), null)));
            }

            @Override
            public void error(String message) {
                view.viewState(ViewState.error(message));
            }
        });

        view.viewState(ViewState.loading(false));
    }
}
