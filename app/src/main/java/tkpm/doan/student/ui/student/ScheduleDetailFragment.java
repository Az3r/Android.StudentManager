package tkpm.doan.student.ui.student;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import tkpm.doan.student.data.models.Lesson;
import tkpm.doan.student.databinding.FragmentScheduleDetailBinding;
import tkpm.doan.student.ui.components.adapters.LessonAdapter;

@AndroidEntryPoint
public class ScheduleDetailFragment extends Fragment {

    @Inject
    public List<Lesson> lessons;
    private FragmentScheduleDetailBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentScheduleDetailBinding.inflate(inflater, container, false);
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

    private void setupRecyclerView(RecyclerView recyclerView) {
        LessonAdapter adapter = new LessonAdapter(requireContext(), lessons);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        DividerItemDecoration decoration = new DividerItemDecoration(recyclerView.getContext(), layoutManager.getOrientation());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(decoration);
        recyclerView.setAdapter(adapter);
    }
}
