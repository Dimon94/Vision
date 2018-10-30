package com.dimon.vision

import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import com.dimon.vision.base.BaseActivity
import kotlinx.android.synthetic.main.home_activity.*

class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
        val navController = Navigation.findNavController(this, R.id.main_navigation_fragment)
        setupActionBarWithNavController(this, navController)
        NavigationUI.setupWithNavController(bottom_navigation_view, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this, R.id.main_navigation_fragment).navigateUp()
    }
}
