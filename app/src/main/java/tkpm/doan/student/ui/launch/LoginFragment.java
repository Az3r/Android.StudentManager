package tkpm.doan.student.ui.launch;

import android.os.Bundle;
import android.os.Handler;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import tkpm.doan.student.R;
import tkpm.doan.student.databinding.FragmentLoginBinding;
import tkpm.doan.student.ui.MainActivity;

public class LoginFragment extends Fragment {
    private TextInputLayout accountInput;
    private TextInputLayout passwordInput;
    private CheckBox teacherCheckBox;
    private Button loginButton;
    private ProgressBar progressBar;

    private FragmentLoginBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        accountInput = binding.loginAccount;
        passwordInput = binding.loginPassword;
        teacherCheckBox = binding.loginTeacher;
        progressBar = binding.progressbar;
        loginButton = binding.buttonLogin;
        loginButton.setOnClickListener(e -> onLogin());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void onLogin() {

        accountInput.setError(null);
        passwordInput.setError(null);

        if (hasEmptyField()) {
            setErrorIfEmpty(accountInput, getString(R.string.error_empty_field));
            setErrorIfEmpty(passwordInput, getString(R.string.error_empty_field));
            return;
        }

        enableAllInput(false);
        progressBar.setVisibility(View.VISIBLE);


        String account = getString(accountInput);
        String password = getString(passwordInput);
        boolean isTeacher = teacherCheckBox.isChecked();

        new Handler().postDelayed(() -> {

            Toast.makeText(getContext(), R.string.msg_login_success, Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(() -> {
                NavDirections directions = LoginFragmentDirections.navgiateStudent();
                ((MainActivity) requireActivity()).getNavController().navigate(directions);
            }, 500);
        }, 1000);
    }


    @Override
    public void onResume() {
        super.onResume();

        MainActivity activity = (MainActivity) requireActivity();
        activity.getDrawerLayout().setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        activity.getSupportActionBar().hide();
    }

    @Override
    public void onStop() {
        super.onStop();
        MainActivity activity = (MainActivity) requireActivity();
        activity.getDrawerLayout().setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        activity.getSupportActionBar().show();
    }

    private boolean hasEmptyField() {
        return getString(accountInput).isEmpty() || getString(passwordInput).isEmpty();
    }

    private void enableAllInput(boolean enabled) {
        accountInput.setEnabled(enabled);
        passwordInput.setEnabled(enabled);
        teacherCheckBox.setEnabled(enabled);
        loginButton.setEnabled(enabled);
    }

    private static void setErrorIfEmpty(TextInputLayout inputLayout, String error) {
        if (getString(inputLayout).isEmpty())
            inputLayout.setError(error);
    }

    private static String getString(TextInputLayout inputLayout) {
        return Objects.requireNonNull(inputLayout.getEditText()).getText().toString();
    }

}
