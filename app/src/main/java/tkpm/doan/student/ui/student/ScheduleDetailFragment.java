package tkpm.doan.student.ui.student;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import tkpm.doan.student.R;
import tkpm.doan.student.data.models.Lesson;
import tkpm.doan.student.data.models.Schedule;

@AndroidEntryPoint
public class ScheduleDetailFragment extends Fragment {

    @Inject
    public List<Lesson> lessons;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_schedule_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // TODO get schedule from bundle
        LessonAdapter adapter = new LessonAdapter(getContext(), R.layout.item_schedule_detail, lessons);

        ListView listView = view.findViewById(R.id.listview);
        listView.setAdapter(adapter);

    }

    public static ScheduleDetailFragment newInstance(Schedule scheule) {
        // TODO put schedule into bundle
        Bundle args = new Bundle();

        ScheduleDetailFragment fragment = new ScheduleDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
