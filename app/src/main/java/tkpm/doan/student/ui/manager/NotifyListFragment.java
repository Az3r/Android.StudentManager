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
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.recyclerview.widget.RecyclerView;

import tkpm.doan.student.R;
import tkpm.doan.student.databinding.FragmentNotificationListBinding;
import tkpm.doan.student.ui.MainActivity;
import tkpm.doan.student.ui.components.adapters.ManagerNotifyAdapter;
import tkpm.doan.student.ui.components.adapters.NotificationAdapter;
import tkpm.doan.student.ui.components.adapters.NotifyAdapterManager;
import tkpm.doan.student.ui.components.utils.RecyclerViews;

public class NotifyListFragment extends Fragment {

    private FragmentNotificationListBinding binding;
    private ManagerViewModel viewModel;
    NotifyAdapterManager adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentNotificationListBinding.inflate(inflater, container, false);
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
        viewModel =  new ViewModelProvider(requireActivity()).get(ManagerViewModel.class);
        binding.fab.setOnClickListener(v -> {
            viewModel.setSelectedNotify(null);
            NavDirections directions = NotifyListFragmentDirections.navigateCreateNotify();
            MainActivity activity = (MainActivity) requireActivity();
            activity.getNavController().navigate(directions);
        });
        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                adapter.filter(s);
                // TODO search and display result
                return true;
            }
        });
        setupRecyclerView(binding.recyclerView);
    }
    private void setupRecyclerView(RecyclerView recyclerView) {
        RecyclerViews.setupListView(recyclerView);
        viewModel.getAllNotify().observe(getViewLifecycleOwner(), notifications -> {
            adapter  = new NotifyAdapterManager(requireActivity(), notifications);
            recyclerView.swapAdapter(adapter, true);
        });



    }
}
