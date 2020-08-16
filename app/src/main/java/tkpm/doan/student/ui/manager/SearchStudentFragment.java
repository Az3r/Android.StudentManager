package tkpm.doan.student.ui.manager;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import tkpm.doan.student.R;
import tkpm.doan.student.data.models.RequestStudent;
import tkpm.doan.student.data.models.Student;
import tkpm.doan.student.ui.MainActivity;
import tkpm.doan.student.databinding.FragmentSearchStudentBinding;
import tkpm.doan.student.ui.components.adapters.ManagerStudentAdapter;
import tkpm.doan.student.ui.components.adapters.NotifyAdapterManager;
import tkpm.doan.student.ui.components.adapters.StudentAdapter;
import tkpm.doan.student.ui.components.adapters.StudentApdaterManager;
import tkpm.doan.student.ui.components.constants.Keys;
import tkpm.doan.student.ui.components.utils.RecyclerViews;

public class SearchStudentFragment extends Fragment {
    private FragmentSearchStudentBinding binding;
    private ManagerViewModel viewModel;
    private List<RequestStudent> studentList;
    StudentApdaterManager adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSearchStudentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        setHasOptionsMenu(true);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(ManagerViewModel.class);
        setupRecyclerView(binding.recyclerView);
        binding.block10.setChecked(true);
        binding.block12.setChecked(true);
        binding.block11.setChecked(true);
        binding.fab.setOnClickListener(v -> {
            MainActivity activity = (MainActivity) requireActivity();
            NavDirections directions = SearchStudentFragmentDirections.navigateAddStudent();
            activity.getNavController().navigate(directions);
        });
        binding.block10.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if(isChecked)
            {
                adapter.filter("10",1);
            }
            else
            {
                adapter.filter("10",2);
            }

        });
        binding.block11.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if(isChecked)
            {
                adapter.filter("11",1);
            }
            else
            {
                adapter.filter("11",2);
            }
        });
        binding.block12.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if(isChecked)
            {
                adapter.filter("12",1);
            }
            else
            {
                adapter.filter("12",2);
            }
        });
        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                boolean include10 = binding.block10.isChecked();
                boolean include11 = binding.block11.isChecked();
                boolean include12 = binding.block12.isChecked();
                adapter.filter(s,3);
                // TODO search and display result
                return true;
            }
        });
    }
    private void setupRecyclerView(RecyclerView recyclerView) {
        RecyclerViews.setupListView(recyclerView);
        viewModel.getAllStudent(Keys.year).observe(getViewLifecycleOwner(), notifications -> {
            studentList = notifications;
            adapter= new StudentApdaterManager(requireActivity(), studentList);
            recyclerView.swapAdapter(adapter, true);
        });
    }
}
