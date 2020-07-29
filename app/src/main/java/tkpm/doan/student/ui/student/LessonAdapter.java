package tkpm.doan.student.ui.student;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import java.util.List;

import tkpm.doan.student.data.models.Lesson;
import tkpm.doan.student.ui.components.AbstractViewHolder;
import tkpm.doan.student.ui.components.ImmutableAdapter;

public class LessonAdapter extends ImmutableAdapter<Lesson> {

    public static class ViewHolder extends AbstractViewHolder<Lesson> {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void bind(Lesson item) {

        }
    }

    public LessonAdapter(@NonNull Context context, @NonNull List<Lesson> list) {
        super(context, list);
    }

    @NonNull
    @Override
    public AbstractViewHolder<Lesson> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AbstractViewHolder<Lesson> holder, int position) {

        holder.bind(getItem(position));
    }
}
