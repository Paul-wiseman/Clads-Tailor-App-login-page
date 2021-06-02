package com.decagonhq.clads

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.decagonhq.clads.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {
    // Declare binding variable
    private var _binding: ActivitySplashScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Handler and Runnable execute in UIThread (don`t block main thread)
        Handler(Looper.getMainLooper()).postDelayed(
            {
                val intent = Intent(this, CladsActivity::class.java)
                startActivity(intent)
                finish()
            },
            1500
        )
    }
}
