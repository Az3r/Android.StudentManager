package tkpm.doan.student.ui.student;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import tkpm.doan.student.R;
import tkpm.doan.student.components.Constants.BundleKeys;

@AndroidEntryPoint
public class ScheduleFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private static final String TAG = "ScheduleFragment";

    private ListView listView;

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

        listView = view.findViewById(R.id.gridview);
        listView.setOnItemSelectedListener(this);

        listView.setAdapter(adapter);
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
