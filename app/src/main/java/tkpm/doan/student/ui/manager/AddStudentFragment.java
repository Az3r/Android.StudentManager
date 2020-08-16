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

import java.io.IOException;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import tkpm.doan.student.R;
import tkpm.doan.student.data.models.RequestStudent;
import tkpm.doan.student.data.models.Student;
import tkpm.doan.student.databinding.FragmentAddStudentBinding;
import tkpm.doan.student.ui.MainActivity;
import tkpm.doan.student.ui.components.constants.Keys;
import tkpm.doan.student.ui.components.constants.Provider;

public class AddStudentFragment extends Fragment {
    private FragmentAddStudentBinding binding;
    private ManagerViewModel viewModel;
    private TextInputEditText FirstName;
    private TextInputEditText MiddleName;
    private TextInputEditText LastName;
    private TextInputEditText BirthDay;
    private TextInputEditText Address;
    private TextInputEditText Phone;
    private TextInputEditText Email;
    private AppCompatAutoCompleteTextView Class;
    private AppCompatAutoCompleteTextView Gender;
    private Student studentSelected= null;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAddStudentBinding.inflate(inflater, container, false);
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
        viewModel =  new ViewModelProvider(requireActivity()).get(ManagerViewModel.class);
        Class= binding.studentClass;
        FirstName=binding.studentFirstName;
        MiddleName=binding.studentMiddleName;
        LastName=binding.studentLastName;
        Gender= binding.studentGender;
        Phone= binding.studentPhone;
        Address= binding.studentAddress;
        Email= binding.studentEmail;
        BirthDay= binding.studentBirthday;
        viewModel.getSelectedStudent().observe(getViewLifecycleOwner(),student -> {
            this.studentSelected= student;
            Class.setText(student.getClassId());
            FirstName.setText(student.getFirstName());
            LastName.setText(student.getLastName());
            MiddleName.setText(student.getMiddleName());
            Phone.setText(student.getPhoneNumber());
            Email.setText(student.getEmail());
            Address.setText(student.getAddress());
            if(student.isMale())
                Gender.setText(R.string.male);
            else
                Gender.setText(R.string.female);
            BirthDay.setText(Provider.getDateFormat().format(student.getBirthday()));
        });
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
        String a[] = new String[] { getResources().getString(R.string.male),getResources().getString(R.string.female)};

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
                if(Class.getText().toString().isEmpty()||FirstName.getText().toString().isEmpty()||
                    MiddleName.getText().toString().isEmpty()||LastName.getText().toString().isEmpty()||
                    Gender.getText().toString().isEmpty()||BirthDay.getText().toString().isEmpty()||
                    Phone.getText().toString().isEmpty()||Email.getText().toString().isEmpty()||
                    Address.getText().toString().isEmpty())
                {
                    Toast.makeText(getContext(),R.string.need_content_notify, Toast.LENGTH_LONG);
                }
                else {
                    try {
                        RequestStudent student= new RequestStudent();
                        student.setAddress(Address.getText().toString());
                        student.setClassId(Class.getText().toString());
                        student.setEmail(Email.getText().toString());
                        student.setGraduated(1);
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
                        if(Gender.getText().toString().contains(getResources().getString(R.string.male)))
                            student.setMale(1);
                        else
                            student.setMale(0);
                        student.setBirthday(date);
                        if(this.studentSelected==null)
                        {
                            viewModel.PostStudent(student).observe(getViewLifecycleOwner(),responseBody -> {
                                if(responseBody!=null)
                                {
                                    Toast.makeText(getContext(), R.string.add_student_success, Toast.LENGTH_SHORT).show();
                                    MainActivity mainActivity = (MainActivity) requireActivity();
                                    mainActivity.getNavController().navigateUp();
                                }
                                else
                                    Toast.makeText(getContext(), R.string.add_student_fail, Toast.LENGTH_SHORT).show();
                            });
                        }
                        else
                        {
                            student.setStudentId(this.studentSelected.getStudentId());
                            viewModel.UpdateStudent(student).observe(getViewLifecycleOwner(),responseBody -> {
                                if(responseBody!=null)
                                {
                                    Toast.makeText(getContext(), R.string.add_student_success, Toast.LENGTH_SHORT).show();
                                    MainActivity mainActivity = (MainActivity) requireActivity();
                                    mainActivity.getNavController().navigateUp();
                                }
                                else
                                    Toast.makeText(getContext(), R.string.add_student_fail, Toast.LENGTH_SHORT).show();

                            });
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                return true;
            case R.id.menu_restore:
                binding.studentFirstName.getText().clear();
                binding.studentMiddleName.getText().clear();
                binding.studentLastName.getText().clear();
                binding.studentGender.getText().clear();
                binding.studentClass.getText().clear();
                binding.studentBirthday.getText().clear();
                binding.studentAddress.getText().clear();
                binding.studentEmail.getText().clear();
                binding.studentPhone.getText().clear();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
