package com.example.estimatry.estimation_techniques

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.estimatry.R
import com.google.android.material.textfield.TextInputEditText
import kotlin.time.seconds

class Fpa_caf : AppCompatActivity() {

    lateinit var toolbar_fpa_caf: androidx.appcompat.widget.Toolbar
    lateinit var button: Button

    lateinit var noinfluences: TextInputEditText
    lateinit var incidental: TextInputEditText
    lateinit var moderate: TextInputEditText
    lateinit var average: TextInputEditText
    lateinit var significant: TextInputEditText
    lateinit var essential: TextInputEditText

    var AdvId: String = ""
    var ufp: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fpa_caf)

        ufp = intent.getStringExtra("UFP").toString()


        toolbar_fpa_caf = findViewById(R.id.toolbar_fpa_caf)
        button = findViewById(R.id.btn_calculate)

        noinfluences = findViewById(R.id.no_influences_data)
        incidental = findViewById(R.id.incidental_data)
        moderate = findViewById(R.id.moderate_data)
        average = findViewById(R.id.average_data)
        significant = findViewById(R.id.significant_data)
        essential = findViewById(R.id.essential_data)


        toolbar_fpa_caf.setNavigationIcon(R.drawable.nav_icon_black)
        toolbar_fpa_caf.title = "Functional Point Analysis"
        toolbar_fpa_caf.setTitleTextColor(Color.WHITE)
        toolbar_fpa_caf.setNavigationOnClickListener {
            onBackPressed()
        }
        button.setOnClickListener {

            if (!validation()) {

            } else {
                if (totalLimit()) {

                    val intent = Intent(this@Fpa_caf, FpaResults::class.java)
                    intent.putExtra("CAF", calculation().toString())
                    intent.putExtra("UFP", ufp)
                    startActivity(intent)
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                }

            }

        }

    }

    private fun validation(): Boolean {

        val noInfluence = noinfluences.text.toString().trim { it <= ' ' }
        val incident = incidental.text.toString().trim { it <= ' ' }
        val mod = moderate.text.toString().trim { it <= ' ' }
        val avg = average.text.toString().trim { it <= ' ' }
        val sig = significant.text.toString().trim { it <= ' ' }
        val ess = essential.text.toString().trim { it <= ' ' }

        if (noInfluence.isEmpty() or incident.isEmpty() or mod.isEmpty()
            or avg.isEmpty() or sig.isEmpty() or ess.isEmpty()
        ) {
            Toast.makeText(applicationContext, "Please type '0' if none", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    private fun totalLimit(): Boolean {
        val totalCheck: Int = noinfluences.text.toString().toInt() + incidental.text.toString()
            .toInt() + moderate.text.toString().toInt() + average.text.toString()
            .toInt() + significant.text.toString().toInt() + essential.text.toString().toInt()

        if (totalCheck < 14 || totalCheck > 14) {
            Toast.makeText(
                applicationContext,
                "Sum of adjustment factors should be 14",
                Toast.LENGTH_SHORT
            ).show()
            return false
        }
        return true
    }

    private fun calculation(): Double {
        var totalnoinfluences: Int = noinfluences.text.toString().toInt() * 0

        var totalincidental: Int = incidental.text.toString().toInt() * 1

        var totalmoderate: Int = moderate.text.toString().toInt() * 2

        var totalaverage: Int = average.text.toString().toInt() * 3

        var totalsignificant: Int = significant.text.toString().toInt() * 4

        var totalessential: Int = essential.text.toString().toInt() * 5

        var sumOfAll =
            totalnoinfluences + totalincidental + totalmoderate + totalaverage + totalsignificant + totalessential

        var CAF: Double = 0.65 + (0.01 * sumOfAll)

        return CAF
    }
}