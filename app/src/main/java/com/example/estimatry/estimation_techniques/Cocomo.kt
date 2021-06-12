package com.example.estimatry.estimation_techniques

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.*
import androidx.cardview.widget.CardView
import com.example.estimatry.R
import com.google.android.material.textfield.TextInputEditText
import kotlin.math.pow

class Cocomo : AppCompatActivity() {

    lateinit var toolbar_cocomo: androidx.appcompat.widget.Toolbar

    lateinit var radioOrganic: RadioButton
    lateinit var radioSemi: RadioButton
    lateinit var radioEmbedded: RadioButton

    lateinit var organicCard: CardView
    lateinit var semiCard: CardView
    lateinit var embeddedCard: CardView

    lateinit var organicKLOC: TextInputEditText
    lateinit var semiKLOC: TextInputEditText
    lateinit var embeddedKLOC: TextInputEditText

    lateinit var organicButton: Button
    lateinit var organicPM: TextView
    lateinit var organicDT: TextView

    lateinit var semiButton: Button
    lateinit var semiPM: TextView
    lateinit var semiDT: TextView

    lateinit var embeddedButton: Button
    lateinit var embeddedPM: TextView
    lateinit var embeddedDT: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cocomo)

        toolbar_cocomo = findViewById(R.id.toolbar_cocomo)

        radioOrganic = findViewById(R.id.radio_organic)
        radioSemi = findViewById(R.id.radio_semi)
        radioEmbedded = findViewById(R.id.radio_embedded)

        organicCard = findViewById(R.id.organic_card)
        semiCard = findViewById(R.id.semi_card)
        embeddedCard = findViewById(R.id.embedded_card)

        organicKLOC = findViewById(R.id.organic_kloc_data)
        organicButton = findViewById(R.id.organic_calculate)
        organicPM = findViewById(R.id.organic_pm)
        organicDT = findViewById(R.id.organic_dt)

        semiKLOC = findViewById(R.id.semi_kloc_data)
        semiButton = findViewById(R.id.semi_calculate)
        semiPM = findViewById(R.id.semi_pm)
        semiDT = findViewById(R.id.semi_dt)

        embeddedKLOC = findViewById(R.id.embedded_kloc_data)
        embeddedButton = findViewById(R.id.embedded_calculate)
        embeddedPM = findViewById(R.id.embedded_pm)
        embeddedDT = findViewById(R.id.embedded_dt)


        toolbar_cocomo.setNavigationIcon(R.drawable.nav_icon_black)
        toolbar_cocomo.title = "Cocomo"

        toolbar_cocomo.setTitleTextColor(Color.WHITE)
        toolbar_cocomo.setNavigationOnClickListener {
            onBackPressed()

        }

        organicButton.setOnClickListener {
            if (!organicValidate()) {
                Toast.makeText(applicationContext, "Please enter KLOC", Toast.LENGTH_SHORT).show()
            } else {
                calculateOrganic()
            }
        }

        semiButton.setOnClickListener {
            if (!semiValidate()) {
                Toast.makeText(applicationContext, "Please enter KLOC", Toast.LENGTH_SHORT).show()
            } else {
                calculateSemi()
            }
        }

        embeddedButton.setOnClickListener {
            if (!embeddedValidate()) {
                Toast.makeText(applicationContext, "Please enter KLOC", Toast.LENGTH_SHORT).show()
            } else {
                calculateEmbedded()
            }
        }

        radioOrganic.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { compoundButton, b ->
            if (b) {
                radioSemi.isChecked = false
                radioEmbedded.isChecked = false

                organicCard.visibility = View.VISIBLE
                semiCard.visibility = View.GONE
                embeddedCard.visibility = View.GONE
            }
        })

        radioSemi.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { compoundButton, b ->
            if (b) {
                radioOrganic.isChecked = false
                radioEmbedded.isChecked = false

                organicCard.visibility = View.GONE
                semiCard.visibility = View.VISIBLE
                embeddedCard.visibility = View.GONE
            }
        })

        radioEmbedded.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { compoundButton, b ->
            if (b) {
                radioSemi.isChecked = false
                radioOrganic.isChecked = false

                organicCard.visibility = View.GONE
                semiCard.visibility = View.GONE
                embeddedCard.visibility = View.VISIBLE
            }
        })

    }

    private fun organicValidate(): Boolean {
        val inputlow = organicKLOC.text.toString().trim { it <= ' ' }
        return !inputlow.isEmpty()
    }

    private fun semiValidate(): Boolean {
        val inputlow = semiKLOC.text.toString().trim { it <= ' ' }
        return !inputlow.isEmpty()
    }

    private fun embeddedValidate(): Boolean {
        val inputlow = embeddedKLOC.text.toString().trim { it <= ' ' }
        return !inputlow.isEmpty()

    }


    private fun calculateOrganic() {

        val calculatePmPower = organicKLOC.text.toString().toDouble().pow(1.05)
        var pm = 2.4 * calculatePmPower

        val calculateDtPower = pm.pow(0.38)
        var dt = 2.5 * calculateDtPower

        val roundedPM = String.format("%.3f", pm)
        val roundedDT = String.format("%.3f", dt)

        organicPM.text = "Persons-Month: $roundedPM"
        organicDT.text = "Development Time: $roundedDT"

    }

    private fun calculateSemi() {

        val calculatePmPower = semiKLOC.text.toString().toDouble().pow(1.12)
        var pm = 3.0 * calculatePmPower

        val calculateDtPower = pm.pow(0.35)
        var dt = 2.5 * calculateDtPower

        val roundedPM = String.format("%.3f", pm)
        val roundedDT = String.format("%.3f", dt)

        semiPM.text = "Persons-Month: $roundedPM"
        semiDT.text = "Development Time: $roundedDT"

    }

    private fun calculateEmbedded() {

        val calculatePmPower = embeddedKLOC.text.toString().toDouble().pow(1.20)
        var pm = 3.6 * calculatePmPower

        val calculateDtPower = pm.pow(0.32)
        var dt = 2.5 * calculateDtPower

        val roundedPM = String.format("%.3f", pm)
        val roundedDT = String.format("%.3f", dt)

        embeddedPM.text = "Persons-Month: $roundedPM"
        embeddedDT.text = "Development Time: $roundedDT"

    }

}