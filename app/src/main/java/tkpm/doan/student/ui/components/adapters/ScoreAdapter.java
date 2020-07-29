package tkpm.doan.student.ui.components.adapters;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import java.util.List;

import tkpm.doan.student.data.models.Score;

public class ScoreAdapter extends ImmutableAdapter<Score> {

    public ScoreAdapter(@NonNull Context context, @NonNull List<Score> list) {
        super(context, list);
    }

    @NonNull
    @Override
    public AbstractViewHolder<Score> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }
}
