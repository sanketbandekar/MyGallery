package com.example.mygallery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.mygallery.Fragments.AboutFragment;
import com.example.mygallery.Fragments.HomeFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        frameLayout = findViewById(R.id.frameLayout);

        setUpToolbar();

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new HomeFragment()).commit();
        getSupportActionBar().setTitle("Home");

        actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this,drawerLayout,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        actionBarDrawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(item -> {
            item.setChecked(true);

            switch (item.getItemId()){

                case R.id.item_home:{
                    getSupportFragmentManager().beginTransaction().addToBackStack("Home").replace(R.id.frameLayout, new HomeFragment()).commit();
                    getSupportActionBar().setTitle("Home");
                    drawerLayout.closeDrawers();
                    break;
                }
                case R.id.item_about:{
                    Toast.makeText(MainActivity.this,"Clicked About", Toast.LENGTH_SHORT).show();
                    getSupportFragmentManager().beginTransaction().addToBackStack("About").replace(R.id.frameLayout, new AboutFragment()).commit();
                    getSupportActionBar().setTitle("About");
                    drawerLayout.closeDrawers();
                    break;
                }

            }

            return true;
        });
    }

    public void setUpToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Task App");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
