package tkpm.doan.student.ui.teacher;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tkpm.doan.student.data.models.Schedule;
import tkpm.doan.student.data.models.Session;
import tkpm.doan.student.data.models.TeacherSchedule;
import tkpm.doan.student.databinding.FragmentTeacherScheduleBinding;
import tkpm.doan.student.ui.components.adapters.TeacherScheduleAdapter;
import tkpm.doan.student.ui.components.utils.RecyclerViews;

public class ScheduleFragment extends Fragment {
    private FragmentTeacherScheduleBinding binding;
    private TeacherViewModel viewModel;
    private List<TeacherSchedule> schedules;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentTeacherScheduleBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        viewModel = new ViewModelProvider(requireActivity()).get(TeacherViewModel.class);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecyclerView(binding.recyclerView);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void setupRecyclerView(RecyclerView recyclerView) {
        RecyclerViews.setupGridView(recyclerView, 1);
        viewModel.getSchedule().observe(getViewLifecycleOwner(), sessions -> {
            schedules= new ArrayList<>();
            Collections.sort(sessions);
            initSchedule(sessions);
            TeacherScheduleAdapter adapter = new TeacherScheduleAdapter(requireActivity(), schedules, viewModel);
            recyclerView.swapAdapter(adapter, true);
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void initSchedule(List<Session> list)
    {
        if(list!=null)
        {
            if(list.size()>0)
            {
                int day=(int)list.get(0).getDayOfWeek();
                List<Session> value= new ArrayList<>();
                int i=1;
                for (Session item : list) {
                    if((int)item.getDayOfWeek()==day)
                    {
                        item.setPeriod(i);
                        value.add(item);
                        i++;
                    }
                    else
                    {
                        schedules.add(new TeacherSchedule(DayOfWeek.of(day-1),value));
                        value= new ArrayList<>();
                        i=1;
                        item.setPeriod(i);
                        value.add(item);
                        day=(int) item.getDayOfWeek();
                    }
                }
                schedules.add(new TeacherSchedule(DayOfWeek.of(day-1),value));
            }
        }
    }
}
