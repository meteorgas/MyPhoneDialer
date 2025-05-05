package com.mazeppa.myphonedialer
//
//import android.app.role.RoleManager
//import android.content.ComponentName
//import android.os.Build
//import android.os.Bundle
//import android.telecom.PhoneAccount
//import android.telecom.PhoneAccountHandle
//import android.telecom.TelecomManager
//import androidx.appcompat.app.AppCompatActivity
//
//class DialerActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_dialer)
//
//        val roleManager = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//            getSystemService(RoleManager::class.java)
//        } else {
//            TODO("VERSION.SDK_INT < Q")
//        }
//        if (roleManager.isRoleAvailable(RoleManager.ROLE_DIALER)) {
//            if (!roleManager.isRoleHeld(RoleManager.ROLE_DIALER)) {
//                val intent = roleManager.createRequestRoleIntent(RoleManager.ROLE_DIALER)
//                startActivityForResult(intent, 1001)
//            }
//        }
//
//        val telecomManager = getSystemService(TELECOM_SERVICE) as TelecomManager
//        val handle = PhoneAccountHandle(ComponentName(this, MyConnectionService::class.java), "MyPhoneID")
//        val phoneAccount = PhoneAccount.builder(handle, "My Phone")
//            .setCapabilities(PhoneAccount.CAPABILITY_CALL_PROVIDER)
//            .build()
//
//        telecomManager.registerPhoneAccount(phoneAccount)
//    }
//}