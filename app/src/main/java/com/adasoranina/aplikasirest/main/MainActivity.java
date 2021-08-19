package com.adasoranina.aplikasirest.main;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.adasoranina.aplikasirest.R;
import com.adasoranina.aplikasirest.model.domain.Employee;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private TextView textError;
    private ProgressBar progressBar;
    private RecyclerView listEmployee;
    private ListEmployeeAdapter employeeAdapter;

    private MainContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textError = findViewById(R.id.text_error);
        progressBar = findViewById(R.id.progress_bar);
        listEmployee = findViewById(R.id.list_employee);

        employeeAdapter = new ListEmployeeAdapter();
        presenter = new MainPresenter(this);

        listEmployee.setAdapter(employeeAdapter);
        presenter.getAllData();
    }

    @Override
    public void showLoading() {
        textError.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void getData(List<Employee> employees) {
        textError.setVisibility(View.GONE);

        employeeAdapter.submitList(new ArrayList<>());
        employeeAdapter.submitList(employees);
        employeeAdapter.notifyDataSetChanged();
    }

    @Override
    public void dismissLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError() {
        textError.setVisibility(View.VISIBLE);
    }
}