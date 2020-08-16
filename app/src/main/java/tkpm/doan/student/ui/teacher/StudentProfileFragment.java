package tkpm.doan.student.ui.teacher;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;

import java.util.concurrent.atomic.AtomicBoolean;

import tkpm.doan.student.R;
import tkpm.doan.student.data.models.FeedBack;
import tkpm.doan.student.data.models.Student;
import tkpm.doan.student.databinding.FragmentProfileBinding;
import tkpm.doan.student.ui.MainActivity;
import tkpm.doan.student.ui.components.constants.Provider;
import tkpm.doan.student.ui.launch.LoggedUserViewModel;

public class StudentProfileFragment extends Fragment {
    private FragmentProfileBinding binding;
    private TeacherViewModel teacherViewModel;
    TextView studentId;
    TextView studentName;
    TextView studentClass;
    TextView studentGender;
    TextView studentBirthday;
    TextView studentAddress;
    TextView studentPhone;
    TextView studentEmail;
    Student personalInfo;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        studentId = binding.studentId;
        studentName = binding.studentName;
        studentClass = binding.studentClass;
        studentGender = binding.studentGender;
        studentBirthday = binding.studentBirthday;
        studentAddress = binding.studentAddress;
        studentPhone = binding.studentPhone;
        studentEmail = binding.studentEmail;
        setupCommentSection();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        setHasOptionsMenu(true);
    }

    private void setupCommentSection() {

        LoggedUserViewModel viewModel = new ViewModelProvider(requireActivity()).get(LoggedUserViewModel.class);
        teacherViewModel = new ViewModelProvider(requireActivity()).get(TeacherViewModel.class);
        teacherViewModel.getSelectedStudents().observe(getViewLifecycleOwner(), list->{
            personalInfo= list.get(0);
            studentId.setText(personalInfo.getStudentId());
            String fullname = requireContext()
                    .getResources()
                    .getString(R.string.format_full_name, personalInfo.getLastName(), personalInfo.getMiddleName(), personalInfo.getFirstName());
            studentName.setText(fullname);
            studentClass.setText(personalInfo.getClassId());
            studentGender.setText(getString(personalInfo.getIsMale() ? R.string.male : R.string.female));
            studentBirthday.setText(Provider.getDateFormat().format(personalInfo.getBirthday()));
            studentAddress.setText(personalInfo.getAddress());
            studentPhone.setText(personalInfo.getPhoneNumber());
        });
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
        binding.buttonSubmit.setOnClickListener(v -> {
            if(binding.commentInput.getText().toString().isEmpty())
            {
                Toast.makeText(getContext(),R.string.need_content_feedback, Toast.LENGTH_LONG);
            }
            else
            {
                AtomicBoolean IsFailure= new AtomicBoolean(true);
                FeedBack feedBack= new FeedBack();
                feedBack.setContent(binding.commentInput.getText().toString());
                feedBack.setSem(1);
                feedBack.setYear(2020);
                feedBack.setStudentID(personalInfo.getStudentId());
                teacherViewModel.PostFeedback(feedBack).observe(getViewLifecycleOwner(), responseBody -> {
                    IsFailure.set(true);
                });
                if(IsFailure.get())
                {
                    Toast.makeText(getContext(), R.string.add_feedback_success, Toast.LENGTH_SHORT).show();
                    binding.commentInput.getText().clear();
                    binding.commentInput.clearFocus();
                }
                else
                {
                    Toast.makeText(getContext(), R.string.add_feedback_fail, Toast.LENGTH_SHORT).show();
                }
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
