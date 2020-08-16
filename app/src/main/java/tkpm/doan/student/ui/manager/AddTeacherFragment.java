package tkpm.doan.student.ui.manager;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.textfield.TextInputEditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import tkpm.doan.student.R;
import tkpm.doan.student.data.models.RequestStudent;
import tkpm.doan.student.data.models.RequestTeacher;
import tkpm.doan.student.data.models.Subject;
import tkpm.doan.student.databinding.FragmentAddStudentBinding;
import tkpm.doan.student.databinding.FragmentAddTeacherBinding;
import tkpm.doan.student.ui.MainActivity;
import tkpm.doan.student.ui.components.constants.Keys;

public class AddTeacherFragment extends Fragment {
    private FragmentAddTeacherBinding binding;
    private ManagerViewModel viewModel;
    private TextInputEditText FirstName;
    private TextInputEditText MiddleName;
    private TextInputEditText LastName;
    private TextInputEditText BirthDay;
    private TextInputEditText Address;
    private TextInputEditText Phone;
    private TextInputEditText Email;
    private AppCompatAutoCompleteTextView Subject;
    private AppCompatAutoCompleteTextView Gender;
    private List<tkpm.doan.student.data.models.Subject> subjectList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAddTeacherBinding.inflate(inflater, container, false);
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
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.action_edit, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       viewModel= new ViewModelProvider(requireActivity()).get(ManagerViewModel.class);
        Subject= binding.teacherSubject;
        FirstName=binding.teacherFirstName;
        MiddleName=binding.teacherMiddleName;
        LastName=binding.teacherLastName;
        Gender= binding.teacherGender;
        Phone= binding.teacherPhone;
        Address= binding.teacherAddress;
        Email= binding.teacherEmail;
        BirthDay= binding.teacherBirthday;
        viewModel.GetAllSubject(Keys.year).observe(getViewLifecycleOwner(), list->{
            subjectList= list;
            List<String> data = new ArrayList<>();
            for (int i=0;i<list.size();i++)
            {
                data.add(list.get(i).getSubjectName());
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(requireActivity(), R.layout.textview, R.id.textview, data);
            Subject.setAdapter(adapter);
        });
        String a[] = new String[] { "Nam", "Nữ" };
        // getting the list view of Array
        List<String> list = Arrays.asList(a);
        ArrayAdapter<String> adaptergender = new ArrayAdapter<>(requireActivity(), R.layout.textview, R.id.textview, list);
        Gender.setAdapter(adaptergender);

        binding.buttonAddImage.setOnClickListener(v -> {
            // TODO select an image from gallery
        });
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_submit:
                if(Subject.getText().toString().isEmpty()||FirstName.getText().toString().isEmpty()||
                        MiddleName.getText().toString().isEmpty()||LastName.getText().toString().isEmpty()||
                        Gender.getText().toString().isEmpty()||BirthDay.getText().toString().isEmpty()||
                        Phone.getText().toString().isEmpty()||Email.getText().toString().isEmpty()||
                        Address.getText().toString().isEmpty())
                {
                    Toast.makeText(getContext(),R.string.need_content_notify, Toast.LENGTH_LONG);
                }
                else {
                    try {
                        RequestTeacher student= new RequestTeacher();
                        student.setAddress(Address.getText().toString());
                        for(int i=0;i<subjectList.size();i++)
                        {
                            if(subjectList.get(i).getSubjectName().contains(Subject.getText().toString()))
                            {
                                student.setSubjectId(subjectList.get(i).getSubjectId());
                                break;
                            }
                        }
                        student.setEmail(Email.getText().toString());
                        student.setFirstName(FirstName.getText().toString());
                        student.setMiddleName(MiddleName.getText().toString());
                        student.setLastName(LastName.getText().toString());
                        student.setAddress(Address.getText().toString());
                        student.setPhoneNumber(Phone.getText().toString());
                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                        String dateInString = BirthDay.getText().toString();
                        Date date = formatter.parse(dateInString);
                        formatter= new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                        String value= formatter.format(date);
                        formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                        date = formatter.parse(value);
                        if(Gender.getText().toString().contains("Nam"))
                            student.setIsMale(1);
                        else
                            student.setIsMale(0);
                        student.setBirthday(date);
                        viewModel.PostTeacher(student).observe(getViewLifecycleOwner(),responseBody -> {
                            if(responseBody!=null)
                            {
                                Toast.makeText(getContext(), R.string.add_student_success, Toast.LENGTH_SHORT).show();
                                MainActivity mainActivity = (MainActivity) requireActivity();
                                mainActivity.getNavController().navigateUp();
                            }
                            else
                                Toast.makeText(getContext(), R.string.add_student_fail, Toast.LENGTH_SHORT).show();

                        });
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                return true;

            case R.id.menu_restore:
                binding.teacherFirstName.getText().clear();
                binding.teacherMiddleName.getText().clear();
                binding.teacherLastName.getText().clear();
                binding.teacherGender.getText().clear();
                binding.teacherSubject.getText().clear();
                binding.teacherBirthday.getText().clear();
                binding.teacherAddress.getText().clear();
                binding.teacherEmail.getText().clear();
                binding.teacherPhone.getText().clear();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
