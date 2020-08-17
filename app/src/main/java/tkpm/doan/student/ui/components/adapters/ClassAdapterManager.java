package tkpm.doan.student.ui.components.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import tkpm.doan.student.R;
import tkpm.doan.student.data.models.ClassName;
import tkpm.doan.student.data.models.Notification;
import tkpm.doan.student.databinding.ItemNotificationMasterBinding;
import tkpm.doan.student.ui.MainActivity;
import tkpm.doan.student.ui.components.constants.Provider;
import tkpm.doan.student.ui.manager.ManagerViewModel;
import tkpm.doan.student.ui.manager.NotifyListFragmentDirections;

public class ClassAdapterManager extends ImmutableAdapter<ClassName> {
    private ManagerViewModel viewModel;
    private List<ClassName> List;
    private List<ClassName> ListFilter;

    private class ViewHolder extends AbstractViewHolder<ClassName> {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void bind(ClassName item) {
            ItemNotificationMasterBinding binding = ItemNotificationMasterBinding.bind(itemView);
            viewModel = new ViewModelProvider((MainActivity) getContext()).get(ManagerViewModel.class);
            TextView notify_date = binding.notifyDate;
            TextView notify_title = binding.notifyTitle;
            // set text item notify
//            notify_title.setText(item.getTitle());
//            notify_date.setText(Provider.getDateFormat().format(item.getCreatedOn()));

            // navigate to notification detail
            itemView.setOnClickListener(v -> {
//                viewModel.setSelectedNotify(item);
                NavDirections directions = NotifyListFragmentDirections.navigateCreateNotify();
                MainActivity activity = (MainActivity) getContext();
                activity.getNavController().navigate(directions);
            });
        }
    }
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        ListFilter.clear();
        if (charText.length() == 0) {
            ListFilter.addAll(this.List);
        } else {
            for (ClassName wp : this.List) {
//                if (wp.getClassName().toLowerCase(Locale.getDefault()).contains(charText) ||
//                        wp.getCreatedOn().toString().toLowerCase(Locale.getDefault()).contains(charText)) {
//                    ListFilter.add(wp);
//                }
            }
        }
        notifyDataSetChanged();
    }

    public ClassAdapterManager(@NonNull Context context, @NonNull List<ClassName> list) {
        super(context, list);
        List = list;
        ListFilter = new ArrayList<>(List);
    }

    @NonNull
    @Override
    public AbstractViewHolder<ClassName> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notification_master, parent, false);
        return new ClassAdapterManager.ViewHolder(itemView);
    }
}
