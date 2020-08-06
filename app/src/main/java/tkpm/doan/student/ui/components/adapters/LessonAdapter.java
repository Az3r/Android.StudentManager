package tkpm.doan.student.ui.components.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

import tkpm.doan.student.R;
import tkpm.doan.student.data.models.Session;
import tkpm.doan.student.databinding.ItemScheduleDetailBinding;
import tkpm.doan.student.databinding.ItemScheduleMasterBinding;

public class LessonAdapter extends ImmutableAdapter<Session> {

    public static class ViewHolder extends AbstractViewHolder<Session> {
        TextView scheduleSubject;
        TextView scheduleDuration;
        TextView schedulePeriod;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void bind(Session item) {
            ItemScheduleDetailBinding binding = ItemScheduleDetailBinding.bind(itemView);
            scheduleSubject = binding.scheduleSubject;
            scheduleDuration = binding.scheduleDuration;
            schedulePeriod = binding.schedulePeriod;
            scheduleSubject.setText(item.getSubjectName());
            scheduleDuration.setText(item.getBeginTime()+" - "+ item.getEndTime());
            schedulePeriod.setText(""+item.getPeriod());
        }
    }

    public LessonAdapter(@NonNull Context context, @NonNull List<Session> list) {
        super(context, list);
    }

    @NonNull
    @Override
    public AbstractViewHolder<Session> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_schedule_detail, parent, false);
        return new ViewHolder(itemView);
    }
}
