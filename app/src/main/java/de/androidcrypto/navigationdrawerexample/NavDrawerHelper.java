package de.androidcrypto.navigationdrawerexample;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class NavDrawerHelper extends ContextWrapper {

    // code from https://stackoverflow.com/a/48159830 by seekingStillness

    public NavDrawerHelper(Context context){
        super(context);
    }

    public void initNav(final DrawerLayout drawerLayout, NavigationView navigationView, Toolbar toolbar, final boolean isFinish){

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id){
                    case R.id.nav_home:
                        startActivity(new Intent(getBaseContext(), MainActivity.class));
                        if (isFinish) ((Activity)getBaseContext()).finish();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.nav_settings:
                        startActivity(new Intent(getBaseContext(), SettingsActivity.class));
                        if (isFinish) ((Activity)getBaseContext()).finish();
                        drawerLayout.closeDrawers();
                        break;
                }
                return true;
            }
        });

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(((Activity)getBaseContext()),drawerLayout,toolbar,R.string.nav_open,R.string.nav_close){
            @Override
            public void onDrawerClosed(View v){
                super.onDrawerClosed(v);
            }
            @Override
            public void onDrawerOpened(View v) {
                super.onDrawerOpened(v);
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }
}
