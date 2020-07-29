package tkpm.doan.student.ui.components;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class AbstractViewHolder<T> extends RecyclerView.ViewHolder {
    public AbstractViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public abstract void bind(T item);
}
