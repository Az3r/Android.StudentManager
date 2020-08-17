package tkpm.doan.student.ui.components.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.ActionMode;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import tkpm.doan.student.R;
import tkpm.doan.student.data.models.Student;
import tkpm.doan.student.databinding.ItemStudentMasterBinding;
import tkpm.doan.student.ui.MainActivity;
import tkpm.doan.student.ui.components.constants.AppData;
import tkpm.doan.student.ui.teacher.GradeDetailFragmentDirections;
import tkpm.doan.student.ui.teacher.GradeFragmentDirections;
import tkpm.doan.student.ui.teacher.StudentProfileFragmentDirections;
import tkpm.doan.student.ui.teacher.TeacherViewModel;

public class StudentAdapter extends ImmutableAdapter<Student> implements ActionMode.Callback {

    private static final String TAG = StudentAdapter.class.getName();
    private TextView Name;
    private TextView Class;
    private List<Student> list= new ArrayList<>();
    private TeacherViewModel viewModel;

    private class ViewHolder extends AbstractViewHolder<Student> {
        private CheckBox checkBox;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        @Override
        public void bind(Student item) {
            this.itemView.setTag(item);
            ItemStudentMasterBinding binding = ItemStudentMasterBinding.bind(itemView);
            viewModel= new ViewModelProvider((MainActivity) getContext()).get(TeacherViewModel.class);
            checkBox = binding.studentSelected;
            Name= binding.studentName;
            Class= binding.studentClass;
            Name.setText(item.getLastName()+" "+item.getMiddleName()+" "+item.getFirstName());
            Class.setText(item.getClassId());
            itemView.setOnClickListener(v -> {
                if (actionMode != null) {
                    checkBox.setChecked(!checkBox.isChecked());
                } else {
                    list.add(item);
                    AppData.getInstance().studentList= list;
                    viewModel.setSelectedStudents(list);
                    MainActivity activity = (MainActivity) getContext();
                    NavDirections directions = GradeDetailFragmentDirections.navgiateStudentProfile();
                    activity.getNavController().navigate(directions);
                }
            });
        }
    }

    private boolean selectable;
    private ActionMode actionMode;
    private HashMap<Integer, Student> selectedStudent = new HashMap<>();

    public StudentAdapter(@NonNull Context context, @NonNull List<Student> list) {
        super(context, list);
    }

    @NonNull
    @Override
    public AbstractViewHolder<Student> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student_master, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AbstractViewHolder<Student> holder, int position) {
        super.onBindViewHolder(holder, position);

        ViewHolder viewHolder = (ViewHolder) holder;

        // we just want to update view, no need for calling listener
        viewHolder.checkBox.setOnCheckedChangeListener(null);
        viewHolder.checkBox.setChecked(selectedStudent.containsKey(position));
        viewHolder.checkBox.setOnCheckedChangeListener((compoundButton, b) -> onCheckedChanged(b, position));
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        mode.getMenuInflater().inflate(R.menu.action_grade, menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        Log.i(TAG, String.format("Process %d selected student", selectedStudent.size()));

        if (item.getItemId() == R.id.nav_score_editor) {
            MainActivity activity = (MainActivity) getContext();
            NavDirections directions = GradeDetailFragmentDirections.navgiateScoreEditor();
            activity.getNavController().navigate(directions);
            mode.finish();
            return true;
        }

        return false;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {

        actionMode = null;

        // invalidate all selected students
        ArrayList<Integer> selectedPos = new ArrayList<>(selectedStudent.keySet());
        selectedStudent.clear();
        for (Integer pos : selectedPos)
            notifyItemChanged(pos);

    }

    private void onCheckedChanged(boolean isChecked, int position) {

        if (isChecked && actionMode == null) {
            MainActivity activity = (MainActivity) getContext();
            actionMode = activity.startSupportActionMode(StudentAdapter.this);
        }

        if (isChecked)
        {
            selectedStudent.put(position, getItem(position));
            list= new ArrayList<>(selectedStudent.values());
            AppData.getInstance().studentList= list;
            viewModel.setSelectedStudents(list);
        }
        else
            selectedStudent.remove(position);

        if (actionMode != null) {
            String title = getContext().getResources().getString(R.string.format_selected, selectedStudent.size());
            actionMode.setTitle(title);
        }
    }
}
