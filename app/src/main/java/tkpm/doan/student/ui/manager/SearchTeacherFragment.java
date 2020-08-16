package tkpm.doan.student.ui.manager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;

import tkpm.doan.student.databinding.FragmentSearchStudentBinding;
import tkpm.doan.student.databinding.FragmentSearchTeacherBinding;
import tkpm.doan.student.ui.MainActivity;
import tkpm.doan.student.ui.components.adapters.ManagerStudentAdapter;
import tkpm.doan.student.ui.components.adapters.StudentApdaterManager;
import tkpm.doan.student.ui.components.adapters.TeacherAdapter;
import tkpm.doan.student.ui.components.constants.Keys;
import tkpm.doan.student.ui.components.utils.RecyclerViews;

public class SearchTeacherFragment extends Fragment {
    private FragmentSearchTeacherBinding binding;
    ManagerViewModel viewModel;
    TeacherAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSearchTeacherBinding.inflate(inflater, container, false);
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
        viewModel = new ViewModelProvider(requireActivity()).get(ManagerViewModel.class);
        binding.fab.setOnClickListener(v -> {
            // TODO in viewmodel set selected teacher to empty or null
            viewModel.setSelectedTeacher(null);
            MainActivity activity = (MainActivity) requireActivity();
            NavDirections directions = SearchTeacherFragmentDirections.navigateTeacher();
            activity.getNavController().navigate(directions);
        });
        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                adapter.filter(s);
                // TODO search and display result
                return true;
            }
        });
        setupRecyclerView(binding.recyclerView);
    }
    private void setupRecyclerView(RecyclerView recyclerView) {
        RecyclerViews.setupListView(recyclerView);
        viewModel.GetAllTeacher().observe(getViewLifecycleOwner(), teacherList -> {
            adapter= new TeacherAdapter(requireActivity(), teacherList);
            recyclerView.swapAdapter(adapter, true);
        });
    }
}
