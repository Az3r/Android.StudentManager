package tkpm.doan.student.ui.components.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import java.util.List;

import tkpm.doan.student.R;
import tkpm.doan.student.data.models.Schedule;
import tkpm.doan.student.data.models.Session;
import tkpm.doan.student.data.models.Subject;
import tkpm.doan.student.databinding.ItemScheduleMasterBinding;
import tkpm.doan.student.ui.MainActivity;
import tkpm.doan.student.ui.student.ScheduleFragmentDirections;

public class ScheduleAdapter extends ImmutableAdapter<Schedule> {


    public ScheduleAdapter(@NonNull Context context, @NonNull List<Schedule> list) {
        super(context, list);
    }

    public class ViewHolder extends AbstractViewHolder<Schedule> {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void bind(Schedule item) {
            ItemScheduleMasterBinding binding = ItemScheduleMasterBinding.bind(itemView);
            TextView dateText = binding.scheduleDate;
            TextView subjectText = binding.scheduleSubjectList;

            // bind data to view
            dateText.setText(item.dateToString());
            List<Session> lessons = item.getLessons();
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < lessons.size(); j++) {
                builder.append(lessons.get(j).getSubjectName())
                        .append("\n");
            }
            subjectText.setText(builder.toString());

            // navigate to schedule detail
            itemView.setOnClickListener(v -> {

                MainActivity activity = (MainActivity) getContext();
                NavDirections directions = ScheduleFragmentDirections.navigateScheduleDetail();
                activity.getNavController().navigate(directions);
            });
        }
    }


    @NonNull
    @Override
    public AbstractViewHolder<Schedule> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_schedule_master, parent, false);
        return new ViewHolder(itemView);
    }

}
