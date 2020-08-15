package tkpm.doan.student.ui.launch;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import dagger.hilt.android.AndroidEntryPoint;
import tkpm.doan.student.R;
import tkpm.doan.student.databinding.FragmentProfileBinding;
import tkpm.doan.student.ui.MainActivity;
import tkpm.doan.student.ui.components.adapters.CommentAdapter;
import tkpm.doan.student.ui.components.constants.Provider;
import tkpm.doan.student.ui.components.utils.RecyclerViews;

@AndroidEntryPoint
public class ProfileFragment extends Fragment {

    private static final String TAG = ProfileFragment.class.getName();
    private LoggedUserViewModel viewModel;
    private FragmentProfileBinding binding;
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
        viewModel = new ViewModelProvider(requireActivity()).get(LoggedUserViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);
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

    private void setupRecyclerView(RecyclerView recyclerView) {
        RecyclerViews.setupListView(recyclerView);
        viewModel.getComments().observe(getViewLifecycleOwner(), comments -> {
            CommentAdapter adapter = new CommentAdapter(requireContext(), comments);
            recyclerView.swapAdapter(adapter, true);
        });
    }
    private void setupViewModel() {
        viewModel.getUserType().observe(getViewLifecycleOwner(), userTypes -> {
            switch (userTypes) {
                case TEACHER:
                    binding.commentSection.setVisibility(View.GONE);
                    break;
                case STUDENT:
                    binding.commentSection.setVisibility(View.VISIBLE);
            }
        });
        viewModel.getPersonalInfo().observe(getViewLifecycleOwner(), personalInfo -> {
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
            studentEmail.setText(personalInfo.getEmail());
        });
    }
}
