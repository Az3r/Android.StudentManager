package tkpm.doan.student.ui.components.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.appcompat.view.ActionMode;

import java.security.KeyStore;
import java.util.List;

import tkpm.doan.student.R;
import tkpm.doan.student.data.models.Student;
import tkpm.doan.student.databinding.ItemStudentMasterBinding;
import tkpm.doan.student.ui.MainActivity;

public class StudentAdapter extends ImmutableAdapter<Student> {

    private class ViewHolder extends AbstractViewHolder<Student> {

        private int selected = 0;
        private ActionMode mode;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void bind(Student item) {
            ItemStudentMasterBinding binding = ItemStudentMasterBinding.bind(itemView);
            binding.studentSelected.setOnCheckedChangeListener((compoundButton, b) -> {
                if (b) ++selected;
                else --selected;

                if (mode != null) mode.setTitle(String.format("%d selected", selected));
            });


            itemView.setOnLongClickListener(view -> {
                MainActivity activity = (MainActivity) getContext();
                mode = activity.startSupportActionMode(new ActionMode.Callback() {
                    @Override
                    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                        mode.getMenuInflater().inflate(R.menu.student_menu, menu);
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
                        ViewHolder.this.mode = null;
                    }
                });

                return true;
            });
        }
    }

    public StudentAdapter(@NonNull Context context, @NonNull List<Student> list) {
        super(context, list);
    }

    @NonNull
    @Override
    public AbstractViewHolder<Student> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student_master, parent, false);
        return new ViewHolder(itemView);
    }
}
