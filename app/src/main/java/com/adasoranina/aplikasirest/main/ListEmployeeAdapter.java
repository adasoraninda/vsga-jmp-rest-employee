package com.adasoranina.aplikasirest.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.adasoranina.aplikasirest.R;
import com.adasoranina.aplikasirest.model.domain.Employee;

public class ListEmployeeAdapter extends ListAdapter<Employee, ListEmployeeAdapter.EmployeeViewHolder> {

    public ListEmployeeAdapter() {
        super(new DiffCallback());
    }

    static class EmployeeViewHolder extends RecyclerView.ViewHolder {
        private final TextView textId;
        private final TextView textName;

        public EmployeeViewHolder(View itemView) {
            super(itemView);
            textId = itemView.findViewById(R.id.text_id);
            textName = itemView.findViewById(R.id.text_name);
        }

        public void bind(Employee employee) {
            textId.setText(String.valueOf(employee.getId()));
            textName.setText(employee.getName());
        }

    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_employee, parent, false);

        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    public static class DiffCallback extends DiffUtil.ItemCallback<Employee> {
        @Override
        public boolean areItemsTheSame(@NonNull Employee oldItem, @NonNull Employee newItem) {
            return oldItem.getId().equals(newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Employee oldItem, @NonNull Employee newItem) {
            return oldItem.equals(newItem);
        }
    }

}
