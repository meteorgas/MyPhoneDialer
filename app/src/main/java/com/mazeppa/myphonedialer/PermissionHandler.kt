package com.mazeppa.myphonedialer

import android.Manifest
import android.content.Intent
import android.os.Build
import android.os.Environment
import android.provider.Settings
import androidx.activity.result.ActivityResultLauncher
import androidx.core.net.toUri

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
}