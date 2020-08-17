package tkpm.doan.student.ui.components.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import tkpm.doan.student.R;
import tkpm.doan.student.data.models.ClassName;
import tkpm.doan.student.data.models.Session;
import tkpm.doan.student.data.models.Teacher;
import tkpm.doan.student.databinding.ItemEditScheduleBinding;
import tkpm.doan.student.databinding.ItemNotificationMasterBinding;
import tkpm.doan.student.ui.MainActivity;
import tkpm.doan.student.ui.manager.ManagerViewModel;
import tkpm.doan.student.ui.manager.NotifyListFragmentDirections;

public class ScheduleItemAdapter extends ImmutableAdapter<Session> {
    private ManagerViewModel viewModel;
    List<View> viewList= new ArrayList<>();
    TextView period;
    TextInputLayout inputSubject;
    TextInputLayout inputTeacher;
    TextView time;
    AutoCompleteTextView Subject;
    AutoCompleteTextView Teacher;
    public List<View> GetView()
    {
        return viewList;
    }
    private class ViewHolder extends AbstractViewHolder<Session> {
        ArrayAdapter<String> adapter;
        ArrayAdapter<String> adapter1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void bind(Session item) {
            ItemEditScheduleBinding binding = ItemEditScheduleBinding.bind(itemView);
            viewModel = new ViewModelProvider((MainActivity) getContext()).get(ManagerViewModel.class);
            period= binding.tiethoc;
            time= binding.thoigian;
            Subject= binding.Subject;
            inputTeacher=binding.inputTeacher;
            Teacher= binding.teacher;
            List<String> data = new ArrayList<>();
            for (int i=0;i<item.getList().size();i++)
            {
                data.add(item.getList().get(i).getSubjectName());
            }
            adapter= new ArrayAdapter<>(getContext(), R.layout.textview, R.id.textview, data);
            Subject.setAdapter(adapter);
            adapter.notifyDataSetChanged();
            Teacher.setOnTouchListener(new View.OnTouchListener() {
                @SuppressLint("ClickableViewAccessibility")
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    String source= Subject.getText().toString();
                    return true;
                }
            });
            inputTeacher.setEndIconOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String source= Subject.getText().toString();
                    for (int i=0;i<item.getList().size();i++)
                    {
                        String dest=item.getList().get(i).getSubjectName();
                        if(dest.contains(source))
                        {
                            List<String> data1 = new ArrayList<>();
                            List<tkpm.doan.student.data.models.Teacher> value = item.getList().get(i).getTeachers();
                            for (int j=0;j<value.size();j++)
                            {
                                String name= value.get(j).getLastName()+" "
                                        +value.get(j).getMiddleName()+" "
                                        +value.get(j).getFirstName();
                                data1.add(name);
                            }
                            adapter1 = new ArrayAdapter<>(getContext(), R.layout.textview, R.id.textview, data1);
                            Teacher.setAdapter(adapter1);
                            break;
                        }
                    }
                }
            });
        }
    }
    public ScheduleItemAdapter(@NonNull Context context, @NonNull List<Session> list) {
        super(context, list);
    }
    @NonNull
    @Override
    public AbstractViewHolder<Session> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_edit_schedule, parent, false);
        viewList.add(itemView);
        return new ScheduleItemAdapter.ViewHolder(itemView);
    }
}