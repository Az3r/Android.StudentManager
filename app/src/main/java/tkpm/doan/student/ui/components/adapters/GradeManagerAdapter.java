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
import tkpm.doan.student.data.models.ClassName;
import tkpm.doan.student.data.models.Grade;
import tkpm.doan.student.databinding.ItemGradeMasterBinding;
import tkpm.doan.student.ui.MainActivity;
import tkpm.doan.student.ui.manager.GradeListFragment;
import tkpm.doan.student.ui.manager.GradeListFragmentDirections;
import tkpm.doan.student.ui.manager.ManagerViewModel;
import tkpm.doan.student.ui.teacher.GradeFragmentDirections;
import tkpm.doan.student.ui.teacher.TeacherViewModel;

public class GradeManagerAdapter extends ImmutableAdapter<ClassName> {
    private TextView Class;
    private  TextView Teacher;
    private  TextView NumberStudent;
    private class ViewHolder extends AbstractViewHolder<ClassName> {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        @Override
        public void bind(ClassName item) {
            ItemGradeMasterBinding binding = ItemGradeMasterBinding.bind(itemView);
            Class= binding.gradeClassName;
            Teacher= binding.gradeHomeTeacher;
            NumberStudent= binding.gradeStudentCount;
            Class.setText(item.getClassId());
            Teacher.setText(item.getLastName()+" "+item.getMiddleName()+" "+item.getFirstName());
            NumberStudent.setText(""+ item.getSumStudent());
            itemView.setOnClickListener(view -> {
                ManagerViewModel viewModel = new ViewModelProvider((MainActivity) getContext()).get(ManagerViewModel.class);
                viewModel.setSelectedGrade(item);
                MainActivity activity = (MainActivity) getContext();
                NavDirections directions = GradeListFragmentDirections.navgiateClassDetail();
                activity.getNavController().navigate(directions);
            });
        }
    }
    public GradeManagerAdapter(@NonNull Context context, @NonNull List<ClassName> list) {
        super(context, list);
    }
    @NonNull
    @Override
    public AbstractViewHolder<ClassName> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grade_master, parent, false);
        return new GradeManagerAdapter.ViewHolder(itemView);
    }
}