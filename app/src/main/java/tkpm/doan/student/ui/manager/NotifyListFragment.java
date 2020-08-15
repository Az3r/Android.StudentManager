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
import tkpm.doan.student.databinding.FragmentNotificationListBinding;
import tkpm.doan.student.ui.MainActivity;

public class NotifyListFragment extends Fragment {

    private FragmentNotificationListBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding  = FragmentNotificationListBinding.inflate(inflater, container, false);
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
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.action_manager, menu);
        menu.getItem(R.id.nav_create_student).setVisible(false);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // TODO setup recycler view
        // binding.recyclerView = ...
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        MainActivity activity = (MainActivity) requireActivity();
        NavController navController = activity.getNavController();

        if (item.getItemId() == R.id.nav_create_notification) {
            // TODO in view model set selected notification to null or create an empty instance

            NavDirections directions = NotifyListFragmentDirections.navigateCreateNotify();
            navController.navigate(directions);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
