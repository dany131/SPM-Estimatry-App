package com.example.estimatry.estimation_techniques

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.estimatry.R
import com.google.android.material.textfield.TextInputEditText

class Cocomo2 : AppCompatActivity() {

    lateinit var toolbar_cocomo2: androidx.appcompat.widget.Toolbar

    lateinit var radioVeryLow: RadioButton
    lateinit var radioLow: RadioButton
    lateinit var radioNominal: RadioButton
    lateinit var radioHigh: RadioButton
    lateinit var radioVeryHigh: RadioButton

    lateinit var reuse: TextInputEditText
    lateinit var number_of_screens: TextInputEditText
    lateinit var number_of_views: TextInputEditText
    lateinit var number_of_reports: TextInputEditText
    lateinit var number_of_sections: TextInputEditText
    lateinit var server_datatables: TextInputEditText
    lateinit var client_dataTables: TextInputEditText
    lateinit var server_datatables_for_reports: TextInputEditText
    lateinit var client_datatables_for_reports: TextInputEditText
    lateinit var cocomo2Answer: TextView

    lateinit var cocomo2Calculate: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cocomo2)

        toolbar_cocomo2 = findViewById(R.id.toolbar_cocomo2)
        toolbar_cocomo2.setNavigationIcon(R.drawable.nav_icon_black)
        toolbar_cocomo2.title = "Cocomo II"
        toolbar_cocomo2.setTitleTextColor(Color.WHITE)
        toolbar_cocomo2.setNavigationOnClickListener {
            onBackPressed()

        }

        radioVeryLow = findViewById(R.id.radio_very_low)
        radioLow = findViewById(R.id.radio_low)
        radioNominal = findViewById(R.id.radio_nominal)
        radioHigh = findViewById(R.id.radio_high)
        radioVeryHigh = findViewById(R.id.radio_very_high)

        reuse = findViewById(R.id.reuse_data)
        number_of_screens = findViewById(R.id.number_of_screens_data)
        number_of_views = findViewById(R.id.number_of_views_data)
        number_of_reports = findViewById(R.id.number_of_reports_data)
        number_of_sections = findViewById(R.id.number_of_sections_data)
        server_datatables = findViewById(R.id.server_datatables_data)
        client_dataTables = findViewById(R.id.client_dataTables_data)
        server_datatables_for_reports = findViewById(R.id.server_datatables_for_reports_data)
        client_datatables_for_reports = findViewById(R.id.client_datatables_for_reports_data)

        cocomo2Calculate = findViewById(R.id.cocomo2_calculate)

        cocomo2Answer = findViewById(R.id.cocomo2_answer)

        radioVeryLow.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { compoundButton, b ->
            if (b) {
                radioVeryLow.isChecked = true
                radioLow.isChecked = false
                radioNominal.isChecked = false
                radioHigh.isChecked = false
                radioVeryHigh.isChecked = false
            }
        })

        radioLow.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { compoundButton, b ->
            if (b) {
                radioVeryLow.isChecked = false
                radioLow.isChecked = true
                radioNominal.isChecked = false
                radioHigh.isChecked = false
                radioVeryHigh.isChecked = false
            }
        })

        radioNominal.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { compoundButton, b ->
            if (b) {
                radioVeryLow.isChecked = false
                radioLow.isChecked = false
                radioNominal.isChecked = true
                radioHigh.isChecked = false
                radioVeryHigh.isChecked = false
            }
        })

        radioHigh.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { compoundButton, b ->
            if (b) {
                radioVeryLow.isChecked = false
                radioLow.isChecked = false
                radioNominal.isChecked = false
                radioHigh.isChecked = true
                radioVeryHigh.isChecked = false
            }
        })

        radioVeryHigh.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { compoundButton, b ->
            if (b) {
                radioVeryLow.isChecked = false
                radioLow.isChecked = false
                radioNominal.isChecked = false
                radioHigh.isChecked = false
                radioVeryHigh.isChecked = true
            }
        })

        cocomo2Calculate.setOnClickListener {
            if (!validation()) {
                Toast.makeText(applicationContext, "Fields are empty", Toast.LENGTH_SHORT).show()
            } else {
                calculateEffort()
            }
        }


    }

    private fun validation(): Boolean {

        val reuse = reuse.text.toString().trim { it <= ' ' }
        val number_of_screens = number_of_screens.text.toString().trim { it <= ' ' }
        val number_of_views = number_of_views.text.toString().trim { it <= ' ' }
        val number_of_reports = number_of_reports.text.toString().trim { it <= ' ' }
        val number_of_sections = number_of_sections.text.toString().trim { it <= ' ' }
        val server_datatables = server_datatables.text.toString().trim { it <= ' ' }
        val client_dataTables = client_dataTables.text.toString().trim { it <= ' ' }
        val server_datatables_for_reports =
            server_datatables_for_reports.text.toString().trim { it <= ' ' }
        val client_datatables_for_reports =
            client_datatables_for_reports.text.toString().trim { it <= ' ' }


        return !(reuse.isEmpty() or number_of_screens.isEmpty() or number_of_views.isEmpty()
                or number_of_reports.isEmpty() or number_of_sections.isEmpty() or server_datatables.isEmpty()
                or client_dataTables.isEmpty() or server_datatables_for_reports.isEmpty() or client_datatables_for_reports.isEmpty())
    }

    private fun productivity(): Int {
        return when {
            radioVeryLow.isChecked -> {
                4
            }
            radioLow.isChecked -> {
                7
            }
            radioNominal.isChecked -> {
                13
            }
            radioHigh.isChecked -> {
                25
            }
            radioVeryHigh.isChecked -> {
                50
            }
            else -> {
                0
            }
        }
    }

    private fun reuseValid(): Boolean {
        return reuse.text.toString().toInt() <= 100
    }

    private fun screenComplexity(): String {
        if (number_of_views.text.toString().toInt() < 3) {
            if (server_datatables.text.toString().toInt() < 2 && client_dataTables.text.toString()
                    .toInt() < 3
            ) {
                return "Simple"
            } else if (server_datatables.text.toString()
                    .toInt() >= 2 || server_datatables.text.toString().toInt() <= 3
            ) {
                if (client_dataTables.text.toString()
                        .toInt() >= 3 || client_dataTables.text.toString().toInt() <= 5
                )
                    return "Simple"
            } else if (server_datatables.text.toString()
                    .toInt() > 3 && client_dataTables.text.toString().toInt() > 5
            ) {
                return "Medium"
            }
        } else if (number_of_views.text.toString().toInt() == 3 || number_of_views.text.toString()
                .toInt() <= 7
        ) {
            if (server_datatables.text.toString().toInt() < 2 && client_dataTables.text.toString()
                    .toInt() < 3
            ) {
                return "Simple"
            } else if (server_datatables.text.toString()
                    .toInt() >= 2 || server_datatables.text.toString().toInt() <= 3
            ) {
                if (client_dataTables.text.toString()
                        .toInt() >= 3 || client_dataTables.text.toString().toInt() <= 5
                )
                    return "Medium"
            } else if (server_datatables.text.toString()
                    .toInt() > 3 && client_dataTables.text.toString().toInt() > 5
            ) {
                return "Difficult"
            }
        } else if (number_of_views.text.toString().toInt() > 8) {
            if (server_datatables.text.toString().toInt() < 2 && client_dataTables.text.toString()
                    .toInt() < 3
            ) {
                return "Medium"
            } else if (server_datatables.text.toString()
                    .toInt() >= 2 || server_datatables.text.toString().toInt() <= 3
            ) {
                if (client_dataTables.text.toString()
                        .toInt() >= 3 || client_dataTables.text.toString().toInt() <= 5
                )
                    return "Difficult"
            } else if (client_dataTables.text.toString()
                    .toInt() > 3 && client_dataTables.text.toString().toInt() > 5
            ) {
                return "Difficult"
            }
        }
        return ""
    }

    private fun reportComplexity(): String {
        if (number_of_sections.text.toString().toInt() == 0 || number_of_sections.text.toString()
                .toInt() == 1
        ) {
            if (server_datatables_for_reports.text.toString()
                    .toInt() < 2 && client_datatables_for_reports.text.toString().toInt() < 3
            ) {
                return "Simple";
            } else if (server_datatables_for_reports.text.toString()
                    .toInt() >= 2 || server_datatables_for_reports.text.toString().toInt() <= 3
            ) {
                if (client_datatables_for_reports.text.toString()
                        .toInt() >= 3 || client_datatables_for_reports.text.toString().toInt() <= 5
                )
                    return "Simple";
            } else if (server_datatables_for_reports.text.toString()
                    .toInt() > 3 && client_datatables_for_reports.text.toString().toInt() > 5
            ) {
                return "Medium";
            }
        } else if (number_of_sections.text.toString()
                .toInt() == 2 || number_of_sections.text.toString().toInt() == 3
        ) {
            if (server_datatables_for_reports.text.toString()
                    .toInt() < 2 && client_datatables_for_reports.text.toString().toInt() < 3
            ) {
                return "Simple";
            } else if (server_datatables_for_reports.text.toString()
                    .toInt() >= 2 || server_datatables_for_reports.text.toString().toInt() <= 3
            ) {
                if (client_datatables_for_reports.text.toString()
                        .toInt() >= 3 || client_datatables_for_reports.text.toString().toInt() <= 5
                )
                    return "Medium";
            } else if (server_datatables_for_reports.text.toString()
                    .toInt() > 3 && client_datatables_for_reports.text.toString().toInt() > 5
            ) {
                return "Difficult";
            }
        } else if (number_of_sections.text.toString().toInt() >= 4) {
            if (server_datatables_for_reports.text.toString()
                    .toInt() < 2 && client_datatables_for_reports.text.toString().toInt() < 3
            ) {
                return "Medium";
            } else if (server_datatables_for_reports.text.toString()
                    .toInt() >= 2 || server_datatables_for_reports.text.toString().toInt() <= 3
            ) {
                if (client_datatables_for_reports.text.toString()
                        .toInt() >= 3 || client_datatables_for_reports.text.toString().toInt() <= 5
                )
                    return "Difficult";
            } else if (server_datatables_for_reports.text.toString()
                    .toInt() > 3 && client_datatables_for_reports.text.toString().toInt() > 5
            ) {
                return "Difficult";
            }
        }
        return ""
    }

    private fun screenComplexityWeight(): Int {
        return when {
            screenComplexity() == "Simple" -> {
                1
            }
            screenComplexity() == "Medium" -> {
                2
            }
            screenComplexity() == "Difficult" -> {
                3
            }
            else -> {
                0
            }
        }
    }

    private fun reportComplexityWeight(): Int {
        return when {
            reportComplexity() == "Simple" -> {
                2;
            }
            reportComplexity() == "Medium" -> {
                5;
            }
            reportComplexity() == "Difficult" -> {
                8;
            }
            else -> {
                0
            }
        }
    }

    private fun objectPointCount(): Int {
        return if (reportComplexityWeight() > 0 && screenComplexityWeight() > 0) {
            val objectPoint = number_of_reports.text.toString()
                .toInt() * reportComplexityWeight() + number_of_screens.text.toString()
                .toInt() * screenComplexityWeight();
            objectPoint
        } else {
            0
        }
    }

    private fun calculateNOP(): Double {
        val NOP: Double = (objectPointCount() * (100 - reuse.text.toString().toDouble())) / 100
        return NOP
    }

    private fun calculateEffort() {

        if (reuseValid() && productivity() > 0) {
            var answer = calculateNOP() / productivity()

            val roundedAnswer = String.format("%.2f", answer)
            cocomo2Answer.text = "Effort: $roundedAnswer"


        } else if (productivity() <= 0) {
            Toast.makeText(
                applicationContext,
                "Please determine developer's experience",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            Toast.makeText(
                applicationContext,
                "Reuse Percentage should not be greater than 100",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}