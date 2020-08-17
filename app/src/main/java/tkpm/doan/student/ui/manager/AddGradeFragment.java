package tkpm.doan.student.ui.manager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import tkpm.doan.student.R;
import tkpm.doan.student.data.models.ClassName;
import tkpm.doan.student.data.models.RequestClass;
import tkpm.doan.student.data.models.Room;
import tkpm.doan.student.data.models.Teacher;
import tkpm.doan.student.databinding.FragmentAddClassBinding;
import tkpm.doan.student.databinding.FragmentAddTeacherBinding;
import tkpm.doan.student.ui.components.constants.AppData;

public class AddGradeFragment extends Fragment {
    private FragmentAddClassBinding binding;
    private ManagerViewModel viewModel;
    private TextInputEditText Class;
    private AutoCompleteTextView Teacher;
    private AutoCompleteTextView Room;
    private List<ClassName> nameList;
    private List<tkpm.doan.student.data.models.Room> roomList;
    private List<tkpm.doan.student.data.models.Teacher> teachers;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAddClassBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    public boolean ContainsTeacher(String id)
    {
        for(int i=0;i<nameList.size();i++)
        {
            if(nameList.get(i).getPersonalInfoId()!=null)
                if(nameList.get(i).getPersonalInfoId().equals(id))
                return true;
        }
        return false;
    }
    public boolean ContainsClass(String id)
    {
        for(int i=0;i<nameList.size();i++)
        {
            if(nameList.get(i).getClassName()!=null)
                if(nameList.get(i).getClassName().toLowerCase().equals(id.toLowerCase()))
                    return true;
        }
        return false;
    }
    public boolean ContainsRoom(String id)
    {
        for(int i=0;i<nameList.size();i++)
        {
            if(nameList.get(i).getRoomId()!=null)
                if(nameList.get(i).getRoomId().equals(id))
                    return true;
        }
        return false;
    }
    public String GetRoomId(String name)
    {
        for(int i=0;i<roomList.size();i++)
            if(roomList.get(i).getRoomName().equals(name))
                return roomList.get(i).getRoomId();
        return null;
    }
    public String GetTeacherId(String name)
    {
        for(int i=0;i<teachers.size();i++)
        {
            String nameteacher= teachers.get(i).getLastName()+" "+
                    teachers.get(i).getMiddleName()+" "+
                    teachers.get(i).getFirstName();
            if(nameteacher.contains(name))
                return teachers.get(i).getTeacherId();
        }
        return null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel =  new ViewModelProvider(requireActivity()).get(ManagerViewModel.class);
        Class= binding.className;
        Teacher= binding.classTeacher;
        Room= binding.classRoom;
        viewModel.GetAllClass(AppData.getInstance().year).observe(getViewLifecycleOwner(), classNames -> {
            nameList= classNames;
            viewModel.GetAllTeacher().observe(getViewLifecycleOwner(),teacherList -> {
                teachers=teacherList;
                List<String> data = new ArrayList<>();
                for (int i=0;i<teacherList.size();i++)
                {
                    try {
                        if(!ContainsTeacher(teacherList.get(i).getTeacherId()))
                            data.add(teacherList.get(i).getLastName()+" "+
                                    teacherList.get(i).getMiddleName()+" "+
                                    teacherList.get(i).getFirstName());
                    }
                    catch (Exception e)
                    {

                    }
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(requireActivity(), R.layout.textview, R.id.textview, data);
                Teacher.setAdapter(adapter);
            });
            viewModel.GetSRoom().observe(getViewLifecycleOwner(), rooms -> {
                if(rooms!=null)
                {
                    roomList= rooms;
                    List<String> data = new ArrayList<>();
                    for (int i=0;i<rooms.size();i++)
                    {
                        if(!ContainsRoom(rooms.get(i).getRoomId()))
                            data.add(rooms.get(i).getRoomName());
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(requireActivity(), R.layout.textview, R.id.textview, data);
                    Room.setAdapter(adapter);
                }
            });
        });

        binding.buttonSubmit.setOnClickListener(v -> {
            // TODO submit class to database
            if(ContainsClass(Class.getText().toString().trim()))
                showAlert("Class has exist");
            else
            {
                RequestClass requestClass= new RequestClass();
                requestClass.setAcademicYear(AppData.getInstance().year);
                requestClass.setClassId(Class.getText().toString().trim());
                requestClass.setTeacherId(GetTeacherId(Teacher.getText().toString()));
                requestClass.setRoomId(GetRoomId(Room.getText().toString()));
                viewModel.PostClass(requestClass).observe(getViewLifecycleOwner(),responseBody -> {
                    if(responseBody!=null)
                    {
                        showAlert(getString(R.string.add_class_success));
                        Navigation.findNavController(binding.getRoot()).navigateUp();
                    }
                });
            }
        });
    }
    public void showAlert(String value) {
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
