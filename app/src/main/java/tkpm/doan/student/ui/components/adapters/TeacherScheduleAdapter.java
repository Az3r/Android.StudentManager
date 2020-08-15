package tkpm.doan.student.ui.components.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;

import java.util.List;

import tkpm.doan.student.R;
import tkpm.doan.student.data.models.Session;
import tkpm.doan.student.data.models.TeacherSchedule;
import tkpm.doan.student.databinding.ItemScheduleMasterBinding;
import tkpm.doan.student.ui.MainActivity;
import tkpm.doan.student.ui.student.ScheduleFragmentDirections;
import tkpm.doan.student.ui.teacher.TeacherViewModel;

public class TeacherScheduleAdapter extends ImmutableAdapter<TeacherSchedule> {
    private TeacherViewModel viewModel;
    private class ViewHolder extends AbstractViewHolder<TeacherSchedule> {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void bind(TeacherSchedule item) {
            ItemScheduleMasterBinding binding = ItemScheduleMasterBinding.bind(itemView);
            TextView dateText = binding.scheduleDate;
            TextView subjectText = binding.scheduleSubjectList;

            // bind data to view
            dateText.setText(item.dateToString());
            List<Session> lessons = item.getLessons();
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < lessons.size(); j++) {
                builder.append(lessons.get(j).getSubjectName()+" - "+lessons.get(j).getClassId())
                        .append("\n");
            }
            subjectText.setText(builder.toString());
            // navigate to schedule detail
            itemView.setOnClickListener(v -> {
                viewModel.setSelectedSchedule(item);
                MainActivity activity = (MainActivity) getContext();
                NavDirections directions = ScheduleFragmentDirections.navigateScheduleDetail();
                activity.getNavController().navigate(directions);
            });



        }
    }

    public TeacherScheduleAdapter(@NonNull Context context, @NonNull List<TeacherSchedule> list, TeacherViewModel viewModel) {
        super(context, list);
        this.viewModel= viewModel;
    }

    @NonNull
    @Override
    public AbstractViewHolder<TeacherSchedule> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_schedule_master, parent, false);
        return new ViewHolder(itemView);
    }
}
