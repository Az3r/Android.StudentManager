package tkpm.doan.student.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import dagger.hilt.android.AndroidEntryPoint;
import tkpm.doan.student.R;
import tkpm.doan.student.databinding.ActivityMainBinding;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

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

        binding.navView.setNavigationItemSelectedListener(item -> false);

        appBarConfiguration = new AppBarConfiguration
                .Builder(R.id.nav_student_score_list, R.id.nav_student_schedule_list, R.id.nav_profile)
                .setOpenableLayout(binding.drawerLayout)
                .build();

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
        NavigationUI.setupWithNavController(binding.appbarLayout.bottomNav, navController);
    }

    private void setupToolbar(Toolbar toolbar, NavController navController, AppBarConfiguration appBarConfiguration) {
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController,appBarConfiguration) || super.onSupportNavigateUp();
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
    public NavigationView getNavView() {
        return binding.navView;
    }

    @NonNull
    public NavController getNavController() {
        return navController;
    }

    public void setupBottomNav(int menuId) {
        BottomNavigationView bottomNav = binding.appbarLayout.bottomNav;
        bottomNav.setVisibility(View.VISIBLE);
        bottomNav.getMenu().clear();
        bottomNav.inflateMenu(R.menu.nav_student);
    }
}
