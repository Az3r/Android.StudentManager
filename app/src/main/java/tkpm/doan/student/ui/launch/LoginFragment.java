package tkpm.doan.student.ui.launch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.material.textfield.TextInputLayout;

import tkpm.doan.student.R;

public class LoginFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextInputLayout account = view.findViewById(R.id.login_account);
        TextInputLayout password = view.findViewById(R.id.login_password);
        Button login = view.findViewById(R.id.button_login);
        login.setOnClickListener(e -> onLogin(
                account.getEditText().getText().toString(),
                password.getEditText().getText().toString())
        );
    }

    private void onLogin(String accounts, String password) {
        NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host);
        navController.navigate(R.id.action_loginFragment_to_studentFragment);
    }
}
