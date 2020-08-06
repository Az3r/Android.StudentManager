package tkpm.doan.student.ui.components.utils;

import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import tkpm.doan.student.R;

public class RecyclerViews {
    public static void setupListView(@NonNull RecyclerView recyclerView) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext());
        DividerItemDecoration decoration = new DividerItemDecoration(recyclerView.getContext(), layoutManager.getOrientation());

        LayoutAnimationController animationController = AnimationUtils.loadLayoutAnimation(recyclerView.getContext(), R.anim.layout_animation);
        recyclerView.setLayoutAnimation(animationController);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(decoration);
    }

    public static void setupGridView(@NonNull RecyclerView recyclerView, int spanCount) {
        GridLayoutManager layoutManager = new GridLayoutManager(recyclerView.getContext(), spanCount);
        LayoutAnimationController animationController = AnimationUtils.loadLayoutAnimation(recyclerView.getContext(), R.anim.layout_animation);
        recyclerView.setLayoutAnimation(animationController);
        recyclerView.setLayoutManager(layoutManager);
    }
}
