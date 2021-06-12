package com.example.estimatry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.LinearLayout
import com.example.estimatry.estimation_techniques.*

class MainActivity : AppCompatActivity() {

    lateinit var cocomo: LinearLayout
    lateinit var cocomo2: LinearLayout
    lateinit var fpa: LinearLayout
    lateinit var slim: LinearLayout
    lateinit var ucp: LinearLayout
    lateinit var details: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)

        cocomo = findViewById(R.id.cocomo)
        cocomo2 = findViewById(R.id.cocomo2)
        fpa = findViewById(R.id.fpa)
        slim = findViewById(R.id.slim)
        ucp = findViewById(R.id.ucp)
        details = findViewById(R.id.details)

        cocomo.setOnClickListener {
            val intent = Intent(this@MainActivity, Cocomo::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        cocomo2.setOnClickListener {
            val intent = Intent(this@MainActivity, Cocomo2::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        fpa.setOnClickListener {
            val intent = Intent(this@MainActivity, Fpa::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        slim.setOnClickListener {
            val intent = Intent(this@MainActivity, Slim::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        ucp.setOnClickListener {
            val intent = Intent(this@MainActivity, Ucp::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        details.setOnClickListener {
            val intent = Intent(this@MainActivity, Details::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

    }


}