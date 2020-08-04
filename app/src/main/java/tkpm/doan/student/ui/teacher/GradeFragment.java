package tkpm.doan.student.ui.teacher;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import tkpm.doan.student.databinding.FragmentGradeListBinding;
import tkpm.doan.student.ui.components.adapters.GradeAdapter;
import tkpm.doan.student.ui.components.adapters.ScoreAdapter;
import tkpm.doan.student.ui.components.utils.RecyclerViews;

public class GradeFragment extends Fragment {
    private FragmentGradeListBinding binding;
    private TeacherViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentGradeListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        viewModel = new ViewModelProvider(requireActivity()).get(TeacherViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecyclerView(binding.includeLayout.recyclerView);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void setupRecyclerView(RecyclerView recyclerView) {

        RecyclerViews.setupListView(recyclerView);

        viewModel.getTeachingGrades().observe(getViewLifecycleOwner(), grades -> {
            GradeAdapter adapter = new GradeAdapter(requireActivity(), grades);
            recyclerView.swapAdapter(adapter, true);
        });
    }
}
