package com.mazeppa.myphonedialer

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Context.TELECOM_SERVICE
import android.content.Intent
import android.os.Build
import android.telecom.TelecomManager
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.core.content.ContextCompat.startActivity

object PermissionHandler {

    fun requestPermissions(
        permissionLauncher: ActivityResultLauncher<Array<String>>,
    ) {
        val permissionsToRequest = mutableListOf(
            Manifest.permission.READ_CALL_LOG,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.CALL_PHONE,
            Manifest.permission.READ_CONTACTS,
        )

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            permissionsToRequest.add(Manifest.permission.ANSWER_PHONE_CALLS)
        }

        permissionLauncher.launch(permissionsToRequest.toTypedArray())
    }

    fun checkAndRequestDefaultDialer(
        activity: Activity,
        packageName: String
    ) {
        val telecomManager = activity.getSystemService(TELECOM_SERVICE) as TelecomManager
        val currentPackageName = packageName

        if (telecomManager.defaultDialerPackage != currentPackageName) {
            val intent = Intent(TelecomManager.ACTION_CHANGE_DEFAULT_DIALER).apply {
                putExtra(
                    TelecomManager.EXTRA_CHANGE_DEFAULT_DIALER_PACKAGE_NAME,
                    currentPackageName
                )
            }
            activity.startActivity(intent)
        } else {
            Toast.makeText(activity, "Already default dialer", Toast.LENGTH_SHORT).show()
        }
    }
}