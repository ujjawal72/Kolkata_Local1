package com.example.login_activity.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.login_activity.Fragments.HelpLine_Fragment;
import com.example.login_activity.Fragments.Logout_Fragment;
import com.example.login_activity.Fragments.Map_Fragment;
import com.example.login_activity.Fragments.Pnr_Check_Fragment;
import com.example.login_activity.Fragments.Rail_Tour_Fragment;
import com.example.login_activity.Fragments.Rules_Fragment;
import com.example.login_activity.Fragments.Train_Search_Fragment;
import com.example.login_activity.R;
import com.google.android.material.navigation.NavigationView;

public class DrawerActivity extends AppCompatActivity  {

    DrawerLayout drawerLayout;
    CoordinatorLayout coordinatorLayout;
    FrameLayout frameLayout;
    androidx.appcompat.widget.Toolbar toolbar;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        drawerLayout = findViewById(R.id.drawerLayout);
        coordinatorLayout = findViewById(R.id.coordinatorLayout);
        frameLayout = findViewById(R.id.frame);
        toolbar = findViewById(R.id.toolbar1);
        navigationView = findViewById(R.id.NavigationView);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("KolkataSub");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        openTrainSearch();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.item_Home:
                        openTrainSearch();
                        break;

                    case R.id.item_Location:
                        FragmentTransaction transaction_Location=getSupportFragmentManager().beginTransaction();
                        transaction_Location.add(R.id.frame,new Map_Fragment());
                        transaction_Location.commit();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case  R.id.item_Rail_Tour:
                        FragmentTransaction transaction_Tour=getSupportFragmentManager().beginTransaction();
                        transaction_Tour.add(R.id.frame,new Rail_Tour_Fragment());
                        transaction_Tour.commit();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case  R.id.item_Helpline:
                        //Toast.makeText(getApplicationContext(),"HelpLine Pressed",Toast.LENGTH_SHORT).show();
                        FragmentTransaction transaction_Help=getSupportFragmentManager().beginTransaction();
                        transaction_Help.replace(R.id.frame,new HelpLine_Fragment());
                        transaction_Help.commit();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;


                    case R.id.item_Rules:
                        FragmentTransaction transaction_Rules=getSupportFragmentManager().beginTransaction();
                        transaction_Rules.add(R.id.frame,new Rules_Fragment());
                        transaction_Rules.commit();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.item_Logout:
                        FragmentTransaction transaction_Logout=getSupportFragmentManager().beginTransaction();
                        transaction_Logout.add(R.id.frame,new Logout_Fragment());
                        transaction_Logout.commit();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.item_Pnr:
                        FragmentTransaction transaction_Pnr=getSupportFragmentManager().beginTransaction();
                        transaction_Pnr.add(R.id.frame,new Pnr_Check_Fragment());
                        transaction_Pnr.commit();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                }
                return false;
            }
        });

    }

    private void openTrainSearch() {

        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frame,new Train_Search_Fragment());
        transaction.commit();
        drawerLayout.closeDrawer(GravityCompat.START);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}
