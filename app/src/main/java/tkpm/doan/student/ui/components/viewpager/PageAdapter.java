package tkpm.doan.student.ui.components.viewpager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class PageAdapter extends FragmentStateAdapter {

    @NonNull
    private List<FragmentPage> pages;

    public PageAdapter(@NonNull Fragment fragment, @NonNull List<FragmentPage> pages) {
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
