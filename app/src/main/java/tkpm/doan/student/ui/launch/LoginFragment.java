package tkpm.doan.student.ui.launch;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import tkpm.doan.student.R;
import tkpm.doan.student.data.models.RequestLogIn;
import tkpm.doan.student.databinding.FragmentLoginBinding;
import tkpm.doan.student.ui.MainActivity;
import tkpm.doan.student.ui.components.constants.AppData;
import tkpm.doan.student.ui.components.constants.Keys;

public class LoginFragment extends Fragment {
    private TextInputLayout accountInput;
    private TextInputLayout passwordInput;
    private CheckBox teacherCheckBox;
    private Button loginButton;
    private ProgressBar progressBar;
    private FragmentLoginBinding binding;
    private LoggedUserViewModel viewModel;

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
        progressBar = binding.progressbar;
        loginButton = binding.buttonLogin;
        loginButton.setOnClickListener(e -> onLogin());
    }
    public static void hideKeyboard(Activity activity) {
        if (activity != null && activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
            InputMethodManager imm = (InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
        }
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        viewModel = new ViewModelProvider(requireActivity()).get(LoggedUserViewModel.class);
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
        }else {
            progressBar.setVisibility(View.VISIBLE);
            enableAllInput(false);
            String account = getString(accountInput);
            String password = getString(passwordInput);
            RequestLogIn requestLogIn= new RequestLogIn();
            requestLogIn.setPersonalInfoId(account);
            requestLogIn.setPassword(password);
            viewModel.PostLogIn(requestLogIn).observe(getViewLifecycleOwner(), responLogIn -> {
                if(responLogIn!=null)
                {
                    try {
                        if(responLogIn.getPersonalInfo().getPersonTypeId()==3)
                        {
                            AppData.getInstance().userName= account;
                            AppData.getInstance().IS_TEACHER =true;
                            AppData.getInstance().token="Bear "+responLogIn.getToken();
                            AppData.getInstance().TEACHER_ID=responLogIn.getPersonalInfo().getPersonalInfoId();
                            new Handler().postDelayed(() -> {
                                Toast.makeText(getContext(), R.string.msg_login_success, Toast.LENGTH_SHORT).show();
                                new Handler().postDelayed(this::navigateManagerSession, 500);
                            }, 1000);
                        }
                        else if(responLogIn.getPersonalInfo().getPersonTypeID()==1)
                        {
                            AppData.getInstance().userName= account;
                            AppData.getInstance().IS_TEACHER =false;
                            AppData.getInstance().token="Bear "+responLogIn.getToken();
                            AppData.getInstance().STUDENT_ID=responLogIn.getPersonalInfo().getPersonalInfoId();
                            new Handler().postDelayed(() -> {
                                Toast.makeText(getContext(), R.string.msg_login_success, Toast.LENGTH_SHORT).show();
                                new Handler().postDelayed(this::setupStudentSession, 500);
                            }, 1000);
                        }
                        else
                        {
                            AppData.getInstance().userName= account;
                            AppData.getInstance().IS_TEACHER =true;
                            AppData.getInstance().token="Bear "+responLogIn.getToken();
                            AppData.getInstance().TEACHER_ID=responLogIn.getPersonalInfo().getPersonalInfoId();
                            new Handler().postDelayed(() -> {
                                Toast.makeText(getContext(), R.string.msg_login_success, Toast.LENGTH_SHORT).show();
                                new Handler().postDelayed(this::setupTeacherSession, 500);
                            }, 1000);
                        }
                    } catch (Exception ex)
                    {

                    }
                   }
                else
                {
                    progressBar.setVisibility(View.GONE);
                    enableAllInput(true);
                    Toast.makeText(getContext(), R.string.msg_login_unsuccessful, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        MainActivity activity = (MainActivity) requireActivity();
        activity.getDrawerLayout().setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        activity.getSupportActionBar().hide();
        // hide botton nav when user sign out
        activity.getBottomNav().setVisibility(View.GONE);
    }

    @Override
    public void onStop() {
        super.onStop();
        MainActivity activity = (MainActivity) requireActivity();
        activity.getDrawerLayout().setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
         activity.getSupportActionBar().show();
    }


    private void setupStudentSession() {
        MainActivity activity = (MainActivity) requireActivity();
        activity.setupBottomNav(R.menu.nav_student);
        NavDirections directions = LoginFragmentDirections.navgiateStudent();
        ((MainActivity) requireActivity()).getNavController().navigate(directions);
    }
    private void setupTeacherSession() {
        MainActivity activity = (MainActivity) requireActivity();
        activity.getBottomNav().setVisibility(View.VISIBLE);
        activity.getBottomNav().getMenu().clear();
        activity.getBottomNav().inflateMenu(R.menu.nav_teacher);
        viewModel.isHomeTeacher().observe(getViewLifecycleOwner(), isHomeTeacher -> {
            Menu menu = activity.getBottomNav().getMenu();
            menu.findItem(R.id.nav_teacher_report).setVisible(isHomeTeacher);
        });
        NavDirections directions = LoginFragmentDirections.navgiateTeacher();
        ((MainActivity) requireActivity()).getNavController().navigate(directions);
    }
    private void navigateManagerSession() {
        MainActivity activity = (MainActivity) requireActivity();
        activity.setupBottomNav(R.menu.nav_manager);
        NavDirections directions = LoginFragmentDirections.navgiateManager();
        ((MainActivity) requireActivity()).getNavController().navigate(directions);
    }

    private boolean hasEmptyField() {
        return getString(accountInput).isEmpty() || getString(passwordInput).isEmpty();
    }

    private void enableAllInput(boolean enabled) {
        accountInput.setEnabled(enabled);
        passwordInput.setEnabled(enabled);
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
