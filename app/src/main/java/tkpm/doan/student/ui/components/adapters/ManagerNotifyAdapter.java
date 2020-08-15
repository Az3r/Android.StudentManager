package tkpm.doan.student.ui.components.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;

import java.util.List;

import tkpm.doan.student.data.models.Notification;
import tkpm.doan.student.databinding.ItemNotificationMasterBinding;
import tkpm.doan.student.ui.MainActivity;

public class ManagerNotifyAdapter extends ImmutableAdapter<Notification> {

    private class ViewHolder extends AbstractViewHolder<Notification> {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void bind(Notification item) {
            ItemNotificationMasterBinding binding = ItemNotificationMasterBinding.bind(itemView);
            binding.notifyImportant.setVisibility(View.GONE);


            itemView.setOnClickListener(v -> {
                // TODO in view model set this item as selected

                MainActivity activity = (MainActivity) getContext();
//                NavDirections directions =
            });
        }
    }

    public ManagerNotifyAdapter(@NonNull Context context, @NonNull List<Notification> list) {
        super(context, list);
    }

    @NonNull
    @Override
    public AbstractViewHolder<Notification> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }
}
