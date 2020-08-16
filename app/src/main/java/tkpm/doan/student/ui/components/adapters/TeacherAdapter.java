package tkpm.doan.student.ui.components.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;

import java.util.List;

import tkpm.doan.student.R;
import tkpm.doan.student.data.models.Teacher;
import tkpm.doan.student.ui.MainActivity;
import tkpm.doan.student.ui.manager.SearchTeacherFragmentDirections;

public class TeacherAdapter extends ImmutableAdapter<Teacher> {

    private class ViewHolder extends AbstractViewHolder<Teacher> {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void bind(Teacher item) {

            itemView.setOnClickListener(v -> {
                // TODO in viewmodel set selected teacher

                MainActivity activity = (MainActivity) getContext();
                NavDirections directions = SearchTeacherFragmentDirections.navigateTeacher();
                activity.getNavController().navigate(directions);
            });

            // TODO bind data to view
        }
    }

    public TeacherAdapter(@NonNull Context context, @NonNull List<Teacher> list) {
        super(context, list);
    }

    @NonNull
    @Override
    public AbstractViewHolder<Teacher> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_teacher_master, parent, false);
        return new ViewHolder(itemView);
    }
}
