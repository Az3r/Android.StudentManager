package tkpm.doan.student.ui.components.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import java.util.List;

import tkpm.doan.student.R;
import tkpm.doan.student.data.models.Comment;
import tkpm.doan.student.databinding.ItemCommentBinding;
import tkpm.doan.student.ui.MainActivity;
import tkpm.doan.student.ui.student.StudentFragmentDirections;

public class CommentAdapter extends ImmutableAdapter<Comment> {

    private class ViewHolder extends  AbstractViewHolder<Comment> {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void bind(Comment item) {
            ItemCommentBinding binding = ItemCommentBinding.bind(itemView);
            ImageView avatarTeacher = binding.avatarTeacher;
            TextView commentContent =binding.commentContent;
            TextView  commentTeacher=binding.commentTeacher;
            TextView commentDate =binding.commentDate;

            //avatarTeacher.setImageBitmap(item.getTeacher().getAvatar());
            commentContent.setText(item.getContent());
            commentTeacher.setText(item.getTeacher().getFirstName()+" "+
                    item.getTeacher().getMidleName()+" "+
                    item.getTeacher().getLastName());
            commentDate.setText(item.getTimeComment().toString());

            itemView.setOnClickListener(v -> {
                // chuyen qua mn hinh chi tiet comment

            });
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
