package com.decagonhq.clads.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.decagonhq.clads.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {

    private lateinit var dashBoardActivityBinding: ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dashBoardActivityBinding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(dashBoardActivityBinding.root)
    }
}
