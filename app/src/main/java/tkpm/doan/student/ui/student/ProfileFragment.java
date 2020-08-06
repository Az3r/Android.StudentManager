package tkpm.doan.student.ui.student;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import tkpm.doan.student.R;
import tkpm.doan.student.data.LoggedUser;
import tkpm.doan.student.data.models.Comment;
import tkpm.doan.student.databinding.FragmentStudentProfileBinding;
import tkpm.doan.student.ui.MainActivity;
import tkpm.doan.student.ui.components.adapters.CommentAdapter;
import tkpm.doan.student.ui.components.constants.Provider;
import tkpm.doan.student.ui.components.utils.RecyclerViews;

@AndroidEntryPoint
public class ProfileFragment extends Fragment {

    private static final String TAG = ProfileFragment.class.getName();

    @Inject
    public List<Comment> comments;
    private StudentViewModel viewModel;
    private FragmentStudentProfileBinding binding;
    TextView studentId;
    TextView studentName;
    TextView studentClass;
    TextView studentGender;
    TextView studentBirthday;
    TextView studentAddress;
    TextView studentPhone;
    TextView studentEmail;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        viewModel = new ViewModelProvider(requireActivity()).get(StudentViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentStudentProfileBinding.inflate(inflater, container, false);
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
        studentId = binding.studentId;
        studentName = binding.studentName;
        studentClass = binding.studentClass;
        studentGender = binding.studentGender;
        studentBirthday = binding.studentBirthday;
        studentAddress = binding.studentAddress;
        studentPhone = binding.studentPhone;
        studentEmail = binding.studentEmail;
        setupRecyclerView(binding.recyclerView);
        setupViewModel();
    }

    @Override
    public void onResume() {
        super.onResume();
        MainActivity activity = (MainActivity) requireActivity();
        activity.getBottomNav().setVisibility(View.GONE);
    }

    @Override
    public void onStop() {
        super.onStop();
        MainActivity activity = (MainActivity) requireActivity();
        activity.getBottomNav().setVisibility(View.VISIBLE);
    }

    @SuppressLint("SetTextI18n")
    private void setupRecyclerView(RecyclerView recyclerView) {

        RecyclerViews.setupListView(recyclerView);

        CommentAdapter adapter = new CommentAdapter(requireContext(), comments);
        recyclerView.setAdapter(adapter);
    }

    private void setupViewModel() {
        viewModel.getPersonalInfo().observe(getViewLifecycleOwner(), personalInfo -> {
            studentId.setText(personalInfo.getStudentId());

            String fullname = getContext().getResources().getString(R.string.format_full_name, personalInfo.getLastName(), personalInfo.getMiddleName(), personalInfo.getFirstName());
            studentName.setText(fullname);
            studentClass.setText(personalInfo.getClassId());
            studentGender.setText(getString(personalInfo.getIsMale() ? R.string.male : R.string.female));
            studentBirthday.setText(Provider.getDateFormat().format(personalInfo.getBirthday()));
            studentAddress.setText(personalInfo.getAddress());
            studentPhone.setText(personalInfo.getPhoneNumber());
            studentEmail.setText(personalInfo.getEmail());
        });
    }
}
