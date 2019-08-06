package com.education.githubclient.model;

import androidx.core.view.GravityCompat;
import androidx.databinding.BindingAdapter;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;

public class NavigationViewBinderAdapter {
    @BindingAdapter("onNavigationItemSelected")
    public static void setOnNavigationItemSelectedListener(NavigationView view, NavigationView.OnNavigationItemSelectedListener listener) {
        view.setNavigationItemSelectedListener(listener);
    }
    @BindingAdapter("state_drawer")
    public static void  setOnDrawerState(DrawerLayout drawer, OnDrawerState state){
        if(state == OnDrawerState.CLOSE){
            drawer.closeDrawer(GravityCompat.START);
        }else if(state == OnDrawerState.OPEN){
            drawer.openDrawer(GravityCompat.START);
        }
    }
}
