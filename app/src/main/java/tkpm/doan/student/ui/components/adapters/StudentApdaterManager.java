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
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import tkpm.doan.student.R;
import tkpm.doan.student.data.models.RequestStudent;
import tkpm.doan.student.data.models.Student;
import tkpm.doan.student.databinding.ItemStudentMasterBinding;
import tkpm.doan.student.ui.MainActivity;
import tkpm.doan.student.ui.components.constants.AppData;
import tkpm.doan.student.ui.manager.ManagerViewModel;
import tkpm.doan.student.ui.manager.NotifyListFragmentDirections;
import tkpm.doan.student.ui.manager.SearchStudentFragmentDirections;
import tkpm.doan.student.ui.teacher.GradeDetailFragmentDirections;
import tkpm.doan.student.ui.teacher.TeacherViewModel;

public class StudentApdaterManager extends ImmutableAdapter<RequestStudent> {

    private static final String TAG = StudentAdapter.class.getName();
    private TextView Name;
    private TextView Class;
    private List<RequestStudent> list;
    private List<RequestStudent> listfilter;
    private List<RequestStudent> listsoure;
    private ManagerViewModel viewModel;

    private class ViewHolder extends AbstractViewHolder<RequestStudent> {
        private CheckBox checkBox;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void bind(RequestStudent item) {
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
                if (actionMode != null) {
                    checkBox.setChecked(!checkBox.isChecked());
                } else {
                    viewModel.setSelectedStudent(item);
                    NavDirections directions = SearchStudentFragmentDirections.navigateAddStudent();
                    MainActivity activity = (MainActivity) getContext();
                    activity.getNavController().navigate(directions);
                }
            });
        }
    }

    private boolean selectable;
    private ActionMode actionMode;
    private HashMap<Integer, Student> selectedStudent = new HashMap<>();

    public StudentApdaterManager(@NonNull Context context, @NonNull List<RequestStudent> list) {
        super(context, list);
        this.listfilter = list;
        this.list = new ArrayList<>();
        this.list.addAll(listfilter);
        this.listsoure = new ArrayList<>();
        this.listsoure.addAll(listfilter);
    }

    public void filter(String charText, int type) {
        if (type == 1) {
            for (RequestStudent wp : this.listsoure) {
                if (wp.getClassId().toLowerCase(Locale.getDefault()).substring(0, 2).contains(charText)) {
                    listfilter.add(wp);
                    list.add(wp);
                }
            }
        } else if (type == 2) {
            listfilter.clear();
            for (RequestStudent wp : list) {
                if (!wp.getClassId().toLowerCase(Locale.getDefault()).substring(0, 2).contains(charText))
                    listfilter.add(wp);
            }
            list = new ArrayList<>(listfilter);
        }

        else
        {
            charText = charText.toLowerCase(Locale.getDefault());
            listfilter.clear();
            if (charText.length() == 0) {
                listfilter.addAll(this.list);
            } else {
                for (RequestStudent wp : this.list) {
                    String name = wp.getLastName() + " " + wp.getMiddleName() + " " + wp.getFirstName();
                    if (name.toLowerCase(Locale.getDefault()).contains(charText) ||
                            wp.getClassId().toLowerCase(Locale.getDefault()).contains(charText)) {
                        listfilter.add(wp);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AbstractViewHolder<RequestStudent> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student_master, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AbstractViewHolder<RequestStudent> holder, int position) {
        super.onBindViewHolder(holder, position);
        ViewHolder viewHolder = (ViewHolder) holder;
    }
}