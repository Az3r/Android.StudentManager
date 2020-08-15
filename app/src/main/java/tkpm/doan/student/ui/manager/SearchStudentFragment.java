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
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;

import tkpm.doan.student.R;
import tkpm.doan.student.ui.MainActivity;
import tkpm.doan.student.databinding.FragmentSearchStudentBinding;

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

        MainActivity activity = (MainActivity) requireActivity();
        activity.getBottomNav().setVisibility(View.GONE);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.action_manager, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        MainActivity activity = (MainActivity) requireActivity();
        NavController navController = activity.getNavController();
        NavDirections directions = null;

        switch (item.getItemId()) {
            case R.id.nav_create_student:
                directions = SearchStudentFragmentDirections.navigateAddStudent();
                break;
            case R.id.nav_create_notification:
                directions = SearchStudentFragmentDirections.navigateCreateNotify();
        }

        if (directions != null) navController.navigate(directions);
        return super.onOptionsItemSelected(item);
    }
}
