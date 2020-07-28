package tkpm.doan.student.ui.student;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import tkpm.doan.student.data.models.Student;
import tkpm.doan.student.ui.components.FragmentPage;

public class StudentPageAdapter extends FragmentStateAdapter {

    private static final String TAG = "StudentPageAdapter";

    @NonNull
    private List<FragmentPage> pages;

    public StudentPageAdapter(@NonNull Fragment fragment, @NonNull List<FragmentPage> pages) {
        super(fragment);
        this.pages = pages;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return pages.get(position).getFragment();
    }

    @Override
    public int getItemCount() {
        return pages.size();
    }
}
