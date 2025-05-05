package com.mazeppa.myphonedialer

import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.mazeppa.myphonedialer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val permissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) {}
    private val startActivityForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {}

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListeners()
    }

    private fun setListeners() {
        binding.apply {
            buttonRequestPermissions.setOnClickListener {
                PermissionHandler.requestPermissions(permissionLauncher)
                PermissionHandler.requestDefaultPhoneApp(this@MainActivity, startActivityForResult)
            }
        }
    }
}