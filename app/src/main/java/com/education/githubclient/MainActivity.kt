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
import com.education.githubclient.databinding.NavHeaderMainBinding
import com.education.githubclient.model.MainModel
import com.education.githubclient.model.MainViewModelFactory
import com.education.githubclient.model.User
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.view.*

class MainActivity : BaseActivity(){
    private val TAG = MainActivity::class.java.simpleName
    private lateinit var mainModel : MainModel
    private lateinit var binder : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val user = intent.getParcelableExtra<User>("user")
        binder = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainModel = ViewModelProviders.of(this, MainViewModelFactory(application, user)).get(MainModel::class.java)
        setSupportActionBar(binder.drawerLayout.toolbar)

        val viewHeader = nav_view.getHeaderView(0)
        val bindingHeader : NavHeaderMainBinding = NavHeaderMainBinding.bind(viewHeader)
        bindingHeader.mainModel = mainModel

        val toggle = ActionBarDrawerToggle(this, binder.drawerLayout, binder.drawerLayout.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        binder.drawerLayout.addDrawerListener(toggle)
        binder.drawerLayout.addDrawerListener(mainModel)
        toggle.syncState()
        binder.mainModel = mainModel
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = binder.drawerLayout
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
