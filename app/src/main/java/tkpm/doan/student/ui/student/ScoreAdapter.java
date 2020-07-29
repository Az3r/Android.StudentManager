package tkpm.doan.student.ui.student;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import java.util.List;

import tkpm.doan.student.data.models.Score;
import tkpm.doan.student.ui.components.ImmutableAdapter;

public class ScoreAdapter extends ImmutableAdapter<Score> {

    public ScoreAdapter(@NonNull Context context, int layoutResource, @NonNull List<Score> list) {
        super(context, layoutResource, list);
    }

    @Override
    protected void bind(@NonNull View view, @NonNull Score item) {

    }
}
