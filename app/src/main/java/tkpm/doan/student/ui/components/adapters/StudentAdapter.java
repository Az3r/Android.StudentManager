package tkpm.doan.student.ui.components.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.appcompat.view.ActionMode;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import java.util.ArrayList;
import java.util.List;

import tkpm.doan.student.R;
import tkpm.doan.student.data.models.Student;
import tkpm.doan.student.databinding.ItemStudentMasterBinding;
import tkpm.doan.student.ui.MainActivity;
import tkpm.doan.student.ui.teacher.GradeDetailFragmentDirections;

public class StudentAdapter extends ImmutableAdapter<Student> implements ActionMode.Callback {

    private class ViewHolder extends AbstractViewHolder<Student> {

        private CheckBox checkBox;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void bind(Student item) {

            this.itemView.setTag(item);
            ItemStudentMasterBinding binding = ItemStudentMasterBinding.bind(itemView);
            checkBox = binding.studentSelected;

            binding.studentSelected.setOnCheckedChangeListener((compoundButton, isChecked) -> {

                if (isChecked && actionMode == null) {
                    MainActivity activity = (MainActivity) getContext();
                    actionMode = activity.startSupportActionMode(StudentAdapter.this);
                }

                if (actionMode != null) {

                    if (isChecked) selectedStudents.add(this);
                    else selectedStudents.remove(this);

                    String title = getContext().getResources().getString(R.string.format_selected, selectedStudents.size());
                    actionMode.setTitle(title);
                }
            });

            itemView.setOnClickListener(v -> {
                if (actionMode != null) {
                    boolean isChecked = binding.studentSelected.isChecked();
                    binding.studentSelected.setChecked(!isChecked);
                } else {
                    NavController navController = Navigation.findNavController((MainActivity) getContext(), R.id.nav_host);
                    NavDirections directions = GradeDetailFragmentDirections.actionGradeDetailFragmentToStudentDetailFragment();
                    navController.navigate(directions);
                }
            });
        }
        public void unselected() {
            checkBox.setChecked(false);
        }
    }

    private ActionMode actionMode;
    private ArrayList<ViewHolder> selectedStudents = new ArrayList<>();

    public StudentAdapter(@NonNull Context context, @NonNull List<Student> list) {
        super(context, list);
    }

    @NonNull
    @Override
    public AbstractViewHolder<Student> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student_master, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        return false;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {
        actionMode = null;

        // clear all selected students
        for (ViewHolder selectedStudent : selectedStudents) {
            selectedStudent.unselected();
        }
    }
}
