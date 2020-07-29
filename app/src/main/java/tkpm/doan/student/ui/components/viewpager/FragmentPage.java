package tkpm.doan.student.ui.components.viewpager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class FragmentPage {
    @NonNull
    private Fragment fragment;

    @NonNull
    private String label;

    private int icon;

    public FragmentPage(@NonNull Fragment fragment, @NonNull String label, int icon) {
        this.fragment = fragment;
        this.label = label;
        this.icon = icon;
    }

    @NonNull
    public String getLabel() {
        return label;
    }

    public int getIcon() {
        return icon;
    }

    @NonNull
    public Fragment getFragment() {
        return fragment;
    }
}
