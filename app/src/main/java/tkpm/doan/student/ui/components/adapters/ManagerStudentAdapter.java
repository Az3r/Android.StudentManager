package tkpm.doan.student.ui.components.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;

import java.util.List;

import tkpm.doan.student.R;
import tkpm.doan.student.data.models.Student;
import tkpm.doan.student.databinding.ItemStudentMasterBinding;
import tkpm.doan.student.ui.MainActivity;
import tkpm.doan.student.ui.manager.SearchStudentFragmentDirections;

public class ManagerStudentAdapter  extends ImmutableAdapter<Student> {

    private class ViewHolder extends AbstractViewHolder<Student> {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void bind(Student item) {
            ItemStudentMasterBinding binding = ItemStudentMasterBinding.bind(itemView);
            binding.studentSelected.setVisibility(View.GONE);

            itemView.setOnClickListener(v -> {

                // TODO set selected student in ManagerViewModel

                MainActivity activity = (MainActivity) getContext();
                NavDirections directions = SearchStudentFragmentDirections.navigateAddStudent();
                activity.getNavController().navigate(directions);
            });

            // TODO update view

        }
    }

    public ManagerStudentAdapter(@NonNull Context context, @NonNull List<Student> list) {
        super(context, list);
    }

    @NonNull
    @Override
    public AbstractViewHolder<Student> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student_master, parent, false);
        return new ViewHolder(itemView);
    }
}
