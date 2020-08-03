package tkpm.doan.student.ui.components.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import java.util.List;

import tkpm.doan.student.R;
import tkpm.doan.student.data.models.Score;
import tkpm.doan.student.databinding.ItemScoreBinding;
import tkpm.doan.student.ui.MainActivity;
import tkpm.doan.student.ui.student.StudentFragmentDirections;

public class ScoreAdapter extends ImmutableAdapter<Score> {

    private class ViewHolder extends AbstractViewHolder<Score> {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void bind(Score item) {
            ItemScoreBinding binding = ItemScoreBinding.bind(itemView);
            TextView Subject = binding.Subject;
            TextView scoreFactor1 = binding.scoreFactor1;
            TextView scoreFactor2 = binding.scoreFactor2;
            TextView scoreFactor3 = binding.scoreFactor3;
            TextView scoreAverage = binding.scoreAverage;

            Subject.setText(item.getSubjectName());
            scoreFactor1.setText(item.getTest15().toString());
            scoreFactor2.setText(item.getTest45().toString());
            scoreFactor3.setText("" + item.getTestFinal());
            scoreAverage.setText("" + item.getFinal());
            itemView.setOnClickListener(v -> {
                // chuyen qua mn hinh chi tiet diem
            });
        }
    }

    public ScoreAdapter(@NonNull Context context, @NonNull List<Score> list) {
        super(context, list);
    }

    @NonNull
    @Override
    public AbstractViewHolder<Score> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_score, parent, false);
        return new ViewHolder(itemView);
    }


}
