package tkpm.doan.student.ui.components.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import java.util.List;

import tkpm.doan.student.R;
import tkpm.doan.student.data.models.Lesson;
import tkpm.doan.student.data.models.Schedule;
import tkpm.doan.student.data.models.Subject;
import tkpm.doan.student.ui.MainActivity;

public final class ScheduleAdapter extends ImmutableAdapter<Schedule> {

    public static class ViewHolder extends AbstractViewHolder<Schedule> {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void bind(Schedule item) {
            TextView dateText = itemView.findViewById(R.id.schedule_date);
            TextView subjectText = itemView.findViewById(R.id.schedule_subject_list);
            dateText.setText(item.dateToString());

            List<Lesson> lessons = item.getLessons();
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < lessons.size() - 1; j++) {
                Subject subject = lessons.get(j).getSubject();
                builder.append(subject.getName())
                        .append(", ");
            }
            Subject lastItem = lessons.get(lessons.size() - 1).getSubject();
            builder.append(lastItem.getName());
            subjectText.setText(builder.toString());
        }
    }

    public ScheduleAdapter(@NonNull Context context, @NonNull List<Schedule> list) {
        super(context, list);
    }

    @NonNull
    @Override
    public AbstractViewHolder<Schedule> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_schedule_master, parent, false);
        return new ViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull AbstractViewHolder<Schedule> holder, int position) {

        holder.itemView.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController((MainActivity) getContext(), R.id.nav_host);
            navController.navigate(R.id.action_studentFragment_to_scheduleDetailFragment);
        });

        holder.bind(getItem(position));
    }
}
