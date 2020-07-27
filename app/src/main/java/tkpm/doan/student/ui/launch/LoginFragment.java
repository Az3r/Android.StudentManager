package tkpm.doan.student.ui.launch;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import tkpm.doan.student.R;

public class LoginFragment extends Fragment {
    private TextInputLayout accountInput;
    private TextInputLayout passwordInput;
    private CheckBox teacherCheckBox;
    private Button loginButton;
    private ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        accountInput = view.findViewById(R.id.login_account);
        passwordInput = view.findViewById(R.id.login_password);
        teacherCheckBox = view.findViewById(R.id.login_teacher);
        progressBar = view.findViewById(R.id.progressbar);
        loginButton = view.findViewById(R.id.button_login);
        loginButton.setOnClickListener(e -> onLogin());
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
            Toast.makeText(getContext(), R.string.info_login_success, Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(() -> {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host);
                navController.navigate(R.id.action_loginFragment_to_studentFragment);
            }, 500);

        }, 1000);



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
