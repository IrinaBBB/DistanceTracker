package ru.irinavb.distancetrackerapp.util

import android.Manifest
import android.content.Context
import android.os.Build
import androidx.fragment.app.Fragment
import com.vmadalin.easypermissions.EasyPermissions
import ru.irinavb.distancetrackerapp.util.Constants.BACKGROUND_LOCATION_PERMISSION_REQUEST_CODE
import ru.irinavb.distancetrackerapp.util.Constants.LOCATION_PERMISSIONS_REQUEST_CODE

object Permissions {

    fun hasLocationPermissions(context: Context) =
        EasyPermissions.hasPermissions(
            context,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION
        )

    fun requestLocationPermission(fragment: Fragment) {
        EasyPermissions.requestPermissions(
            fragment,
            "This application cannot work without Location Permissions",
            LOCATION_PERMISSIONS_REQUEST_CODE,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION
        )
    }

    fun hasBackgroundLocationPermission(context: Context): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            return EasyPermissions.hasPermissions(
                context,
                Manifest.permission.ACCESS_BACKGROUND_LOCATION
            )
        }
        return true
    }

    fun requestBackgroundLocationPermission(fragment: Fragment) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            EasyPermissions.requestPermissions(
                fragment,
                "Background location permission is essential to this application. Without it we " +
                        "will not be able to provide you with our service",
                BACKGROUND_LOCATION_PERMISSION_REQUEST_CODE,
                Manifest.permission.ACCESS_BACKGROUND_LOCATION
            )
        }
    }
}