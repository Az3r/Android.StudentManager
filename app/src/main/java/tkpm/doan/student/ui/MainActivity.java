package tkpm.doan.student.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import dagger.hilt.android.AndroidEntryPoint;
import tkpm.doan.student.R;
import tkpm.doan.student.databinding.ActivityMainBinding;
import tkpm.doan.student.ui.components.constants.Keys;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ActivityMainBinding binding;
    private NavController navController;
    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.appbarLayout.toolbar;
        setSupportActionBar(toolbar);

        NavHostFragment hostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host);
        assert hostFragment != null;
        navController = hostFragment.getNavController();


        appBarConfiguration = new AppBarConfiguration
                .Builder(R.id.nav_student_score_list, R.id.nav_student_schedule_list, R.id.nav_student_notify_list,
                R.id.nav_teacher_grade_list, R.id.nav_teacher_schedule_list)
                .setOpenableLayout(binding.drawerLayout)
                .build();

        NavigationUI.setupWithNavController(binding.navView, navController);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.appbarLayout.bottomNav, navController);

//        binding.navView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp();
    }

    @NonNull
    public BottomNavigationView getBottomNav() {
        return binding.appbarLayout.bottomNav;
    }

    @NonNull
    public DrawerLayout getDrawerLayout() {
        return binding.drawerLayout;
    }

    @NonNull
    public NavController getNavController() {
        return navController;
    }

    public void setupBottomNav(int menuId) {
        BottomNavigationView bottomNav = binding.appbarLayout.bottomNav;
        bottomNav.setVisibility(View.VISIBLE);
        bottomNav.getMenu().clear();
        bottomNav.inflateMenu(menuId);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_sign_out:
                navController.navigate(R.id.login);
                return true;
        }
        return NavigationUI.onNavDestinationSelected(item, navController);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putBoolean(Keys.BUNDLE_BOTTOM_NAV_VISIBLE, binding.appbarLayout.bottomNav.getVisibility() != View.GONE);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        boolean bottonNavVisible = savedInstanceState.getBoolean(Keys.BUNDLE_BOTTOM_NAV_VISIBLE);
        binding.appbarLayout.bottomNav.setVisibility(bottonNavVisible ? View.VISIBLE : View.GONE);
    }
}
