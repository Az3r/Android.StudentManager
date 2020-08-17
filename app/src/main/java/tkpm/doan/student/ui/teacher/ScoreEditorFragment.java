package tkpm.doan.student.ui.teacher;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import tkpm.doan.student.R;
import tkpm.doan.student.data.models.ScoreRequest;
import tkpm.doan.student.databinding.FragmentScoreEditorBinding;
import tkpm.doan.student.databinding.ItemScoreEditorBinding;
import tkpm.doan.student.ui.MainActivity;
import tkpm.doan.student.ui.components.adapters.EditScoreAdapter;
import tkpm.doan.student.ui.components.constants.AppData;
import tkpm.doan.student.ui.components.constants.Keys;
import tkpm.doan.student.ui.components.utils.RecyclerViews;

public class ScoreEditorFragment extends Fragment {
    private FragmentScoreEditorBinding binding;
    private TeacherViewModel viewModel;
    EditScoreAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentScoreEditorBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(requireActivity()).get(TeacherViewModel.class);
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
        setHasOptionsMenu(true);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecyclerView(binding.recyclerView);
    }
    private void setupRecyclerView(RecyclerView recyclerView) {
        RecyclerViews.setupListView(recyclerView);
        viewModel.getSelectedStudents().observe(getViewLifecycleOwner(), grades -> {
           adapter = new EditScoreAdapter(requireActivity(), grades);
            recyclerView.swapAdapter(adapter, true);
        });
    }
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.action_edit, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_submit) {

            for(int i=0;i< AppData.getInstance().studentList.size();i++)
            {
                boolean IsAdd= false;
                if(AppData.getInstance().studentList.get(0).getTest15()==null)
                    IsAdd=true;
                else
                {
                    if(AppData.getInstance().studentList.get(0).getTest15().size()==0)
                        IsAdd=true;
                }
                List<ScoreRequest> scoreRequests= new ArrayList<>();
                List<View> viewHolders =adapter.getView();
                ItemScoreEditorBinding binding = ItemScoreEditorBinding.bind(viewHolders.get(i));
                List<Float> score15= new ArrayList<>();
                List<Float> score45= new ArrayList<>();
                if(binding.score151.getText().toString()!=null||!binding.score151.getText().toString().isEmpty())
                    score15.add(Float.valueOf(binding.score151.getText().toString()));
                if(binding.score152.getText().toString()!=null||!binding.score152.getText().toString().isEmpty())
                    score15.add(Float.valueOf(binding.score152.getText().toString()));
                if(binding.score153.getText().toString()!=null||!binding.score153.getText().toString().isEmpty())
                    score15.add(Float.valueOf(binding.score153.getText().toString()));
                if(binding.score451.getText().toString()!=null||!binding.score451.getText().toString().isEmpty())
                    score45.add(Float.valueOf(binding.score451.getText().toString()));
                if(binding.score452.getText().toString()!=null||!binding.score452.getText().toString().isEmpty())
                    score45.add(Float.valueOf(binding.score452.getText().toString()));
                AppData.getInstance().studentList.get(i).setTest15(score15);
                AppData.getInstance().studentList.get(i).setTest45(score45);
                if(binding.score151.getText().toString()!=null||!binding.scoreSemester.getText().toString().isEmpty())
                    AppData.getInstance().studentList.get(i).setFinal(Float.valueOf(binding.scoreSemester.getText().toString()));
                ScoreRequest value = new ScoreRequest();
                value.setStudentId(AppData.getInstance().studentList.get(i).getStudentId());
                value.setTest15(AppData.getInstance().studentList.get(i).getTest15());
                value.setTest45(AppData.getInstance().studentList.get(i).getTest45());
                value.setTestFinal(AppData.getInstance().studentList.get(i).getTestFinal());
                value.setAcademicYear(AppData.getInstance().year);
                value.setSemester(AppData.getInstance().sem);
                value.setSubjectId(Float.parseFloat(AppData.getInstance().SubjectId));
                scoreRequests.add(value);
                if(IsAdd)
                {
                    viewModel.postScore(scoreRequests).observe(getViewLifecycleOwner(), responseBody -> {
                        if(responseBody!=null)
                        {
                            new Handler().postDelayed(() -> {
                                Toast.makeText(getContext(), R.string.add_score_success, Toast.LENGTH_SHORT).show();
                                MainActivity mainActivity = (MainActivity) requireActivity();
                                mainActivity.getNavController().navigateUp();
                            }, 2000);
                        }
                        else
                            Toast.makeText(getContext(), R.string.add_score_fail, Toast.LENGTH_SHORT).show();

                    });
                }
                else
                {
                    viewModel.UpdateScore(scoreRequests).observe(getViewLifecycleOwner(), responseBody -> {
                        try {
                            if(responseBody.string().contains("OK"))
                            {
                                new Handler().postDelayed(() -> {
                                    Toast.makeText(getContext(), R.string.add_score_success, Toast.LENGTH_SHORT).show();
                                    MainActivity mainActivity = (MainActivity) requireActivity();
                                    mainActivity.getNavController().navigateUp();
                                }, 2000);
                            }
                            else
                                Toast.makeText(getContext(), R.string.add_score_fail, Toast.LENGTH_SHORT).show();

                        } catch (IOException e) {
                            Toast.makeText(getContext(), R.string.add_score_fail, Toast.LENGTH_SHORT).show();

                            e.printStackTrace();
                        }
                    });
                }
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
