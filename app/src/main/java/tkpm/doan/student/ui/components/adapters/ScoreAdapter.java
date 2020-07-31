package tkpm.doan.student.ui.components.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import java.util.List;

import tkpm.doan.student.R;
import tkpm.doan.student.data.models.Score;

public class ScoreAdapter extends ImmutableAdapter<Score> {

    private class ViewHolder extends AbstractViewHolder<Score> {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void bind(Score item) {

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
