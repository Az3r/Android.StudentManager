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
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Arrays;
import java.util.List;

import tkpm.doan.student.R;
import tkpm.doan.student.databinding.FragmentStudentBinding;
import tkpm.doan.student.ui.components.utils.TabLayouts;
import tkpm.doan.student.ui.components.viewpager.FragmentPage;
import tkpm.doan.student.ui.components.viewpager.PageAdapter;
import tkpm.doan.student.ui.components.viewpager.PageTransformer;
import tkpm.doan.student.ui.student.NotificationFragment;
import tkpm.doan.student.ui.student.ProfileFragment;
import tkpm.doan.student.ui.student.ScheduleFragment;
import tkpm.doan.student.ui.student.ScoreFragment;

public class StudentProfileFragment extends Fragment {
    private FragmentStudentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentStudentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewPager2 viewPager = binding.includeLayout.viewpager;
        TabLayout tabLayout = binding.includeLayout.tablayout;
        setupTabLayout(tabLayout, viewPager);
    }

    private List<FragmentPage> createPages() {
        return Arrays.asList(
                new FragmentPage(new EditStudentFragment(), getString(R.string.text_profile), R.drawable.ic_account),
                new FragmentPage(new ScoreEditorFragment(), getString(R.string.text_score), R.drawable.ic_score)
        );
    }

    private void setupTabLayout(TabLayout tabLayout, ViewPager2 viewPager) {
        TabLayouts.setupTabLayout(tabLayout,viewPager,this,createPages()).attach();
    }
}
