package tkpm.doan.student.ui.components;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import tkpm.doan.student.R;
import tkpm.doan.student.data.models.Schedule;
import tkpm.doan.student.ui.MainActivity;

/**
 * Abstract adapter whose collection is immutable
 */
public abstract class ImmutableAdapter<T> extends BaseAdapter {

    @NonNull
    protected final List<T> list;

    protected int layoutResource;

    @NonNull
    protected final Context context;

    public ImmutableAdapter(@NonNull Context context, int layoutResource, @NonNull List<T> list) {
        this.context = context;
        this.list = list;
        this.layoutResource = layoutResource;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public T getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return list.get(i).hashCode();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null)
            view = LayoutInflater.from(context).inflate(layoutResource, viewGroup, false);

        bind(view, getItem(i));

        return view;
    }

    protected abstract void bind(@NonNull View view,@NonNull T item);
}
