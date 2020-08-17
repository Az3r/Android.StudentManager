package tkpm.doan.student.ui.components.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.ActionMode;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import tkpm.doan.student.R;
import tkpm.doan.student.data.models.PersonalInfo;
import tkpm.doan.student.data.models.Student;
import tkpm.doan.student.databinding.ItemStudentMasterBinding;
import tkpm.doan.student.ui.MainActivity;
import tkpm.doan.student.ui.manager.GradeDetailFragmentDirections;
import tkpm.doan.student.ui.manager.ManagerViewModel;
import tkpm.doan.student.ui.manager.SearchStudentFragmentDirections;

public class StudentClassManagerApdapter extends ImmutableAdapter<PersonalInfo> {

    private static final String TAG = StudentAdapter.class.getName();
    private TextView Name;
    private TextView Class;
    private List<Student> list;
    private List<Student> listfilter;
    private List<Student> listsoure;
    private ManagerViewModel viewModel;

    private class ViewHolder extends AbstractViewHolder<PersonalInfo> {
        private CheckBox checkBox;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void bind(PersonalInfo item) {
            this.itemView.setTag(item);
            ItemStudentMasterBinding binding = ItemStudentMasterBinding.bind(itemView);
            viewModel = new ViewModelProvider((MainActivity) getContext()).get(ManagerViewModel.class);
            checkBox = binding.studentSelected;
            checkBox.setVisibility(View.GONE);
            Name = binding.studentName;
            Class = binding.studentClass;
            Name.setText(item.getLastName() + " " + item.getMiddleName() + " " + item.getFirstName());
            Class.setText(item.getClassId());
            itemView.setOnClickListener(v -> {
                Student student= new Student();
                student.setStudentId(item.getStudentId());
                student.setFirstName(item.getFirstName());
                student.setMiddleName(item.getMiddleName());
                student.setLastName(item.getLastName());
                student.setIsMale(item.getIsMale());
                student.setClassId(item.getClassId());
                student.setAddress(item.getAddress());
                student.setBirthday(item.getBirthday());
                student.setPhoneNumber(item.getPhoneNumber());
                student.setEmail(item.getEmail());
                viewModel.setSelectedStudent(student);
                NavDirections directions = GradeDetailFragmentDirections.actionNavManagerClassDetailToNavCreateStudent();
                MainActivity activity = (MainActivity) getContext();
                activity.getNavController().navigate(directions);
            });
        }
    }

    public StudentClassManagerApdapter(@NonNull Context context, @NonNull List<PersonalInfo> list) {
        super(context, list);
    }


    @NonNull
    @Override
    public AbstractViewHolder<PersonalInfo> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student_master, parent, false);
        return new StudentClassManagerApdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AbstractViewHolder<PersonalInfo> holder, int position) {
        super.onBindViewHolder(holder, position);
        StudentClassManagerApdapter.ViewHolder viewHolder = (StudentClassManagerApdapter.ViewHolder) holder;
    }
}