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

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Hashtable;

import tkpm.doan.student.R;

public class StudentFragment extends Fragment {
    private static final String TAG = "StudentFragment";
    private Hashtable<Integer, Fragment> fragments = new Hashtable<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_student, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        BottomNavigationView bottomNavigationView = view.findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this::onMenuItemSelected);
        bottomNavigationView.setSelectedItemId(R.id.menu_student_profile);

    }

    private boolean onMenuItemSelected(MenuItem item) {
        Fragment replacedFragment = fragments.get(item.getItemId());
        if (replacedFragment == null) {
            switch (item.getItemId()) {
                case R.id.menu_student_profile:
                    replacedFragment = ProfileFragment.newInstance(null);
                    break;
                case R.id.menu_student_schedule:
                    replacedFragment = ScheduleFragment.newInstance(null);
                    break;
                case R.id.menu_student_notification:
                case R.id.menu_student_score:
                    break;
                default:
                    Log.e(TAG, "Unable to create Fragment for selected bottom navigation item");
                    throw new IllegalArgumentException();
            }
            fragments.put(R.id.menu_student_profile, replacedFragment);

        }

        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, replacedFragment);
        transaction.commit();

        return true;
    }
}
