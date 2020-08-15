package tkpm.doan.student.ui.manager;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Collections;
import java.util.List;

import tkpm.doan.student.R;
import tkpm.doan.student.data.models.Student;
import tkpm.doan.student.ui.MainActivity;
import tkpm.doan.student.databinding.FragmentSearchStudentBinding;
import tkpm.doan.student.ui.components.adapters.ManagerStudentAdapter;
import tkpm.doan.student.ui.components.adapters.StudentAdapter;

public class SearchStudentFragment extends Fragment {
    private FragmentSearchStudentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSearchStudentBinding.inflate(inflater, container, false);
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
    public void onResume() {
        super.onResume();

        MainActivity activity = (MainActivity) requireActivity();
        activity.getBottomNav().setVisibility(View.GONE);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.blockAll.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            binding.block10.setChecked(isChecked);
            binding.block11.setChecked(isChecked);
            binding.block12.setChecked(isChecked);
        });


        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                boolean include10 = binding.block10.isChecked();
                boolean include11 = binding.block11.isChecked();
                boolean include12 = binding.block12.isChecked();

                // TODO search and display result
                ManagerStudentAdapter adapter = new ManagerStudentAdapter(requireActivity(), Collections.emptyList());
                binding.recyclerView.swapAdapter(adapter, true);

                return true;
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.action_manager, menu);
        menu.getItem(R.id.nav_create_notification).setVisible(false);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        MainActivity activity = (MainActivity) requireActivity();
        NavController navController = activity.getNavController();

        if (item.getItemId() == R.id.nav_create_student) {
            NavDirections directions = SearchStudentFragmentDirections.navigateAddStudent();
            navController.navigate(directions);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
