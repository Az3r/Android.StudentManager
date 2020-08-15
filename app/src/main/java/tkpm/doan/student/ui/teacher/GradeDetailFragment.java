package tkpm.doan.student.ui.teacher;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import tkpm.doan.student.databinding.FragmentGradeDetailBinding;
import tkpm.doan.student.ui.components.adapters.StudentAdapter;
import tkpm.doan.student.ui.components.utils.RecyclerViews;

public class GradeDetailFragment extends Fragment {

    private static final String TAG = GradeDetailFragment.class.getName();
    private FragmentGradeDetailBinding binding;
    private TeacherViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentGradeDetailBinding.inflate(inflater, container, false);
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
        setupRecyclerView(binding.recyclerView);
    }
    private void setupRecyclerView(RecyclerView recyclerView) {
        RecyclerViews.setupListView(binding.recyclerView);
        viewModel.getSelectedGrade().observe(getViewLifecycleOwner(), selectedGrade -> {
            Log.i(TAG, String.valueOf(selectedGrade));
            viewModel.getStudents(selectedGrade).observe(getViewLifecycleOwner(), students -> {
                StudentAdapter adapter = new StudentAdapter(requireActivity(), students);
                recyclerView.swapAdapter(adapter, true);
            });
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
