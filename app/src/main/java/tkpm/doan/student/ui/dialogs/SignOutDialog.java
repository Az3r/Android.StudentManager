package tkpm.doan.student.ui.dialogs;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import tkpm.doan.student.R;
import tkpm.doan.student.ui.MainActivity;

public class SignOutDialog extends DialogFragment {


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        return new AlertDialog.Builder(requireContext())
                .setTitle("Proceed to sign out?")
                .setPositiveButton("Confirm", (dialogInterface, i) -> {
                    MainActivity activity = (MainActivity) requireActivity();
                    activity.getNavController().navigate(R.id.login);
                })
                .setNegativeButton("Cancel", (dialogInterface, i) -> dialogInterface.dismiss())
                .create();
    }

}
