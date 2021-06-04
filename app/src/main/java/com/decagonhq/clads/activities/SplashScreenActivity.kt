package com.decagonhq.clads.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
