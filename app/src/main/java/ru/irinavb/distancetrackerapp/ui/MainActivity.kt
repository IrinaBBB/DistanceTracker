package ru.irinavb.distancetrackerapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import ru.irinavb.distancetrackerapp.R
import ru.irinavb.distancetrackerapp.util.Permissions.hasLocationPermissions


class MainActivity : AppCompatActivity() {

    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        if (hasLocationPermissions(this)) {
            navController.navigate(R.id.action_permissionFragment_to_mapsFragment)
        }
    }
}