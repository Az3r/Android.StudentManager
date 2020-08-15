package tkpm.doan.student.ui.teacher;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;

import tkpm.doan.student.R;
import tkpm.doan.student.data.LoggedUserResource;
import tkpm.doan.student.databinding.FragmentProfileBinding;
import tkpm.doan.student.ui.MainActivity;
import tkpm.doan.student.ui.launch.LoggedUserViewModel;

public class StudentProfileFragment extends Fragment {
    private FragmentProfileBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupCommentSection();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        setHasOptionsMenu(true);
    }

    private void setupCommentSection() {

        LoggedUserViewModel viewModel = new ViewModelProvider(requireActivity()).get(LoggedUserViewModel.class);
        viewModel.isHomeTeacher().observe(getViewLifecycleOwner(), isHomeTeacher -> {
            binding.teacherComment.setVisibility(isHomeTeacher ? View.VISIBLE : View.GONE);
        });

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

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.action_grade, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.nav_score_editor) {
            MainActivity activity = (MainActivity) requireActivity();
            NavDirections directions = StudentProfileFragmentDirections.navgiateScoreEditor();
            activity.getNavController().navigate(directions);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
