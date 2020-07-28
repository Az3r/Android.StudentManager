package tkpm.doan.student.ui.student;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import tkpm.doan.student.R;
import tkpm.doan.student.data.models.Schedule;
import tkpm.doan.student.data.models.Subject;
import tkpm.doan.student.ui.MainActivity;

public final class ScheduleAdapter extends BaseAdapter {
    private final ArrayList<Schedule> schedules = new ArrayList<>();
    private final Context context;

    public ScheduleAdapter(Context context) {
        this.context = context;
    }

    @Inject
    public ScheduleAdapter(Context context, Collection<Schedule> schedules) {
        this.context = context;
        this.schedules.addAll(schedules);
    }

    @Override
    public int getCount() {
        return schedules.size();
    }

    @Override
    public Object getItem(int i) {
        return schedules.get(i);
    }

    @Override
    public long getItemId(int i) {
        return schedules.get(i).hashCode();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_schedule_master, viewGroup, false);
        }

        Schedule item = (Schedule) getItem(i);

        view.setOnClickListener(view1 -> {
            NavController navController = Navigation.findNavController((MainActivity) context, R.id.nav_host);
            navController.navigate(R.id.action_studentFragment_to_scheduleDetailFragment);
        });
//        bind(view, item);

        return view;
    }

    /**
     * bind data to view
     */
    private void bind(View view, Schedule item) {
        TextView dateText = view.findViewById(R.id.schedule_date);
        TextView subjectText = view.findViewById(R.id.schedule_subject_list);
        dateText.setText(item.dateToString());

        List<Subject> subjects = item.getSubjects();
        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < subjects.size() - 1; j++) {
            Subject subject = subjects.get(j);
            builder.append(subject.getName())
                    .append(", ");
        }
        Subject lastItem = subjects.get(subjects.size() - 1);
        builder.append(lastItem.getName());
        subjectText.setText(builder.toString());
    }
}
