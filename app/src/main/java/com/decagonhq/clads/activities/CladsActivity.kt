package com.decagonhq.clads.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.decagonhq.clads.databinding.ActivityCladsBinding

class CladsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityCladsBinding.inflate(layoutInflater).root)
    }
}
