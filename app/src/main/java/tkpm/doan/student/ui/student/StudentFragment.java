package tkpm.doan.student.ui.student;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

import tkpm.doan.student.R;
import tkpm.doan.student.data.models.Student;
import tkpm.doan.student.ui.components.FragmentPage;

public class StudentFragment extends Fragment {

    private static final String TAG = "StudentFragment";
    private List<FragmentPage> pages;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_student, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // TODO get student from bundle
        Student student =null;
        pages = createPages(student);

        ViewPager2 viewpager = view.findViewById(R.id.viewpager);
        TabLayout tabLayout = view.findViewById(R.id.tablayout);

        viewpager.setAdapter(new StudentPageAdapter(this, pages));
        new TabLayoutMediator(tabLayout, viewpager, (tab, position) -> {
            FragmentPage item = pages.get(position);
            tab.setIcon(item.getIcon());
        }).attach();
    }

    private static List<FragmentPage> createPages(@NonNull Student student) {
        return Arrays.asList(
                new FragmentPage(ProfileFragment.newInstance(student), R.drawable.ic_account),
                new FragmentPage(ScheduleFragment.newInstance(student), R.drawable.ic_schedule)
        );
    }
}
