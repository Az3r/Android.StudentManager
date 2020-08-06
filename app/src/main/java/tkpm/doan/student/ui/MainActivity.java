package tkpm.doan.student.ui;

import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Arrays;
import java.util.Collections;

import dagger.hilt.android.AndroidEntryPoint;
import tkpm.doan.student.R;
import tkpm.doan.student.databinding.ActivityMainBinding;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private NavController navController;
    private BottomNavigationView bottomNav;
    private AppBarLayout appBar;
    private Toolbar toolbar;
    private CollapsingToolbarLayout collapseToolbar;
    private ImageView appBarImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        bottomNav = binding.appbarLayout.bottomNav;
        appBar = binding.appbarLayout.appBar;
        toolbar = binding.appbarLayout.toolbar;
        collapseToolbar = binding.appbarLayout.collapseToolbar;
        appBarImage = binding.appbarLayout.appBarImage;


        NavHostFragment hostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host);
        assert hostFragment != null;
        navController = hostFragment.getNavController();


    }

    private void setupBottomNav(BottomNavigationView bottomNav, NavController navController, AppBarConfiguration configuration) {
        NavigationUI.setupWithNavController(bottomNav, navController);
    }

    private void setupToolbar(AppBarLayout appBar, NavController navController, AppBarConfiguration appBarConfiguration) {
        setSupportActionBar(toolbar);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp() || super.onSupportNavigateUp();
    }
}
