package tkpm.doan.student.ui.components.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import java.util.List;

import tkpm.doan.student.R;
import tkpm.doan.student.data.models.TeacherSchedule;

public class TeacherScheduleAdapter extends ImmutableAdapter<TeacherSchedule> {

    private class ViewHolder extends AbstractViewHolder<TeacherSchedule> {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void bind(TeacherSchedule item) {

        }
    }

    public TeacherScheduleAdapter(@NonNull Context context, @NonNull List<TeacherSchedule> list) {
        super(context, list);
    }

    @NonNull
    @Override
    public AbstractViewHolder<TeacherSchedule> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_schedule_master, parent, false);
        return new ViewHolder(itemView);
    }
}
