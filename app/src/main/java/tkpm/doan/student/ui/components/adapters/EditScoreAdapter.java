package tkpm.doan.student.ui.components.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import tkpm.doan.student.R;
import tkpm.doan.student.data.models.Student;
import tkpm.doan.student.databinding.ItemScoreEditorBinding;

public class EditScoreAdapter extends ImmutableAdapter<Student> {
    private TextView Name;
    private TextView Class;
    private TextInputEditText Score151;
    private TextInputEditText Score152;
    private TextInputEditText Score153;
    private TextInputEditText Score451;
    private TextInputEditText Score452;
    private TextInputEditText ScoreFinal;
    private List<View> view= new ArrayList<>();

    public List<View> getView(){
        return view;
    }

    private class ViewHolder extends AbstractViewHolder<Student> {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        @Override
        public void bind(Student item) {
            ItemScoreEditorBinding binding= ItemScoreEditorBinding.bind(itemView);
            Name= binding.studentName;
            Class= binding.studentClass;
            Score151= binding.score151;
            Score152= binding.score152;
            Score153= binding.score153;
            Score451= binding.score451;
            Score452= binding.score452;
            ScoreFinal= binding.scoreSemester;
            Name.setText(item.getLastName()+" "+ item.getMiddleName()+" "+item.getFirstName());
            Class.setText(item.getClassId());
            for(int i=0;i<item.getTest15().size();i++)
            {
                if(i==0)
                    Score151.setText(item.getTest15().get(i).toString());
                if(i==1)
                    Score152.setText(item.getTest15().get(i).toString());
                if(i==2)
                    Score153.setText(item.getTest15().get(i).toString());
            }
            for(int i=0;i<item.getTest45().size();i++)
            {
                if(i==0)
                    Score451.setText(item.getTest15().get(i).toString());
                if(i==1)
                    Score452.setText(item.getTest15().get(i).toString());
            }
            ScoreFinal.setText(""+item.getTestFinal());
        }
    }

    public EditScoreAdapter(@NonNull Context context, @NonNull List<Student> list) {
        super(context, list);
    }

    @NonNull
    @Override
    public AbstractViewHolder<Student> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_score_editor, parent, false);
        view.add(itemView);
        return new ViewHolder(itemView);
    }
}