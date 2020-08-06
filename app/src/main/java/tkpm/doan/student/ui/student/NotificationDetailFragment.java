package tkpm.doan.student.ui.student;

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
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import tkpm.doan.student.R;
import tkpm.doan.student.databinding.FragmentNotificationDetailBinding;

public class NotificationDetailFragment extends Fragment {
    private FragmentNotificationDetailBinding binding;
    private TextView title;
    private TextView content;
    private StudentViewModel viewModel;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        viewModel = new ViewModelProvider(requireActivity()).get(StudentViewModel.class);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentNotificationDetailBinding.inflate(inflater,container,false);
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
        binding.toolbar.setOnMenuItemClickListener(item -> {return  false;});
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupWithNavController(binding.toolbar, navController, appBarConfiguration);
        title= binding.notifyTitle;
        content=binding.notifyContent;
        viewModel.getSelectedNotify().observe(getViewLifecycleOwner(), notifications -> {
            title.setText(notifications.getTitle());
            content.setText(notifications.getContent());
        });
    }
}
