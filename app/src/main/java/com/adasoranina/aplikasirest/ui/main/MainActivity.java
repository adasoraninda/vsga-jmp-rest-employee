package com.adasoranina.aplikasirest.ui.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.adasoranina.aplikasirest.R;
import com.adasoranina.aplikasirest.ui.manipulate.EmployeeActivity;
import com.adasoranina.aplikasirest.model.domain.Employee;
import com.adasoranina.aplikasirest.network.EmployeeServiceImpl;
import com.adasoranina.aplikasirest.model.state.SuccessState;
import com.adasoranina.aplikasirest.model.state.ViewState;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private TextView textError;
    private ProgressBar progressBar;
    private ListEmployeeAdapter employeeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textError = findViewById(R.id.text_error);
        progressBar = findViewById(R.id.progress_bar);
        FloatingActionButton buttonAddEmployee = findViewById(R.id.button_add);
        RecyclerView listEmployee = findViewById(R.id.list_employee);

        MainContract.Presenter presenter = new MainPresenter(this, new EmployeeServiceImpl());

        employeeAdapter = new ListEmployeeAdapter(id -> EmployeeActivity.navigate(this, id));

        listEmployee.setAdapter(employeeAdapter);
        presenter.getAllData();

        buttonAddEmployee.setOnClickListener(v -> EmployeeActivity.navigate(this, null));
    }

    @Override
    @SuppressLint("NotifyDataSetChanged")
    public void viewState(ViewState<List<Employee>> state) {
        textError.setVisibility(View.GONE);
        progressBar.setVisibility(state.isLoading() ? View.VISIBLE : View.GONE);

        if (state.getError() != null) {
            textError.setVisibility(View.VISIBLE);
            textError.setText(state.getError());
            return;
        }

        SuccessState<List<Employee>> successState = state.getSuccessState();
        if (successState != null) {
            if (successState.getMessage() != null) {
                Toast.makeText(this, successState.getMessage(), Toast.LENGTH_SHORT).show();
            }

            if (!successState.getData().isEmpty()) {
                employeeAdapter.submitList(new ArrayList<>());
                employeeAdapter.submitList(successState.getData());
                employeeAdapter.notifyDataSetChanged();
            }
        }

    }

    public static void navigate(Context context){
        context.startActivity(new Intent(context, MainActivity.class));
    }

}