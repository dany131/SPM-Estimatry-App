package com.example.estimatry.estimation_techniques

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.estimatry.R

class Details : AppCompatActivity() {

    lateinit var toolbar_details: androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        toolbar_details = findViewById(R.id.toolbar_details)
        toolbar_details.setNavigationIcon(R.drawable.nav_icon_black)
        toolbar_details.title = "Details"
        toolbar_details.setTitleTextColor(Color.WHITE)
        toolbar_details.setNavigationOnClickListener {
            onBackPressed()

        }
    }
}