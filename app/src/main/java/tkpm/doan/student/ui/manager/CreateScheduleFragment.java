package tkpm.doan.student.ui.manager;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;

import tkpm.doan.student.R;
import tkpm.doan.student.databinding.FragmentCreateScheduleBinding;
import tkpm.doan.student.ui.components.adapters.EditScheduleAdapter;
import tkpm.doan.student.ui.components.utils.RecyclerViews;

public class CreateScheduleFragment extends Fragment {

    private FragmentCreateScheduleBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCreateScheduleBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        setHasOptionsMenu(true);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String[] grades = getResources().getStringArray(R.array.array_class);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireActivity(), R.layout.textview, R.id.textview, grades);
        binding.inputClass.setAdapter(adapter);

        String[] dates = getResources().getStringArray(R.array.array_date);
        adapter = new ArrayAdapter<>(requireActivity(), R.layout.textview, R.id.textview, dates);
        binding.inputDate.setAdapter(adapter);

        setupRecyclerView(binding.recyclerView);
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        RecyclerViews.setupListView(recyclerView);

        // TODO setup recyclerview with viewmodel
        // EditScheduleAdapter adapter = ...
        // recyclerView.swapAdapter(adapter, true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.action_edit, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_submit:
                // TODO submoit schedule to database

                return true;
            case R.id.menu_restore:
                // TODO restore to default
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
