package com.example.estimatry.estimation_techniques

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.estimatry.R

class FpaResults : AppCompatActivity() {

    lateinit var toolbar_fpa_results: androidx.appcompat.widget.Toolbar
    lateinit var ufpAnswer: TextView
    lateinit var cafAnswer: TextView
    lateinit var fpAnswer: TextView

    var ufp: String = ""
    var caf: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fpa_results)

        ufp = intent.getStringExtra("UFP").toString()
        caf = intent.getStringExtra("CAF").toString()

        toolbar_fpa_results = findViewById(R.id.toolbar_fpa_results)

        ufpAnswer = findViewById(R.id.ufptextanswer)
        cafAnswer = findViewById(R.id.caftextanswer)
        fpAnswer = findViewById(R.id.fptextanswer)

        ufpAnswer.text = ufp
        cafAnswer.text = caf

        var fpcalculation = ufp.toInt() * caf.toDouble()

        fpAnswer.text = fpcalculation.toString()

        toolbar_fpa_results.setNavigationIcon(R.drawable.nav_icon_black)
        toolbar_fpa_results.title = "Functional Point Analysis"
        toolbar_fpa_results.setTitleTextColor(Color.WHITE)
        toolbar_fpa_results.setNavigationOnClickListener {
            onBackPressed()

        }
    }
}