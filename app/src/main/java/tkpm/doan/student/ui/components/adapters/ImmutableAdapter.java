package tkpm.doan.student.ui.components.adapters;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Filter;

/**
 * Abstract adapter whose collection is immutable
 */
public abstract class ImmutableAdapter<T> extends RecyclerView.Adapter<AbstractViewHolder<T>> {

    @NonNull
    private List<T> list;

    @NonNull
    private Context context;

    public ImmutableAdapter(@NonNull Context context, @NonNull List<T> list) {
        this.context = context;
        this.list = list;
    }

    public T getItem(int i) {
        return list.get(i);
    }

    @NonNull
    public Context getContext() {
        return context;
    }

    @NonNull
    @Override
    public abstract AbstractViewHolder<T> onCreateViewHolder(@NonNull ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(@NonNull AbstractViewHolder<T> holder, int position) {
        holder.bind(getItem(position));
    }

    @Override
    public long getItemId(int i) {
        return list.get(i).hashCode();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
