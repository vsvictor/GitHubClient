package com.education.githubclient

import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import android.view.Menu
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.education.githubclient.databinding.ActivityMainBinding
import com.education.githubclient.model.MainModel
import kotlinx.android.synthetic.main.app_bar_main.view.*

class MainActivity : BaseActivity(){
    private val TAG = MainActivity::class.java.simpleName
    private lateinit var mainModel : MainModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binder : ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainModel = ViewModelProviders.of(this).get(MainModel::class.java)
        setSupportActionBar(binder.drawerLayout.toolbar)
        val toggle = ActionBarDrawerToggle(this, binder.drawerLayout, binder.drawerLayout.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        binder.drawerLayout.addDrawerListener(toggle)
        binder.drawerLayout.addDrawerListener(mainModel)
        toggle.syncState()
        binder.mainModel = mainModel
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
