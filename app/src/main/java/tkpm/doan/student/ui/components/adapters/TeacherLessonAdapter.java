package tkpm.doan.student.ui.components.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import java.util.List;

import tkpm.doan.student.R;
import tkpm.doan.student.data.models.Lesson;

public class TeacherLessonAdapter extends ImmutableAdapter<Lesson> {
    public static class ViewHolder extends AbstractViewHolder<Lesson> {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void bind(Lesson item) {

        }
    }

    public TeacherLessonAdapter(@NonNull Context context, @NonNull List<Lesson> list) {
        super(context, list);
    }
    @NonNull
    @Override
    public AbstractViewHolder<Lesson> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_schedule_detail, parent, false);
        return new ViewHolder(itemView);
    }
}
