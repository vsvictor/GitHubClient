package com.education.githubclient.model

import android.app.Application
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.databinding.ObservableField
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.AndroidViewModel
import com.education.githubclient.R

class MainModel(val app : Application) : AndroidViewModel(app), DrawerLayout.DrawerListener {
    private val TAG = MainModel::class.java.simpleName
    val appTitle : ObservableField<String> = ObservableField(app.getString(R.string.menu_home))
    val drawerState : ObservableField<OnDrawerState> = ObservableField()

    fun onNavigationClick(item: MenuItem): Boolean {
        when (item.getItemId()) {
            R.id.nav_home -> {
                this.appTitle.set(app.getString(R.string.menu_home))
                drawerState.set(OnDrawerState.CLOSE)
                Log.i(TAG, app.getString(R.string.menu_home))
                return true
            }
            R.id.nav_follow -> {
                this.appTitle.set(app.getString(R.string.menu_follow))
                drawerState.set(OnDrawerState.CLOSE)
                Log.i(TAG, app.getString(R.string.menu_follow))
                return true
            }
            R.id.nav_profile -> {
                this.appTitle.set(app.getString(R.string.menu_profile))
                drawerState.set(OnDrawerState.CLOSE)
                Log.i(TAG, app.getString(R.string.menu_profile))
                return true
            }
        }

        return false
    }

    override fun onDrawerStateChanged(newState: Int) {
        Log.i(TAG, "State:"+newState)
    }
    override fun onDrawerSlide(drawerView: View, slideOffset: Float) {}
    override fun onDrawerClosed(drawerView: View) {
        Log.i(TAG, "State:"+"opended")
        this.drawerState.set(OnDrawerState.CLOSE)
    }
    override fun onDrawerOpened(drawerView: View) {
        Log.i(TAG, "State:"+"closed")
        this.drawerState.set(OnDrawerState.OPEN)
    }
}