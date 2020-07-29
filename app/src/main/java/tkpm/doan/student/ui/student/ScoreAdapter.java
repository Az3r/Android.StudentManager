package tkpm.doan.student.ui.student;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import java.util.List;

import tkpm.doan.student.data.models.Score;
import tkpm.doan.student.ui.components.AbstractViewHolder;
import tkpm.doan.student.ui.components.ImmutableAdapter;

public class ScoreAdapter extends ImmutableAdapter<Score> {

    public ScoreAdapter(@NonNull Context context, @NonNull List<Score> list) {
        super(context, list);
    }

    @NonNull
    @Override
    public AbstractViewHolder<Score> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AbstractViewHolder<Score> holder, int position) {

    }
}
