package tkpm.doan.student.ui.components.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import java.util.List;

import tkpm.doan.student.R;
import tkpm.doan.student.data.models.Comment;

public class CommentAdapter extends ImmutableAdapter<Comment> {

    private class ViewHolder extends  AbstractViewHolder<Comment> {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void bind(Comment item) {

        }
    }

    public CommentAdapter(@NonNull Context context, @NonNull List<Comment> list) {
        super(context, list);
    }

    @NonNull
    @Override
    public AbstractViewHolder<Comment> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment, parent,false);
        return new ViewHolder(itemView);
    }
}
