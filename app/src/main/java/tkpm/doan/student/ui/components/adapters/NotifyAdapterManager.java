package tkpm.doan.student.ui.components.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;

import java.util.List;

import tkpm.doan.student.R;
import tkpm.doan.student.data.models.Notification;
import tkpm.doan.student.databinding.ItemNotificationMasterBinding;
import tkpm.doan.student.ui.MainActivity;
import tkpm.doan.student.ui.components.constants.Provider;
import tkpm.doan.student.ui.manager.ManagerViewModel;
import tkpm.doan.student.ui.manager.NotifyListFragmentDirections;
import tkpm.doan.student.ui.student.NotificationFragmentDirections;
import tkpm.doan.student.ui.student.StudentViewModel;
import tkpm.doan.student.ui.teacher.TeacherViewModel;

public class NotifyAdapterManager extends ImmutableAdapter<Notification> {
    private ManagerViewModel viewModel;

    private class ViewHolder extends AbstractViewHolder<Notification> {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void bind(Notification item) {
            ItemNotificationMasterBinding binding = ItemNotificationMasterBinding.bind(itemView);
            viewModel= new ViewModelProvider((MainActivity) getContext()).get(ManagerViewModel.class);
            TextView notify_date = binding.notifyDate;
            TextView notify_title = binding.notifyTitle;
            // set text item notify
            notify_title.setText(item.getTitle());
            notify_date.setText(Provider.getDateFormat().format(item.getCreatedOn()));

            // navigate to notification detail
            itemView.setOnClickListener(v -> {
                viewModel.setSelectedNotify(item);
                NavDirections directions = NotifyListFragmentDirections.navigateCreateNotify();
                MainActivity activity = (MainActivity) getContext();
                activity.getNavController().navigate(directions);
            });
        }
    }


    public NotifyAdapterManager(@NonNull Context context, @NonNull List<Notification> list) {
        super(context, list);
    }

    @NonNull
    @Override
    public AbstractViewHolder<Notification> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notification_master, parent, false);
        return new NotifyAdapterManager.ViewHolder(itemView);
    }
}
