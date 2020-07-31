package tkpm.doan.student.ui.student;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Hashtable;

import tkpm.doan.student.R;
import tkpm.doan.student.databinding.FragmentStudentBinding;

public class StudentFragment extends Fragment {


    private static final String TAG = "StudentFragment";
    private Hashtable<Integer, Fragment> destinations = new Hashtable<>();
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

        setupBottomNav(binding.bottomNav, getLocalNavController(binding.studentNavHost));
    }

    private NavController getLocalNavController(FragmentContainerView studentNavHost) {
        NavHostFragment localNavHost = (NavHostFragment) getChildFragmentManager().findFragmentById(R.id.student_nav_host);

        assert localNavHost != null;
        return localNavHost.getNavController();
    }

    private void setupBottomNav(BottomNavigationView bottomNav, NavController navController) {
        bottomNav.setOnNavigationItemSelectedListener(item -> {
            Fragment fragment = destinations.get(item.getItemId());
            if (fragment == null) {
                switch (item.getItemId()) {
                    case R.id.menu_student_profile:
                        fragment = new ProfileFragment();
                        break;
                    case R.id.menu_student_notification:
                        fragment = new NotificationFragment();
                        break;
                    case R.id.menu_student_schedule:
                        fragment = new ScheduleFragment();
                        break;
                    case R.id.menu_student_score:
                        fragment = new ScoreFragment();
                        break;
                    default:
                        throw new UnsupportedOperationException("Cannot find fragment for item");
                }
                destinations.put(item.getItemId(), fragment);
            }

            navigate(item.getItemId(), navController);
            return true;
        });
    }

    private void navigate(int menuItemId, NavController navController) {
        int destination;
        switch (menuItemId) {
            case R.id.menu_student_notification:
                destination = R.id.notificationFragment;
                break;
            case R.id.menu_student_profile:
                destination = R.id.profileFragment;
                break;
            case R.id.menu_student_schedule:
                destination = R.id.scheduleFragment;
                break;
            case R.id.menu_student_score:
                destination = R.id.scoreFragment;
                break;
            default:
                throw new IllegalArgumentException("No destination fragment found");
        }
        navController.navigate(destination);
    }
}
