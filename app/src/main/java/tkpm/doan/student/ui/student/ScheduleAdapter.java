package tkpm.doan.student.ui.student;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import tkpm.doan.student.R;
import tkpm.doan.student.data.models.Schedule;
import tkpm.doan.student.data.models.Subject;

public final class ScheduleAdapter extends BaseAdapter {
    private final ArrayList<Schedule> scheduleList = new ArrayList<>();
    private final Context context;

    public ScheduleAdapter(Context context, Collection<Schedule> collection) {
        this.context = context;
        scheduleList.addAll(collection);
    }

    @Override
    public int getCount() {
        return scheduleList.size();
    }

    @Override
    public Object getItem(int i) {
        return scheduleList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return scheduleList.get(i).hashCode();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_schedule_master, viewGroup, false);
        }

//        Schedule item = (Schedule) getItem(i);
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
