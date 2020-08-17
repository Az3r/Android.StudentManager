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
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import tkpm.doan.student.R;
import tkpm.doan.student.databinding.FragmentScheduleDetailBinding;
import tkpm.doan.student.ui.MainActivity;
import tkpm.doan.student.ui.components.utils.RecyclerViews;
import tkpm.doan.student.ui.teacher.ScheduleDetailFragmentDirections;

public class ScheduleDetailFragment extends Fragment {
    private FragmentScheduleDetailBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentScheduleDetailBinding.inflate(inflater, container, false);
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

        setupRecyclerView(binding.recyclerView);
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        RecyclerViews.setupListView(recyclerView);

        // TODO
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.action_grade, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        // TODO set selected schedule of selected class

        NavDirections directions = ScheduleDetailFragmentDirections.navgiateEditSchedule();
        Navigation.findNavController(binding.getRoot()).navigate(directions);
        return true;
    }
}
