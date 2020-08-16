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
import tkpm.doan.student.data.models.RequestStudent;
import tkpm.doan.student.data.models.Teacher;
import tkpm.doan.student.databinding.ItemTeacherMasterBinding;
import tkpm.doan.student.ui.MainActivity;
import tkpm.doan.student.ui.manager.ManagerViewModel;
import tkpm.doan.student.ui.manager.SearchTeacherFragmentDirections;

public class TeacherAdapter extends ImmutableAdapter<Teacher> {
    ManagerViewModel viewModel;
    TextView Name;
    TextView Subject;
    List<Teacher> List;
    List<Teacher> ListFilter;

    private class ViewHolder extends AbstractViewHolder<Teacher> {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void bind(Teacher item) {
            ItemTeacherMasterBinding binding = ItemTeacherMasterBinding.bind(itemView);
            viewModel = new ViewModelProvider((MainActivity) getContext()).get(ManagerViewModel.class);
            Name = binding.teacherName;
            Subject = binding.teacherSubject;
            Name.setText(item.getLastName() + " " + item.getMiddleName() + " " + item.getFirstName());
            Subject.setText(item.getSubjectName());
            itemView.setOnClickListener(v -> {
                // TODO in viewmodel set selected teacher
                viewModel.setSelectedTeacher(item);
                MainActivity activity = (MainActivity) getContext();
                NavDirections directions = SearchTeacherFragmentDirections.navigateTeacher();
                activity.getNavController().navigate(directions);
            });

            // TODO bind data to view
        }
    }
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        ListFilter.clear();
        if (charText.length() == 0) {
            ListFilter.addAll(this.List);
        } else {
            for (Teacher wp : this.List) {
                String name = wp.getLastName() + " " + wp.getMiddleName() + " " + wp.getFirstName();
                if (name.toLowerCase(Locale.getDefault()).contains(charText) ||
                        wp.getSubjectName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    ListFilter.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }


    public TeacherAdapter(@NonNull Context context, @NonNull List<Teacher> list) {
        super(context, list);
        ListFilter = list;
        List = new ArrayList<>(list);
    }

    @NonNull
    @Override
    public AbstractViewHolder<Teacher> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_teacher_master, parent, false);
        return new ViewHolder(itemView);
    }
}
