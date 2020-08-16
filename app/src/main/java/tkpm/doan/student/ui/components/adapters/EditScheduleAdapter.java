package tkpm.doan.student.ui.components.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import java.util.List;

import tkpm.doan.student.R;
import tkpm.doan.student.data.models.Schedule;

public class EditScheduleAdapter extends ImmutableAdapter<Schedule> {

    private class ViewHolder extends AbstractViewHolder<Schedule> {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void bind(Schedule item) {

        }
    }

    public EditScheduleAdapter(@NonNull Context context, @NonNull List<Schedule> list) {
        super(context, list);
    }

    @NonNull
    @Override
    public AbstractViewHolder<Schedule> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_edit_schedule, parent, false);
        return new ViewHolder(itemView);
    }
}
