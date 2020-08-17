package tkpm.doan.student.ui.components.adapters;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;

import java.util.List;

import tkpm.doan.student.R;
import tkpm.doan.student.data.models.Schedule;
import tkpm.doan.student.data.models.Session;
import tkpm.doan.student.databinding.ItemScheduleMasterBinding;
import tkpm.doan.student.ui.MainActivity;
import tkpm.doan.student.ui.manager.ManagerViewModel;
import tkpm.doan.student.ui.manager.ScheduleFragment;
import tkpm.doan.student.ui.manager.ScheduleFragmentDirections;
import tkpm.doan.student.ui.student.StudentViewModel;
public class ScheduleManagerAdapter extends ImmutableAdapter<Schedule> {
    private ManagerViewModel viewModel;
    public class ViewHolder extends AbstractViewHolder<Schedule> {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public void bind(Schedule item) {
            ItemScheduleMasterBinding binding = ItemScheduleMasterBinding.bind(itemView);
            viewModel =new ViewModelProvider((MainActivity) getContext()).get(ManagerViewModel.class);
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
                viewModel.setDaySchedule(item.getDateOfWeek().getValue()+1);
                MainActivity activity = (MainActivity) getContext();
                NavDirections directions = ScheduleFragmentDirections.actionNavManagerScheduleToNavCreateSchedule();
                activity.getNavController().navigate(directions);
            });
        }
    }

    public ScheduleManagerAdapter(@NonNull Context context, @NonNull List<Schedule> list) {
        super(context, list);
    }
    @NonNull
    @Override
    public AbstractViewHolder<Schedule> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_schedule_master, parent, false);
        return new ScheduleManagerAdapter.ViewHolder(itemView);
    }

}