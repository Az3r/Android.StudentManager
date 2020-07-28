package tkpm.doan.student.ui.student;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import java.util.List;

import tkpm.doan.student.data.models.Lesson;
import tkpm.doan.student.ui.components.ImmutableAdapter;

public class LessonAdapter extends ImmutableAdapter<Lesson> {

    public LessonAdapter(@NonNull Context context, int layoutResource, @NonNull List<Lesson> list) {
        super(context, layoutResource, list);
    }

    @Override
    protected void bind(@NonNull View view, @NonNull Lesson item) {

    }
}
