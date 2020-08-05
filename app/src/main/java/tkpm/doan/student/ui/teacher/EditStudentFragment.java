package tkpm.doan.student.ui.teacher;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import tkpm.doan.student.databinding.FragmentStudentProfileBinding;

public class EditStudentFragment extends Fragment {
    private FragmentStudentProfileBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentStudentProfileBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupCommentSection();
    }

    private void setupCommentSection() {
        binding.teacherComment.setVisibility(View.VISIBLE);
        binding.commentInput.setOnFocusChangeListener((v, isFocused) -> {
            if (isFocused) {
                binding.actionButtons.setVisibility(View.VISIBLE);
            } else {
                binding.actionButtons.setVisibility(View.GONE);
            }
        });

        binding.buttonCancel.setOnClickListener(v -> {
            binding.commentInput.getText().clear();
            binding.commentInput.clearFocus();
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
