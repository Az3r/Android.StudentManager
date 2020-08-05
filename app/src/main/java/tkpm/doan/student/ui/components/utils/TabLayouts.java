package tkpm.doan.student.ui.components.utils;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.List;

import tkpm.doan.student.ui.components.viewpager.FragmentPage;
import tkpm.doan.student.ui.components.viewpager.PageAdapter;

public class TabLayouts {
    public static TabLayoutMediator setupTabLayout(@NonNull TabLayout tabLayout, @NonNull ViewPager2 viewPager, @NonNull Fragment owner,  @NonNull List<FragmentPage> pages) {
        viewPager.setAdapter(new PageAdapter(owner, pages));
        return new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            FragmentPage page = pages.get(position);
            tab.setIcon(page.getIcon());
        });
    }
}
