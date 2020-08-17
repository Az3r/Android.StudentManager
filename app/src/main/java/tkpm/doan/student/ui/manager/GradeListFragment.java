package tkpm.doan.student.ui.manager;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import tkpm.doan.student.R;
import tkpm.doan.student.data.models.ClassName;
import tkpm.doan.student.databinding.FragmentGradeListBinding;
import tkpm.doan.student.databinding.FragmentSearchTeacherBinding;
import tkpm.doan.student.ui.MainActivity;
import tkpm.doan.student.ui.components.adapters.GradeAdapter;
import tkpm.doan.student.ui.components.adapters.GradeManagerAdapter;
import tkpm.doan.student.ui.components.adapters.TeacherAdapter;
import tkpm.doan.student.ui.components.constants.AppData;
import tkpm.doan.student.ui.components.constants.Keys;
import tkpm.doan.student.ui.components.utils.RecyclerViews;

public class GradeListFragment extends Fragment {
    private FragmentGradeListBinding binding;
    ManagerViewModel viewModel;
    GradeManagerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentGradeListBinding.inflate(inflater, container, false);
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
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(ManagerViewModel.class);
        binding.fab.setOnClickListener(v -> {
            // TODO in viewmodel set selected teacher to empty or null
            viewModel.setSelectedTeacher(null);
            MainActivity activity = (MainActivity) requireActivity();
            NavDirections directions = GradeListFragmentDirections.navgiateAddClass();
            activity.getNavController().navigate(directions);
        });
        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
//                adapter.filter(s);
                // TODO search and display result
                return true;
            }
        });
        setupRecyclerView(binding.recyclerView);
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        RecyclerViews.setupListView(recyclerView);
        viewModel.GetAllClass(AppData.getInstance().year).observe(getViewLifecycleOwner(), teacherList -> {
            List<ClassName> data= new ArrayList<>();
            for(int i=0;i<teacherList.size();i++)
            {
                if(!teacherList.get(i).getClassId().equals("FULL"))
                {
                    data.add(teacherList.get(i));
                }
            }
            adapter= new GradeManagerAdapter(requireActivity(), data);
            recyclerView.swapAdapter(adapter, true);
        });
    }
}