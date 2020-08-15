package tkpm.doan.student.ui.teacher;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import tkpm.doan.student.databinding.FragmentReportBinding;
import tkpm.doan.student.ui.components.utils.RecyclerViews;

public class ReportFragment extends Fragment implements TextWatcher {

    private FragmentReportBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentReportBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.reportClass.addTextChangedListener(this);
        binding.reportSemester.addTextChangedListener(this);
        binding.reportYear.addTextChangedListener(this);

        setupRecyclerView(binding.recyclerView);
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        RecyclerViews.setupListView(recyclerView);

        // TODO setup adapter
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        String year = binding.reportYear.getText().toString();
        String esmester = binding.reportSemester.getText().toString();
        String grade = binding.reportClass.getText().toString();

        // TODO load students
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
