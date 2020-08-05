package tkpm.doan.student.ui.student;

import android.content.Context;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Arrays;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;
import tkpm.doan.student.R;
import tkpm.doan.student.databinding.FragmentStudentBinding;
import tkpm.doan.student.ui.components.adapters.ScoreAdapter;
import tkpm.doan.student.ui.components.constants.Keys;
import tkpm.doan.student.ui.components.viewpager.FragmentPage;
import tkpm.doan.student.ui.components.viewpager.PageAdapter;
import tkpm.doan.student.ui.components.viewpager.PageTransformer;

@AndroidEntryPoint
public class StudentFragment extends Fragment {

    private static final String TAG = "StudentFragment";
    private List<FragmentPage> pages;
    private FragmentStudentBinding binding;
    private StudentViewModel viewModel;

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
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        viewModel = new ViewModelProvider(requireActivity()).get(StudentViewModel.class);
        assert getArguments() != null;
        viewModel.setStudentId(getArguments().getString(Keys.STUDENT_ID));
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
                new FragmentPage(new ProfileFragment(), getString(R.string.text_profile), R.drawable.ic_account),
                new FragmentPage(new ScheduleFragment(), getString(R.string.text_schedule), R.drawable.ic_schedule),
                new FragmentPage(new ScoreFragment(), getString(R.string.text_score), R.drawable.ic_score),
                new FragmentPage(new NotificationFragment(), getString(R.string.text_notification), R.drawable.ic_notification)
        );
    }

    private void setupTabLayout(TabLayout tabLayout, ViewPager2 viewPager) {
        pages = createPages();
        viewPager.setPageTransformer(new PageTransformer());
        viewPager.setAdapter(new PageAdapter(this, pages));
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            FragmentPage item = pages.get(position);
            tab.setIcon(item.getIcon());
        }).attach();
    }

}
