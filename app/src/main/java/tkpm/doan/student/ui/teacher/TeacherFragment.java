package tkpm.doan.student.ui.teacher;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;

import java.util.Arrays;
import java.util.List;

import tkpm.doan.student.R;
import tkpm.doan.student.databinding.FragmentTeacherBinding;
import tkpm.doan.student.ui.components.utils.TabLayouts;
import tkpm.doan.student.ui.components.viewpager.FragmentPage;

public class TeacherFragment extends Fragment {

    private FragmentTeacherBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentTeacherBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupTabLayout(binding.includeLayout.tablayout, binding.includeLayout.viewpager);
    }

    private void setupTabLayout(TabLayout tablayout, ViewPager2 viewpager) {
        List<FragmentPage> pages = createPages();
        TabLayouts.setupTabLayout(tablayout, viewpager, this, pages).attach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private List<FragmentPage> createPages() {
        return Arrays.asList(
                new FragmentPage(new GradeFragment(), getString(R.string.text_class), R.drawable.ic_class),
                new FragmentPage(new ScheduleFragment(), getString(R.string.text_schedule), R.drawable.ic_schedule)
        );
    }
}
