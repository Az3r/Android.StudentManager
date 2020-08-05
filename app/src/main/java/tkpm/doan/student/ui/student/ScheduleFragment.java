package tkpm.doan.student.ui.student;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import tkpm.doan.student.data.models.Schedule;
import tkpm.doan.student.databinding.FragmentScheduleListBinding;
import tkpm.doan.student.ui.components.adapters.ScheduleAdapter;

@AndroidEntryPoint
public class ScheduleFragment extends Fragment {

    private static final String TAG = "ScheduleFragment";

    private FragmentScheduleListBinding binding;

    @Inject
    List<Schedule> schedules;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentScheduleListBinding.inflate(inflater, container, false);
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
        setupRecyclerView(binding.includeLayout.recyclerView);
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        ScheduleAdapter adapter = new ScheduleAdapter(requireActivity(), schedules);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        recyclerView.setAdapter(adapter);


    }
}
