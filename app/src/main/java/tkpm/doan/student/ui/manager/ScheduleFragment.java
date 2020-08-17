package tkpm.doan.student.ui.manager;

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
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import tkpm.doan.student.data.models.ResponSession;
import tkpm.doan.student.data.models.Schedule;
import tkpm.doan.student.data.models.Session;
import tkpm.doan.student.data.models.TeacherSchedule;
import tkpm.doan.student.databinding.FragmentScheduleListBinding;
import tkpm.doan.student.ui.MainActivity;
import tkpm.doan.student.ui.components.adapters.ScheduleManagerAdapter;
import tkpm.doan.student.ui.components.adapters.TeacherScheduleAdapter;
import tkpm.doan.student.ui.components.constants.AppData;
import tkpm.doan.student.ui.components.utils.RecyclerViews;
import tkpm.doan.student.ui.teacher.TeacherViewModel;

public class ScheduleFragment extends Fragment {
    private FragmentScheduleListBinding binding;
    private ManagerViewModel viewModel;
    List<Schedule> schedules;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentScheduleListBinding.inflate(inflater, container, false);
        return  binding.getRoot();
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
        viewModel = new ViewModelProvider((MainActivity) getContext()).get(ManagerViewModel.class);
        setupRecyclerView(binding.recyclerView);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void setupRecyclerView(RecyclerView recyclerView) {
        RecyclerViews.setupGridView(recyclerView, 1);
        viewModel.getSelectedGrade().observe(getViewLifecycleOwner(),className -> {
            viewModel.GetScheduleClass(className.getClassId(),
                    AppData.getInstance().sem,AppData.getInstance().year).
                    observe(getViewLifecycleOwner(), sessions -> {
                        Collections.sort(sessions);
                        initSchedule(sessions);
                        ScheduleManagerAdapter adapter = new ScheduleManagerAdapter(requireActivity(), schedules);
                        recyclerView.swapAdapter(adapter, true);
            });
        });
        // TODO get schedule from selected grade
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void initSchedule(List<ResponSession> list)
    {
        schedules= new ArrayList<>();
        if(list!=null)
        {
            if(list.size()>0)
            {
                int day=(int)list.get(0).getDayOfWeek();
                List<Session> value= new ArrayList<>();
                int i=1;
                for (ResponSession item : list) {
                    Session session= new Session();
                    if((int)item.getDayOfWeek()==day)
                    {
                        session.setPeriod(i);
                        session.setSubjectName(item.getSubjectName());
                        value.add(session);
                        i++;
                    }
                    else
                    {
                        schedules.add(new Schedule(DayOfWeek.of(day-1),value));
                        value= new ArrayList<>();
                        i=1;
                        session.setPeriod(i);
                        session.setSubjectName(item.getSubjectName());
                        value.add(session);
                        day=(int) item.getDayOfWeek();
                    }
                }
                schedules.add(new Schedule(DayOfWeek.of(day-1),value));
            }
        }
    }
}
