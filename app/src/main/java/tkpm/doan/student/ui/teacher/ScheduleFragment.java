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
import androidx.recyclerview.widget.RecyclerView;

import tkpm.doan.student.databinding.FragmentTeacherScheduleBinding;
import tkpm.doan.student.ui.components.adapters.TeacherScheduleAdapter;
import tkpm.doan.student.ui.components.utils.RecyclerViews;

public class ScheduleFragment extends Fragment {
    private FragmentTeacherScheduleBinding binding;
    private TeacherViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentTeacherScheduleBinding.inflate(inflater, container, false);
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
        viewModel = new ViewModelProvider(requireActivity()).get(TeacherViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecyclerView(binding.recyclerView);
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        RecyclerViews.setupGridView(recyclerView, 1);
        viewModel.getSchedule().observe(getViewLifecycleOwner(), schedules -> {
            TeacherScheduleAdapter adapter = new TeacherScheduleAdapter(requireActivity(), schedules);
            recyclerView.swapAdapter(adapter, true);
        });
    }
}
