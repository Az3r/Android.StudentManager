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
import androidx.navigation.ui.NavigationUI;

import tkpm.doan.student.R;
import tkpm.doan.student.databinding.FragmentCreateNotifyBinding;
import tkpm.doan.student.ui.MainActivity;

public class EditNotifyFragment extends Fragment {
    private FragmentCreateNotifyBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCreateNotifyBinding.inflate(inflater, container, false);
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

        binding.buttonRestore.setOnClickListener(v -> {
            // TODO restore properties to its default value
        });

        binding.buttonSubmit.setOnClickListener(v -> {
            // TODO check no field is empty
            // TODO check field format
            // TODO save to database


            MainActivity mainActivity = (MainActivity) requireActivity();
            mainActivity.getNavController().navigateUp();
        });
    }
}
