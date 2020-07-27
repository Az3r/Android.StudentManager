package tkpm.doan.student.ui.student;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Collections;

import tkpm.doan.student.R;
import tkpm.doan.student.components.Constants.BundleKeys;
import tkpm.doan.student.data.models.Student;

public class ScheduleFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private Student student = new Student();
    private BaseAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_student_schedule, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        GridView gridView = view.findViewById(R.id.gridview);
        gridView.setOnItemSelectedListener(this);
        adapter = new ScheduleAdapter(getContext(), Collections.emptyList());
        gridView.setAdapter(adapter);
    }

    public static ScheduleFragment newInstance(String studentId) {

        Bundle args = new Bundle();
        args.putString(BundleKeys.STUDENT_ID, studentId);
        ScheduleFragment fragment = new ScheduleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String date = (String) adapter.getItem(i);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
