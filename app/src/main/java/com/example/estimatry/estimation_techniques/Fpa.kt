package com.example.estimatry.estimation_techniques

import android.content.Intent
import android.graphics.Color
import android.graphics.fonts.FontFamily
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.estimatry.R
import com.google.android.material.textfield.TextInputEditText

class Fpa : AppCompatActivity() {

    lateinit var toolbar_fpa: androidx.appcompat.widget.Toolbar
    lateinit var nextButton: Button

    lateinit var inputLow: TextInputEditText
    lateinit var inputAverage: TextInputEditText
    lateinit var inputHigh: TextInputEditText

    lateinit var outputLow: TextInputEditText
    lateinit var outputAverage: TextInputEditText
    lateinit var outputHigh: TextInputEditText

    lateinit var inquiriesLow: TextInputEditText
    lateinit var inquiriesAverage: TextInputEditText
    lateinit var inquiriesHigh: TextInputEditText

    lateinit var filesLow: TextInputEditText
    lateinit var filesAverage: TextInputEditText
    lateinit var filesHigh: TextInputEditText

    lateinit var interfaceLow: TextInputEditText
    lateinit var interfaceAverage: TextInputEditText
    lateinit var interfaceHigh: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fpa)

        // Toolbar
        toolbar_fpa = findViewById(R.id.toolbar_fpa)
        toolbar_fpa.setNavigationIcon(R.drawable.nav_icon_black)
        toolbar_fpa.title = "Functional Point Analysis"
        toolbar_fpa.setTitleTextColor(Color.WHITE)
        toolbar_fpa.setNavigationOnClickListener {
            onBackPressed()

        }

        nextButton = findViewById(R.id.btn_finish)

//        totalInput = findViewById(R.id.total_external_inputs_data)
        inputLow = findViewById(R.id.total_external_inputs_data_low)
        inputAverage = findViewById(R.id.total_external_inputs_data_average)
        inputHigh = findViewById(R.id.total_external_inputs_data_high)

//        totalOutput = findViewById(R.id.total_external_outputs_data)
        outputLow = findViewById(R.id.total_external_outputs_data_low)
        outputAverage = findViewById(R.id.total_external_outputs_data_average)
        outputHigh = findViewById(R.id.total_external_outputs_data_high)

//        totalInquiries = findViewById(R.id.total_external_inquiries_data)
        inquiriesLow = findViewById(R.id.total_external_inquiries_data_low)
        inquiriesAverage = findViewById(R.id.total_external_inquiries_data_average)
        inquiriesHigh = findViewById(R.id.total_external_inquiries_data_high)

//        totalFiles = findViewById(R.id.total_internal_files_data)
        filesLow = findViewById(R.id.total_internal_files_data_low)
        filesAverage = findViewById(R.id.total_internal_files_data_average)
        filesHigh = findViewById(R.id.total_internal_files_data_high)

//        totalInterface = findViewById(R.id.total_external_interfaces_data)
        interfaceLow = findViewById(R.id.total_external_interfaces_data_low)
        interfaceAverage = findViewById(R.id.total_external_interfaces_data_average)
        interfaceHigh = findViewById(R.id.total_external_interfaces_data_high)



        nextButton.setOnClickListener {
            if (!validation()) {
                Toast.makeText(applicationContext, "Please type '0' if none", Toast.LENGTH_SHORT)
                    .show()

            } else {
                Toast.makeText(
                    applicationContext,
                    inputCalculation().toString(),
                    Toast.LENGTH_SHORT
                )
                    .show()
//                val args = Bundle()
//                args.putString("UFP", inputCalculation().toString())

                val intent = Intent(this@Fpa, Fpa_caf::class.java)
                intent.putExtra("UFP", inputCalculation().toString())
                startActivity(intent)
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            }

        }
    }

    private fun validation(): Boolean {
//        val input = totalInput.text.toString().trim { it <= ' ' }
        val inputlow = inputLow.text.toString().trim { it <= ' ' }
        val inputavg = inputAverage.text.toString().trim { it <= ' ' }
        val inputhigh = inputHigh.text.toString().trim { it <= ' ' }

//        val output = totalOutput.text.toString().trim { it <= ' ' }
        val outputlow = outputLow.text.toString().trim { it <= ' ' }
        val outputavg = outputAverage.text.toString().trim { it <= ' ' }
        val outputhigh = outputHigh.text.toString().trim { it <= ' ' }

//        val inquiries = totalInquiries.text.toString().trim { it <= ' ' }
        val inquirieslow = inquiriesLow.text.toString().trim { it <= ' ' }
        val inquiriesavg = inquiriesAverage.text.toString().trim { it <= ' ' }
        val inquirieshigh = inquiriesHigh.text.toString().trim { it <= ' ' }

//        val files = totalFiles.text.toString().trim { it <= ' ' }
        val fileslow = filesLow.text.toString().trim { it <= ' ' }
        val filesavg = filesAverage.text.toString().trim { it <= ' ' }
        val fileshigh = filesHigh.text.toString().trim { it <= ' ' }

//        val interfaceinput = totalInterface.text.toString().trim { it <= ' ' }
        val interfacelow = interfaceLow.text.toString().trim { it <= ' ' }
        val interfaceavg = interfaceAverage.text.toString().trim { it <= ' ' }
        val interfacehigh = interfaceHigh.text.toString().trim { it <= ' ' }

        return !(inputlow.isEmpty() or inputavg.isEmpty() or inputhigh.isEmpty()
                or outputlow.isEmpty() or outputavg.isEmpty() or outputhigh.isEmpty()
                or inquirieslow.isEmpty() or inquiriesavg.isEmpty() or inquirieshigh.isEmpty()
                or fileslow.isEmpty() or filesavg.isEmpty() or fileshigh.isEmpty()
                or interfacelow.isEmpty() or interfaceavg.isEmpty() or interfacehigh.isEmpty())
    }

    private fun inputCalculation(): Int {
        var totalInput: Int = inputLow.text.toString().toInt() * 3 + inputAverage.text.toString()
            .toInt() * 4 + inputHigh.text.toString().toInt() * 6

        var totalOutput: Int = outputLow.text.toString().toInt() * 4 + outputAverage.text.toString()
            .toInt() * 5 + outputHigh.text.toString().toInt() * 7


        var totalInquiries: Int =
            inquiriesLow.text.toString().toInt() * 3 + inquiriesAverage.text.toString()
                .toInt() * 4 + inquiriesHigh.text.toString().toInt() * 6

        var totalFiles: Int = filesLow.text.toString().toInt() * 7 + filesAverage.text.toString()
            .toInt() * 10 + filesHigh.text.toString().toInt() * 15

        var totalInterface: Int =
            interfaceLow.text.toString().toInt() * 5 + interfaceAverage.text.toString()
                .toInt() * 7 + interfaceHigh.text.toString().toInt() * 10

        return totalInput + totalOutput + totalInquiries + totalFiles + totalInterface
    }
}