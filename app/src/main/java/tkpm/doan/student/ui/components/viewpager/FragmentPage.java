package tkpm.doan.student.ui.components.viewpager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class FragmentPage {
    @NonNull
    private Fragment fragment;

    private int icon;

    public FragmentPage(@NonNull Fragment fragment, int icon) {
        this.fragment = fragment;
        this.icon = icon;
    }

    public int getIcon() {
        return icon;
    }

    @NonNull
    public Fragment getFragment() {
        return fragment;
    }
}
