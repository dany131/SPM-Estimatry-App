package com.example.estimatry.estimation_techniques

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.estimatry.R

class UcpAnswer : AppCompatActivity() {

    var UUCW = ""
    var UAW = ""
    var TCF = ""
    var ECF = ""
    var UCP = ""

    lateinit var toolbar_ucp_answer: androidx.appcompat.widget.Toolbar

    lateinit var UUCWans: TextView
    lateinit var UAWans: TextView
    lateinit var TCFWans: TextView
    lateinit var ECFWans: TextView
    lateinit var UCPWans: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ucp_answer)

        toolbar_ucp_answer = findViewById(R.id.toolbar_ucpanswer)
        toolbar_ucp_answer.setNavigationIcon(R.drawable.nav_icon_black)
        toolbar_ucp_answer.title = "UCP"
        toolbar_ucp_answer.setTitleTextColor(Color.WHITE)
        toolbar_ucp_answer.setNavigationOnClickListener {
            onBackPressed()
        }

        UUCW = intent.getStringExtra("UUCW").toString()
        UAW = intent.getStringExtra("UAW").toString()
        TCF = intent.getStringExtra("TCF").toString()
        ECF = intent.getStringExtra("ECF").toString()
        UCP = intent.getStringExtra("UCP").toString()

        UUCWans = findViewById(R.id.uucw_ans)
        UAWans = findViewById(R.id.UAWans)
        TCFWans = findViewById(R.id.TCFans)
        ECFWans = findViewById(R.id.ECFans)
        UCPWans = findViewById(R.id.UCPans)

        UUCWans.text = "UUCW: $UUCW"
        UAWans.text = "UAW: $UAW"
        TCFWans.text = "TCF: $TCF"
        ECFWans.text = "ECF: $ECF"
        UCPWans.text = "UCP: $UCP"


    }
}