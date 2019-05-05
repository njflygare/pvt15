package com.example.kulturkul;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);

        navView.setOnNavigationItemSelectedListener(this);

        // Laddar home som default onCreate
        loadFragment(new HomeFragment());
    }

    private boolean loadFragment(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Fragment fragment = null;

        switch(menuItem.getItemId()) {
            case R.id.navigation_event:
                fragment = new EventFragment();
                break;

            case R.id.navigation_search:
                fragment = new SearchFragment();
                break;

            case R.id.navigation_home:
                fragment = new HomeFragment();
                break;

            case R.id.navigation_profile:
                fragment = new ProfileFragment();
                break;

            case R.id.navigation_notifications:
                fragment = new NotificationsFragment();
                break;

        }
        return loadFragment(fragment);
    }
}
