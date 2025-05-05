package com.mazeppa.myphonedialer

import android.os.Build
import android.telecom.Connection
import android.telecom.ConnectionRequest
import android.telecom.ConnectionService
import android.telecom.PhoneAccountHandle
import android.telecom.TelecomManager

class MyConnectionService : ConnectionService() {
    override fun onCreateOutgoingConnection(
        connectionManagerPhoneAccount: PhoneAccountHandle,
        request: ConnectionRequest
    ): Connection {
        return MyConnection().apply {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                connectionProperties = Connection.PROPERTY_SELF_MANAGED
            }
            setCallerDisplayName("My Dialer", TelecomManager.PRESENTATION_ALLOWED)
            setAddress(request.address, TelecomManager.PRESENTATION_ALLOWED)
            setInitialized()
        }
    }
}