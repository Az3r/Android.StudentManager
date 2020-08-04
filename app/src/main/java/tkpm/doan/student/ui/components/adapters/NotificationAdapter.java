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
import tkpm.doan.student.data.models.Notification;
import tkpm.doan.student.databinding.ItemNotificationMasterBinding;
import tkpm.doan.student.ui.MainActivity;
import tkpm.doan.student.ui.components.constants.Provider;
import tkpm.doan.student.ui.student.StudentFragmentDirections;

public class NotificationAdapter extends ImmutableAdapter<Notification> {

    private class ViewHolder extends AbstractViewHolder<Notification> {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void bind(Notification item) {
            ItemNotificationMasterBinding binding = ItemNotificationMasterBinding.bind(itemView);

            TextView notify_date = binding.notifyDate;
            TextView notify_title = binding.notifyTitle;
            notify_title.setText(item.getTitle());

            // TODO fix this line below
            // notify_date.setText(Provider.getDateFormater().format(item.getDate()));

            // navigate to schedule detail
            itemView.setOnClickListener(v -> {
                NavController controller = Navigation.findNavController((MainActivity) getContext(), R.id.nav_host);
                NavDirections directions = StudentFragmentDirections.actionStudentFragmentToNotificationDetailFragment();
                controller.navigate(directions);
            });
        }
    }

    public NotificationAdapter(@NonNull Context context, @NonNull List<Notification> list) {
        super(context, list);
    }

    @NonNull
    @Override
    public AbstractViewHolder<Notification> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notification_master, parent, false);
        return new ViewHolder(itemView);
    }
}

