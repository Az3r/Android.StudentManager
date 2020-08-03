package tkpm.doan.student.ui.components.adapters;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import java.util.List;

import tkpm.doan.student.R;
import tkpm.doan.student.data.models.Lesson;
import tkpm.doan.student.data.models.Schedule;
import tkpm.doan.student.data.models.Subject;
import tkpm.doan.student.databinding.ItemScheduleMasterBinding;
import tkpm.doan.student.ui.MainActivity;
import tkpm.doan.student.ui.student.StudentFragmentDirections;
import tkpm.doan.student.ui.student.StudentViewModel;

public final class ScheduleAdapter extends ImmutableAdapter<Schedule> {

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


            // navigate to schedule detail
            itemView.setOnClickListener(v -> {
                NavController controller = Navigation.findNavController((MainActivity) getContext(), R.id.nav_host);
                NavDirections directions = StudentFragmentDirections.actionStudentFragmentToScheduleDetailFragment();
                controller.navigate(directions);
            });
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

}
