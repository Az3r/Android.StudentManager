package tkpm.doan.student.ui.manager;

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
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import tkpm.doan.student.R;
import tkpm.doan.student.databinding.FragmentGradeDetailBinding;
import tkpm.doan.student.ui.MainActivity;
import tkpm.doan.student.ui.components.adapters.StudentAdapter;
import tkpm.doan.student.ui.components.adapters.StudentApdaterManager;
import tkpm.doan.student.ui.components.adapters.StudentClassManagerApdapter;
import tkpm.doan.student.ui.components.constants.AppData;
import tkpm.doan.student.ui.components.utils.RecyclerViews;
import tkpm.doan.student.ui.teacher.TeacherViewModel;

public class GradeDetailFragment extends Fragment {

    private FragmentGradeDetailBinding binding;
    private ManagerViewModel viewModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentGradeDetailBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        setHasOptionsMenu(true);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider((MainActivity) getContext()).get(ManagerViewModel.class);
        viewModel.getSelectedGrade().observe(getViewLifecycleOwner(),className -> {
            binding.ClassId.setText(className.getClassId());
            binding.NumberStudent.setText(""+className.getSumStudent());
            binding.TeacherClass.setText(className.getLastName()+" "+className.getMiddleName()+" "+ className.getFirstName());
        });
        setupRecyclerView(binding.recyclerView);
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        RecyclerViews.setupListView(recyclerView);
        viewModel.getSelectedGrade().observe(getViewLifecycleOwner(),className -> {
                viewModel.GetAllStudentClass(className.getClassId(), AppData.getInstance().sem,AppData.getInstance().year).observe(getViewLifecycleOwner(), studentList -> {
                StudentClassManagerApdapter adapter = new StudentClassManagerApdapter(requireActivity(), studentList);
                recyclerView.swapAdapter(adapter, true);
            });
        });
    }
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.action_schedule, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menu_schedule) {
            NavDirections directions = GradeDetailFragmentDirections.navigateSchedule();
            Navigation.findNavController(binding.getRoot()).navigate(directions);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
