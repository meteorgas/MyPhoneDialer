package com.mazeppa.myphonedialer

import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.mazeppa.myphonedialer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val permissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) {}

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonRequestPermissions.setOnClickListener {
            PermissionHandler.requestPermissions(permissionLauncher = permissionLauncher)
            PermissionHandler.checkAndRequestDefaultDialer(
                activity = this@MainActivity,
                packageName = packageName
            )
        }
    }
}