package tkpm.doan.student.ui.manager;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Arrays;

import tkpm.doan.student.R;
import tkpm.doan.student.databinding.FragmentAddStudentBinding;
import tkpm.doan.student.databinding.FragmentAddTeacherBinding;
import tkpm.doan.student.ui.MainActivity;

public class AddTeacherFragment extends Fragment {
    private FragmentAddTeacherBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAddTeacherBinding.inflate(inflater, container, false);
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
        inflater.inflate(R.menu.action_edit, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireActivity(), R.layout.textview, R.id.textview, Arrays.asList(
                "Math", "Literature", "English",
                "Physics", "Chemistry", "Biology",
                "Hitroy", "Geography", "Moral"
        ));

        binding.teacherClass.setAdapter(adapter);

        binding.buttonAddImage.setOnClickListener(v -> {
            // TODO select an image from gallery
        });
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_submit:
                // TODO check if no field is empty
                // TODO check field format
                // TODO submit to database

                MainActivity mainActivity = (MainActivity) requireActivity();
                mainActivity.getNavController().navigateUp();
                return true;

            case R.id.menu_restore:
                binding.teacherFullName.getText().clear();
                binding.teacherGender.getText().clear();
                binding.teacherClass.getText().clear();
                binding.teacherBirthday.getText().clear();
                binding.teacherAddress.getText().clear();
                binding.teacherEmail.getText().clear();
                binding.teacherPhone.getText().clear();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
