package tkpm.doan.student.ui.teacher;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;

import java.util.Arrays;
import java.util.List;

import tkpm.doan.student.R;
import tkpm.doan.student.databinding.FragmentStudentBinding;
import tkpm.doan.student.databinding.FragmentStudentDetailBinding;
import tkpm.doan.student.ui.components.utils.TabLayouts;
import tkpm.doan.student.ui.components.viewpager.FragmentPage;
import tkpm.doan.student.ui.student.NotificationFragment;
import tkpm.doan.student.ui.student.ProfileFragment;
import tkpm.doan.student.ui.student.ScheduleFragment;
import tkpm.doan.student.ui.student.ScoreFragment;

public class StudentDetailFragment extends Fragment {
    private FragmentStudentDetailBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentStudentDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

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
