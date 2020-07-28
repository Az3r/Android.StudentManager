package tkpm.doan.student.ui.student;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import tkpm.doan.student.R;
import tkpm.doan.student.data.models.Student;

@AndroidEntryPoint
public class ScheduleFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private static final String TAG = "ScheduleFragment";

    private GridView scheduleContainer;

    @Inject
    public ScheduleAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_student_schedule, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // TODO get student from bundle

        scheduleContainer = view.findViewById(R.id.gridview);
        scheduleContainer.setOnItemSelectedListener(this);

        scheduleContainer.setAdapter(adapter);
    }

    public static ScheduleFragment newInstance(Student student) {

        // TODO put student into bunlde
        Bundle args = new Bundle();
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
