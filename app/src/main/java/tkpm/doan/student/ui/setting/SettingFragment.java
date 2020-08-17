package tkpm.doan.student.ui.setting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import tkpm.doan.student.R;
import tkpm.doan.student.databinding.FragmentSettingBinding;

public class SettingFragment extends Fragment {
    private FragmentSettingBinding binding;

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
                // TODO update password in database
            }
        });
    }

    /**
     * get the password of this account
     */
    private String getAccountPassword() {
        // TODO get account password
        return null;
    }

    private static void setErrorIfEmpty(TextInputLayout inputLayout, String error) {
        if (getString(inputLayout).isEmpty())
            inputLayout.setError(error);
    }

    private static String getString(TextInputLayout inputLayout) {
        return Objects.requireNonNull(inputLayout.getEditText()).getText().toString();
    }
}
