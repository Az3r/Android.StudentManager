package tkpm.doan.student.ui.manager;

import android.os.Bundle;
import android.view.LayoutInflater;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

import tkpm.doan.student.R;
import tkpm.doan.student.data.models.Notification;
import tkpm.doan.student.data.models.RequestNotify;
import tkpm.doan.student.databinding.FragmentCreateNotifyBinding;
import tkpm.doan.student.ui.MainActivity;
import tkpm.doan.student.ui.components.constants.Keys;
import tkpm.doan.student.ui.student.StudentViewModel;

public class EditNotifyFragment extends Fragment {
    private FragmentCreateNotifyBinding binding;
    private ManagerViewModel viewModel;
    private TextInputEditText Tag;
    private TextInputEditText Title;
    private TextInputEditText Content;
    private AppCompatAutoCompleteTextView Class;
    private Notification notifySelected=null;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCreateNotifyBinding.inflate(inflater, container, false);
        return binding.getRoot();
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
        Class= binding.notifyClass;
        Tag= binding.notifyTag;
        Content= binding.notifyContent;
        Title= binding.notifyTitle;
        viewModel.getSelectedNotify().observe(getViewLifecycleOwner(), notification -> {
            this.notifySelected= notification;
            Class.setText(notification.getClassId());
            Title.setText(notification.getTitle());
            Content.setText(notification.getContent());
        });
        viewModel.GetAllClass(Keys.year).observe(getViewLifecycleOwner(),list->{
            List<String> data = new ArrayList<>();
            for (int i=0;i<list.size();i++)
                data.add(list.get(i).getClassName());
            ArrayAdapter<String> adapter = new ArrayAdapter<>(requireActivity(), R.layout.textview, R.id.textview, data);
            Class.setAdapter(adapter);
        });
        viewModel = new ViewModelProvider(requireActivity()).get(ManagerViewModel.class);
        binding.buttonRestore.setOnClickListener(v -> {
            binding.notifyTag.getText().clear();
            binding.notifyClass.getText().clear();
            binding.notifyContent.getText().clear();
            binding.notifyTitle.getText().clear();
        });

        binding.buttonSubmit.setOnClickListener(v -> {
            if(Class.getText().toString().isEmpty()||Title.getText().toString().isEmpty()
            ||Content.getText().toString().isEmpty())
            {
                Toast.makeText(getContext(),R.string.need_content_notify, Toast.LENGTH_LONG);
            }
            else {
                AtomicBoolean IsFailure = new AtomicBoolean(true);
                RequestNotify notify = new RequestNotify();
                if(Class.getText().toString().contains("All"))
                    notify.setClassId("FULL");
                notify.setClassId(Class.getText().toString());
                notify.setContent(Content.getText().toString());
                notify.setTitle(Title.getText().toString());
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                Date date = new Date();
                formatter= new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                String value= formatter.format(date);
                formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                try {
                    date = formatter.parse(value);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                notify.setCreatedOn(date);
                if(notifySelected==null)
                {
                    viewModel.PostNotify(notify).observe(getViewLifecycleOwner(), responseBody -> {
                        if(responseBody!=null)
                        {
                            Toast.makeText(getContext(), R.string.add_notify_success, Toast.LENGTH_SHORT).show();
                            MainActivity mainActivity = (MainActivity) requireActivity();
                            mainActivity.getNavController().navigateUp();
                        }
                        else
                            Toast.makeText(getContext(), R.string.add_notify_fail, Toast.LENGTH_SHORT).show();
                    });
                }else
                {
                    notify.setNotificationId(notifySelected.getNotificationId());
                    viewModel.UpdateNotify(notify).observe(getViewLifecycleOwner(), responseBody -> {
                        if(responseBody!=null)
                        {
                            Toast.makeText(getContext(), R.string.add_notify_success, Toast.LENGTH_SHORT).show();
                            MainActivity mainActivity = (MainActivity) requireActivity();
                            mainActivity.getNavController().navigateUp();
                        }
                        else
                            Toast.makeText(getContext(), R.string.add_notify_fail, Toast.LENGTH_SHORT).show();
                    });
                }

            }
        });
    }
}
