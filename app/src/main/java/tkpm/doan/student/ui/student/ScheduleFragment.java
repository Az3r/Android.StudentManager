package tkpm.doan.student.ui.student;

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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import tkpm.doan.student.data.models.Schedule;
import tkpm.doan.student.data.models.Session;
import tkpm.doan.student.databinding.FragmentScheduleListBinding;
import tkpm.doan.student.ui.components.adapters.ScheduleAdapter;
import tkpm.doan.student.ui.components.adapters.ScoreAdapter;

@AndroidEntryPoint
public class ScheduleFragment extends Fragment {

    private static final String TAG = "ScheduleFragment";
    private FragmentScheduleListBinding binding;
    private List<Schedule> schedules;
    private StudentViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentScheduleListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        viewModel = new ViewModelProvider(requireActivity()).get(StudentViewModel.class);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecyclerView(binding.recyclerView);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        viewModel.getSchedule().observe(getViewLifecycleOwner(), schedule -> {
            schedules= new ArrayList<>();
            Collections.sort(schedule);
            initSchedule(schedule);
            ScheduleAdapter adapter = new ScheduleAdapter(requireActivity(), schedules, viewModel);
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
                        schedules.add(new Schedule(DayOfWeek.of(day-1),value));
                        value= new ArrayList<>();
                        i=1;
                        item.setPeriod(i);
                        value.add(item);
                        day=(int) item.getDayOfWeek();
                    }
                }
                schedules.add(new Schedule(DayOfWeek.of(day-1),value));
            }
        }
    }
}