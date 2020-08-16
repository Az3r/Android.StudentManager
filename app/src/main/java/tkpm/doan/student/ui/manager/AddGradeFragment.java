package tkpm.doan.student.ui.manager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import java.util.List;

import tkpm.doan.student.data.models.Teacher;
import tkpm.doan.student.databinding.FragmentAddClassBinding;
import tkpm.doan.student.databinding.FragmentAddTeacherBinding;

public class AddGradeFragment extends Fragment {
    private FragmentAddClassBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAddClassBinding.inflate(inflater, container, false);
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

        binding.buttonSubmit.setOnClickListener(v -> {
            // TODO submit class to database

            Navigation.findNavController(binding.getRoot()).navigateUp();
        });

        binding.buttonRestore.setOnClickListener(v -> {
            binding.className.getText().clear();
            binding.classTeacher.getText().clear();
        });

        // TODO load list of available teachers
        // List<String> teacherNames = ...
        // ArrayAdapter<String> adapter = new ArrayAdapter(requireActivity(), R.layout.textview, R.id.textview, teachers);
        // binding.classTeacher.setAdapter(adapter);
    }
}
