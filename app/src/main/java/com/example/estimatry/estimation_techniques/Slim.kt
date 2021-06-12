package com.example.estimatry.estimation_techniques

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.estimatry.R
import com.google.android.material.textfield.TextInputEditText
import kotlin.math.pow

class Slim : AppCompatActivity() {

    lateinit var toolbar_slim: androidx.appcompat.widget.Toolbar
    lateinit var loc: TextInputEditText
    lateinit var dt: TextInputEditText
    lateinit var tc: TextInputEditText
    lateinit var calculate: Button
    lateinit var slimAns: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slim)

        toolbar_slim = findViewById(R.id.toolbar_slim)

        loc = findViewById(R.id.slim_loc_data)
        dt = findViewById(R.id.slim_t_data)
        tc = findViewById(R.id.slim_c_data)
        calculate = findViewById(R.id.slim_calculate)
        slimAns = findViewById(R.id.slimanswer)

        toolbar_slim.setNavigationIcon(R.drawable.nav_icon_black)
        toolbar_slim.title = "SLIM"

        toolbar_slim.setTitleTextColor(Color.WHITE)
        toolbar_slim.setNavigationOnClickListener {
            onBackPressed()
        }
        calculate.setOnClickListener {
            if (!validate()) {
                Toast.makeText(applicationContext, "Fields are empty", Toast.LENGTH_SHORT).show()
            } else {
                calculateSlim()
            }
        }
    }

    private fun calculateSlim() {

        var doubleloc = loc.text.toString().toDouble()
        var doublec = tc.text.toString().toDouble()
        var doublet = dt.text.toString().toDouble()
        var power = 1.3333333333333333333333333333333

        var k0 = doublet.pow(power)
        var k1 = doublec * k0
        var k2 = (doubleloc / k1) * 3

        val roundedAns = String.format("%.2f", k2)


        slimAns.text = "Total Life Cycle Effort: $roundedAns"
    }

    private fun validate(): Boolean {
        val slimloc = loc.text.toString().trim { it <= ' ' }
        val slimdt = dt.text.toString().trim { it <= ' ' }
        val slimtc = tc.text.toString().trim { it <= ' ' }

        return !(slimloc.isEmpty() or slimdt.isEmpty() or slimtc.isEmpty())
    }
}