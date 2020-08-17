package tkpm.doan.student.ui.setting;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import tkpm.doan.student.R;
import tkpm.doan.student.data.models.RequestPassword;
import tkpm.doan.student.databinding.FragmentSettingBinding;
import tkpm.doan.student.ui.components.constants.AppData;
import tkpm.doan.student.ui.launch.LoggedUserViewModel;
import tkpm.doan.student.ui.teacher.TeacherViewModel;

public class SettingFragment extends Fragment {
    private FragmentSettingBinding binding;
    private LoggedUserViewModel viewModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSettingBinding.inflate(inflater, container, false);
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
        viewModel = new ViewModelProvider(requireActivity()).get(LoggedUserViewModel.class);
        binding.buttonUpdate.setOnClickListener(v -> {
            String old = getString(binding.layoutOldPass);
            String replace = getString(binding.layoutNewPass);
            String confirm = getString(binding.layoutConfirmPass);
            if (old.isEmpty() || replace.isEmpty() || confirm.isEmpty()) {
                setErrorIfEmpty(binding.layoutOldPass, getString(R.string.error_empty_field));
                setErrorIfEmpty(binding.layoutNewPass, getString(R.string.error_empty_field));
                setErrorIfEmpty(binding.layoutConfirmPass, getString(R.string.error_empty_field));
                return;
            }
            boolean isMatched = replace.equals(confirm);
            boolean isAccountPassword = old.equals(getAccountPassword());
            if (!isAccountPassword) {
                binding.layoutOldPass.setError(getString(R.string.msg_incorrect_password));
            } else if (!isMatched) {
                binding.confirmPass.setError(getString(R.string.msg_incorrect_confirm_password));
            } else {
                RequestPassword requestPassword= new RequestPassword();
                requestPassword.setPassword(binding.newPass.getText().toString());
                viewModel.UpdatePassword(AppData.getInstance().token,requestPassword).observe(getViewLifecycleOwner(),responLogIn -> {
                    if(responLogIn!=null)
                    {
                        showAlert(getString(R.string.change_pass_success));
                    }
                    else {
                        showAlert(getString(R.string.change_pass_unsuccess));
                    }
                });
            }
        });
    }
    public void showAlert(String value) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(value);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    private String getAccountPassword() {
        return AppData.getInstance().userName;
    }

    private static void setErrorIfEmpty(TextInputLayout inputLayout, String error) {
        if (getString(inputLayout).isEmpty())
            inputLayout.setError(error);
    }

    private static String getString(TextInputLayout inputLayout) {
        return Objects.requireNonNull(inputLayout.getEditText()).getText().toString();
    }
}
