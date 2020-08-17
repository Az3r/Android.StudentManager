package tkpm.doan.student.ui.manager;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import tkpm.doan.student.R;
import tkpm.doan.student.data.models.Session;
import tkpm.doan.student.data.models.Subject;
import tkpm.doan.student.databinding.FragmentCreateScheduleBinding;
import tkpm.doan.student.ui.MainActivity;
import tkpm.doan.student.ui.components.adapters.EditScheduleAdapter;
import tkpm.doan.student.ui.components.adapters.ScheduleItemAdapter;
import tkpm.doan.student.ui.components.adapters.StudentApdaterManager;
import tkpm.doan.student.ui.components.constants.Keys;
import tkpm.doan.student.ui.components.constants.Provider;
import tkpm.doan.student.ui.components.utils.RecyclerViews;

public class CreateScheduleFragment extends Fragment {

    private FragmentCreateScheduleBinding binding;
    private ManagerViewModel viewModel;
    private TextInputEditText sem;
    private TextInputEditText year;
    private AppCompatAutoCompleteTextView Subject;
    private AppCompatAutoCompleteTextView Subject1;
    private AppCompatAutoCompleteTextView Subject2;
    private AppCompatAutoCompleteTextView Subject3;
    private AppCompatAutoCompleteTextView Subject4;
    private AppCompatAutoCompleteTextView Teacher;
    private AppCompatAutoCompleteTextView Teacher1;
    private AppCompatAutoCompleteTextView Teacher2;
    private AppCompatAutoCompleteTextView Teacher3;
    private AppCompatAutoCompleteTextView Teacher4;
    private AppCompatAutoCompleteTextView Class;
    private AppCompatAutoCompleteTextView DateOf;
    private AppCompatAutoCompleteTextView SesionTime;
    ArrayAdapter<String> adapterSubject;
    ArrayAdapter<String> adapterTeacher;
    ArrayAdapter<String> adapterTeacher1;
    ArrayAdapter<String> adapterTeacher2;
    ArrayAdapter<String> adapterTeacher3;
    ArrayAdapter<String> adapterTeacher4;
    List<tkpm.doan.student.data.models.Subject> data;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCreateScheduleBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        setHasOptionsMenu(true);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel =  new ViewModelProvider(requireActivity()).get(ManagerViewModel.class);
        sem= binding.inputSemester;
        year= binding.inputYear;
        Class= binding.inputClass;
        DateOf= binding.inputDate;
        SesionTime= binding.inputSession;
        sem.setText(""+Keys.sem);
        year.setText(""+Keys.year);
        sem.setEnabled(false);
        year.setEnabled(false);
        Subject=binding.Subject;
        Subject1=binding.Subject1;
        Subject2=binding.Subject2;
        Subject3=binding.Subject3;
        Subject4=binding.Subject4;
        Teacher= binding.teacher;
        Teacher1= binding.teacher1;
        Teacher2= binding.teacher2;
        Teacher3= binding.teacher3;
        Teacher4= binding.teacher4;
        Teacher.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View view) {
                String source= Subject.getText().toString();
                adapterTeacher= new ArrayAdapter<>(getActivity(),R.layout.textview, R.id.textview, GetTeacherData(source));
                Teacher.setAdapter(adapterTeacher);
                adapterTeacher.notifyDataSetChanged();
            }
        });
        Teacher1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String source= Subject1.getText().toString();
                adapterTeacher1= new ArrayAdapter<>(getActivity(),R.layout.textview, R.id.textview, GetTeacherData(source));
                Teacher1.setAdapter(adapterTeacher1);
                adapterTeacher1.notifyDataSetChanged();
            }
        });
        Teacher2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String source= Subject2.getText().toString();
                adapterTeacher2= new ArrayAdapter<>(getActivity(),R.layout.textview, R.id.textview, GetTeacherData(source));
                Teacher2.setAdapter(adapterTeacher2);
                adapterTeacher2.notifyDataSetChanged();
            }
        });
        Teacher3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String source= Subject3.getText().toString();
                adapterTeacher3= new ArrayAdapter<>(getActivity(),R.layout.textview, R.id.textview, GetTeacherData(source));
                Teacher3.setAdapter(adapterTeacher3);
                adapterTeacher3.notifyDataSetChanged();
            }
        });
        Teacher4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String source= Subject4.getText().toString();
                adapterTeacher4= new ArrayAdapter<>(getActivity(),R.layout.textview, R.id.textview, GetTeacherData(source));
                Teacher4.setAdapter(adapterTeacher4);
                adapterTeacher4.notifyDataSetChanged();
            }
        });
        String[] sesiontime = getResources().getStringArray(R.array.array_subject_session);
        ArrayAdapter<String> adaptersession = new ArrayAdapter<>(requireActivity(), R.layout.textview, R.id.textview, sesiontime);
        binding.inputSession.setAdapter(adaptersession);
        viewModel.GetAllClass(Keys.year).observe(getViewLifecycleOwner(), list->{
            List<String> data = new ArrayList<>();
            for (int i=0;i<list.size();i++)
            {
                if(!list.get(i).getClassId().contains("FULL"))
                    data.add(list.get(i).getClassName());
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(requireActivity(), R.layout.textview, R.id.textview, data);
            Class.setAdapter(adapter);
        });
        ArrayAdapter<String> adapter;
        String[] dates = getResources().getStringArray(R.array.array_date);
        adapter = new ArrayAdapter<>(requireActivity(), R.layout.textview, R.id.textview, dates);
        binding.inputDate.setAdapter(adapter);
        setupRecyclerView();
    }
    public List<String> GetTeacherData(String input)
    {
        for (int i=0;i<data.size();i++)
        {
            String dest=data.get(i).getSubjectName();
            if(dest.contains(input))
            {
                List<String> data1 = new ArrayList<>();
                List<tkpm.doan.student.data.models.Teacher> value = data.get(i).getTeachers();
                for (int j=0;j<value.size();j++)
                {
                    String name= value.get(j).getLastName()+" "
                            +value.get(j).getMiddleName()+" "
                            +value.get(j).getFirstName();
                    data1.add(name);
                }
                return data1;
            }
        }
        return null;
    }

    private void setupRecyclerView() {
        viewModel.GetAllSubjectByTeacher().observe(getViewLifecycleOwner(),list->{
            this.data= list;
            List<String> data = new ArrayList<>();
            for (int i=0;i<list.size();i++)
            {
                data.add(list.get(i).getSubjectName());
            }
            adapterSubject= new ArrayAdapter<>(getContext(), R.layout.textview, R.id.textview, data);
            Subject.setAdapter(adapterSubject);
            Subject1.setAdapter(adapterSubject);
            Subject2.setAdapter(adapterSubject);
            Subject3.setAdapter(adapterSubject);
            Subject4.setAdapter(adapterSubject);
        });
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.action_edit, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_submit:
                if(DateOf.getText().toString().isEmpty()||SesionTime.getText().toString().isEmpty()
                ||Class.getText().toString().isEmpty())
                    showAlert("You must enter full information");
                else
                {

                    if((!Subject.getText().toString().isEmpty()&&Teacher.getText().toString().isEmpty())||
                            (Subject.getText().toString().isEmpty()&&!Teacher.getText().toString().isEmpty()))
                    {
                        showAlert("You must enter full information");
                    }
                    if((Subject1.getText().toString().isEmpty()&&!Teacher1.getText().toString().isEmpty())||
                            (!Subject1.getText().toString().isEmpty()&&Teacher1.getText().toString().isEmpty()))
                    {
                        showAlert("You must enter full information");
                    }
                    if((Subject2.getText().toString().isEmpty()&&!Teacher2.getText().toString().isEmpty())||
                            (!Subject2.getText().toString().isEmpty()&&Teacher2.getText().toString().isEmpty()))
                    {
                        showAlert("You must enter full information");
                    }
                    if((Subject3.getText().toString().isEmpty()&&!Teacher3.getText().toString().isEmpty())||
                            (!Subject3.getText().toString().isEmpty()&&Teacher3.getText().toString().isEmpty()))
                    {
                        showAlert("You must enter full information");
                    }
                    if((Subject4.getText().toString().isEmpty()&&!Teacher4.getText().toString().isEmpty())||
                            (!Subject4.getText().toString().isEmpty()&&Teacher4.getText().toString().isEmpty()))
                    {
                        showAlert("You must enter full information");
                    }
                }
                return true;
            case R.id.menu_restore:
                // TODO restore to default
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void showAlert(String value)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(value);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
