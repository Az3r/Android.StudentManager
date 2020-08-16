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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.fab.setOnClickListener(v -> {
            MainActivity activity = (MainActivity) requireActivity();

            NavDirections directions = SearchStudentFragmentDirections.navigateAddStudent();
            activity.getNavController().navigate(directions);
        });

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
}
