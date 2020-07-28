package tkpm.doan.student.ui.student;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import java.util.List;

import tkpm.doan.student.R;
import tkpm.doan.student.data.models.Schedule;
import tkpm.doan.student.ui.MainActivity;
import tkpm.doan.student.ui.components.ImmutableAdapter;

public final class ScheduleAdapter extends ImmutableAdapter<Schedule> {

    public ScheduleAdapter(@NonNull Context context, int layoutResource, @NonNull List<Schedule> list) {
        super(context, layoutResource, list);
    }

    @Override
    protected void bind(@NonNull View view, @NonNull Schedule item) {

        view.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController((MainActivity) context, R.id.nav_host);
            navController.navigate(R.id.action_studentFragment_to_scheduleDetailFragment);
        });

        /*
        TextView dateText = view.findViewById(R.id.schedule_date);
        TextView subjectText = view.findViewById(R.id.schedule_subject_list);
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
         */
    }
}
