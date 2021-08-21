package com.adasoranina.aplikasirest.manipulate;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.adasoranina.aplikasirest.R;
import com.adasoranina.aplikasirest.model.domain.Employee;
import com.adasoranina.aplikasirest.network.EmployeeServiceImpl;
import com.adasoranina.aplikasirest.utils.SuccessState;
import com.adasoranina.aplikasirest.utils.ViewState;

public class EmployeeActivity extends AppCompatActivity implements EmployeeContract.View {

    private static final String KEY_ID = "KEY_ID";

    private TextView textLabelId;
    private EditText inputId;
    private EditText inputName;
    private EditText inputPosition;
    private EditText inputSalary;
    private Button buttonAddUpdate;
    private ProgressBar progressBar;

    private EmployeeContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        textLabelId = findViewById(R.id.text_label_id);
        inputId = findViewById(R.id.input_id);
        inputName = findViewById(R.id.input_name);
        inputPosition = findViewById(R.id.input_position);
        inputSalary = findViewById(R.id.input_salary);
        buttonAddUpdate = findViewById(R.id.button_add_update);
        progressBar = findViewById(R.id.progress_bar);

        presenter = new EmployeePresenter(this, new EmployeeServiceImpl());

        setUpActionBar();
        setUpView();

        if (!getMode()) {
            int id = getIntent().getIntExtra(KEY_ID, 0);
            if (id > 0) {
                presenter.getEmployee(id);
            }
        }

        buttonAddUpdate.setOnClickListener(v -> {
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!getMode()) {
            getMenuInflater().inflate(R.menu.menu_employee, menu);
        }

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        } else if (item.getItemId() == R.id.action_delete) {
            Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    private boolean getMode() {
        int id = getIntent().getIntExtra(KEY_ID, 0);
        return id == 0;
    }

    private void setUpActionBar() {
        int messageRes = getMode() ? R.string.title_add : R.string.title_update;

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(getString(messageRes));
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setUpView() {
        int buttonTextRes = getMode() ? R.string.add : R.string.update;
        textLabelId.setVisibility(getMode() ? View.GONE : View.VISIBLE);
        inputId.setVisibility(getMode() ? View.GONE : View.VISIBLE);
        buttonAddUpdate.setText(getString(buttonTextRes));
    }

    private void setUpData(Employee employee) {
        inputId.setText(String.valueOf(employee.getId()));
        inputName.setText(employee.getName());
        inputPosition.setText(employee.getPosition());
        inputSalary.setText(String.valueOf(employee.getSalary()));
    }

    @Override
    public void viewState(ViewState<Employee> state) {
        progressBar.setVisibility(state.isLoading() ? View.VISIBLE : View.GONE);

        if (state.getError() != null) {
            Toast.makeText(this, state.getError(), Toast.LENGTH_SHORT).show();
            return;
        }

        SuccessState<Employee> successState = state.getSuccessState();

        if (successState != null) {
            if (successState.getMessage() != null) {
                Toast.makeText(this, successState.getMessage(), Toast.LENGTH_SHORT).show();
            }

            if (successState.getData() != null) {
                setUpData(successState.getData());
            }
        }
    }

    public static void navigate(Context context, @Nullable Integer id) {
        int checkedId = id == null ? 0 : id;

        Intent intent = new Intent(context, EmployeeActivity.class);
        intent.putExtra(KEY_ID, checkedId);

        context.startActivity(intent);
    }
}
