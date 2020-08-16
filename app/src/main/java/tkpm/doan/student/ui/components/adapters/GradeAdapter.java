package tkpm.doan.student.ui.components.adapters;

import android.content.Context;
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
import tkpm.doan.student.data.models.Grade;
import tkpm.doan.student.databinding.ItemGradeMasterBinding;
import tkpm.doan.student.ui.MainActivity;
import tkpm.doan.student.ui.teacher.GradeFragmentDirections;
import tkpm.doan.student.ui.teacher.TeacherViewModel;

public class GradeAdapter extends ImmutableAdapter<Grade> {
    private  TextView Class;
    private  TextView Teacher;
    private  TextView NumberStudent;
    private class ViewHolder extends AbstractViewHolder<Grade> {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        @Override
        public void bind(Grade item) {
            ItemGradeMasterBinding binding = ItemGradeMasterBinding.bind(itemView);
            Class= binding.gradeClassName;
            Teacher= binding.gradeHomeTeacher;
            NumberStudent= binding.gradeStudentCount;
            Class.setText(item.getClassId());
            Teacher.setText(item.getHomeroomTeacherName());
            NumberStudent.setText(""+ item.getSumStudent());

            itemView.setOnClickListener(view -> {
                TeacherViewModel viewModel = new ViewModelProvider((MainActivity) getContext()).get(TeacherViewModel.class);
                viewModel.setSelectedGrade(item.getClassId());
                MainActivity activity = (MainActivity) getContext();
                NavDirections directions = GradeFragmentDirections.navgiateGradeDetail();
                activity.getNavController().navigate(directions);
            });
        }
    }

    public GradeAdapter(@NonNull Context context, @NonNull List<Grade> list) {
        super(context, list);
    }

    @NonNull
    @Override
    public AbstractViewHolder<Grade> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grade_master, parent, false);
        return new ViewHolder(itemView);
    }
}
