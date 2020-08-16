package tkpm.doan.student.ui.manager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;

import tkpm.doan.student.databinding.FragmentSearchStudentBinding;
import tkpm.doan.student.databinding.FragmentSearchTeacherBinding;
import tkpm.doan.student.ui.MainActivity;
import tkpm.doan.student.ui.components.adapters.ManagerStudentAdapter;
import tkpm.doan.student.ui.components.utils.RecyclerViews;

public class SearchTeacherFragment extends Fragment {
    private FragmentSearchTeacherBinding binding;

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

        binding.fab.setOnClickListener(v -> {
            // TODO in viewmodel set selected teacher to empty or null

            MainActivity activity = (MainActivity) requireActivity();
            NavDirections directions = SearchTeacherFragmentDirections.navigateTeacher();
            activity.getNavController().navigate(directions);
        });

        setupRecyclerView(binding.recyclerView);
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        RecyclerViews.setupListView(recyclerView);

        // TODO setup adapter
        // TeacherAdapter adapter = ...
        // binding.recyclerView.swapAdapter(adapter, true);
    }
}
