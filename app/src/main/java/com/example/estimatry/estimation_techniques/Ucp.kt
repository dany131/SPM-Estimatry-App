package com.example.estimatry.estimation_techniques

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.estimatry.R
import com.google.android.material.textfield.TextInputEditText

class Ucp : AppCompatActivity() {

    lateinit var toolbar_ucp: androidx.appcompat.widget.Toolbar

    lateinit var UUCW_simple: TextInputEditText
    lateinit var UUCW_average: TextInputEditText
    lateinit var UUCW_complex: TextInputEditText

    lateinit var UAW_simple: TextInputEditText
    lateinit var UAW_average: TextInputEditText
    lateinit var UAW_complex: TextInputEditText

    lateinit var Distributed_system_data: TextInputEditText
    lateinit var response_time_data: TextInputEditText
    lateinit var End_user_efficiency_data: TextInputEditText
    lateinit var Internal_processing_complexity_data: TextInputEditText
    lateinit var Code_reusability_data: TextInputEditText
    lateinit var Easy_to_install_data: TextInputEditText
    lateinit var Easy_to_use_data: TextInputEditText
    lateinit var Portability_to_other_platforms_data: TextInputEditText
    lateinit var System_maintenance_data: TextInputEditText
    lateinit var parallel_processing_data: TextInputEditText
    lateinit var Security_features_data: TextInputEditText
    lateinit var Access_for_third_parties_data: TextInputEditText
    lateinit var End_user_training_data: TextInputEditText

    lateinit var Familiarity_with_development_process_used_data: TextInputEditText
    lateinit var Application_experience_data: TextInputEditText
    lateinit var Objectorientedexperienceofteam_data: TextInputEditText
    lateinit var Lead_analyst_capability_data: TextInputEditText
    lateinit var Motivation_of_the_team_data: TextInputEditText
    lateinit var Stability_of_requirements_data: TextInputEditText
    lateinit var Part_time_staff_data: TextInputEditText
    lateinit var Difficult_programming_language_data: TextInputEditText

    lateinit var calculateUCP: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ucp)

        toolbar_ucp = findViewById(R.id.toolbar_ucp)
        toolbar_ucp.setNavigationIcon(R.drawable.nav_icon_black)
        toolbar_ucp.title = "UCP"
        toolbar_ucp.setTitleTextColor(Color.WHITE)
        toolbar_ucp.setNavigationOnClickListener {
            onBackPressed()
        }


        UUCW_simple = findViewById(R.id.UUCW_simple_data)
        UUCW_average = findViewById(R.id.UUCW_average_data)
        UUCW_complex = findViewById(R.id.UUCW_complex_data)

        UAW_simple = findViewById(R.id.UAW_low_data)
        UAW_average = findViewById(R.id.UAW_average_data)
        UAW_complex = findViewById(R.id.UAW_complex_data)

        Distributed_system_data = findViewById(R.id.Distributed_system_data)
        response_time_data = findViewById(R.id.response_time_data)
        End_user_efficiency_data = findViewById(R.id.End_user_efficiency_data)
        Internal_processing_complexity_data = findViewById(R.id.Internal_processing_complexity_data)
        Code_reusability_data = findViewById(R.id.Code_reusability_data)
        Easy_to_install_data = findViewById(R.id.Easy_to_install_data)
        Easy_to_use_data = findViewById(R.id.Easy_to_use_data)
        Portability_to_other_platforms_data = findViewById(R.id.Portability_to_other_platforms_data)
        System_maintenance_data = findViewById(R.id.System_maintenance_data)
        parallel_processing_data = findViewById(R.id.parallel_processing_data)
        Security_features_data = findViewById(R.id.Security_features_data)
        Access_for_third_parties_data = findViewById(R.id.Access_for_third_parties_data)
        End_user_training_data = findViewById(R.id.End_user_training_data)

        Familiarity_with_development_process_used_data =
            findViewById(R.id.Familiarity_with_development_process_used_data)
        Application_experience_data = findViewById(R.id.Application_experience_data)
        Objectorientedexperienceofteam_data = findViewById(R.id.Objectorientedexperienceofteam_data)
        Lead_analyst_capability_data = findViewById(R.id.Lead_analyst_capability_data)
        Motivation_of_the_team_data = findViewById(R.id.Motivation_of_the_team_data)
        Stability_of_requirements_data = findViewById(R.id.Stability_of_requirements_data)
        Part_time_staff_data = findViewById(R.id.Part_time_staff_data)
        Difficult_programming_language_data = findViewById(R.id.Difficult_programming_language_data)

        calculateUCP = findViewById(R.id.btn_finish)

        calculateUCP.setOnClickListener {
            if (!validateUUCW() or !validateUAW() or !validateTCF() or !validateECF()) {
                Toast.makeText(applicationContext, "Type 0 if none", Toast.LENGTH_SHORT).show()
            } else {

                val intent = Intent(this@Ucp, UcpAnswer::class.java)
                intent.putExtra("UUCW", calUUCW().toString())
                intent.putExtra("UAW", calUAW().toString())
                intent.putExtra("TCF", calTCF().toString())
                intent.putExtra("ECF", calECF().toString())
                intent.putExtra("UCP", calculateUCP().toString())
                startActivity(intent)
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            }
        }

    }

    private fun validateECF(): Boolean {
        val inquiriesavg =
            Familiarity_with_development_process_used_data.text.toString().trim { it <= ' ' }
        val inquirieshigh = Application_experience_data.text.toString().trim { it <= ' ' }
        val fileslow = Objectorientedexperienceofteam_data.text.toString().trim { it <= ' ' }
        val filesavg = Lead_analyst_capability_data.text.toString().trim { it <= ' ' }
        val fileshigh = Motivation_of_the_team_data.text.toString().trim { it <= ' ' }
        val interfacelow = Stability_of_requirements_data.text.toString().trim { it <= ' ' }
        val interfaceavg = Part_time_staff_data.text.toString().trim { it <= ' ' }
        val interfacehigh = Difficult_programming_language_data.text.toString().trim { it <= ' ' }

        return !(inquiriesavg.isEmpty() or inquirieshigh.isEmpty()
                or fileslow.isEmpty() or filesavg.isEmpty() or fileshigh.isEmpty()
                or interfacelow.isEmpty() or interfaceavg.isEmpty() or interfacehigh.isEmpty())

    }

    private fun validateTCF(): Boolean {

        val inputlow = Distributed_system_data.text.toString().trim { it <= ' ' }
        val inputavg = response_time_data.text.toString().trim { it <= ' ' }
        val inputhigh = End_user_efficiency_data.text.toString().trim { it <= ' ' }
        val outputlow = Internal_processing_complexity_data.text.toString().trim { it <= ' ' }
        val outputavg = Code_reusability_data.text.toString().trim { it <= ' ' }
        val outputhigh = Easy_to_install_data.text.toString().trim { it <= ' ' }
        val inquirieslow = Easy_to_use_data.text.toString().trim { it <= ' ' }
        val inquiriesavg = Portability_to_other_platforms_data.text.toString().trim { it <= ' ' }
        val inquirieshigh = System_maintenance_data.text.toString().trim { it <= ' ' }
        val fileslow = parallel_processing_data.text.toString().trim { it <= ' ' }
        val filesavg = Security_features_data.text.toString().trim { it <= ' ' }
        val fileshigh = Access_for_third_parties_data.text.toString().trim { it <= ' ' }
        val interfacelow = End_user_training_data.text.toString().trim { it <= ' ' }


        return !(inputlow.isEmpty() or inputavg.isEmpty() or inputhigh.isEmpty()
                or outputlow.isEmpty() or outputavg.isEmpty() or outputhigh.isEmpty()
                or inquirieslow.isEmpty() or inquiriesavg.isEmpty() or inquirieshigh.isEmpty()
                or fileslow.isEmpty() or filesavg.isEmpty() or fileshigh.isEmpty()
                or interfacelow.isEmpty())

    }

    private fun validateUAW(): Boolean {

        val interfacelow = UAW_simple.text.toString().trim { it <= ' ' }
        val interfaceavg = UAW_average.text.toString().trim { it <= ' ' }
        val interfacehigh = UAW_complex.text.toString().trim { it <= ' ' }

        return !(interfacelow.isEmpty() or interfaceavg.isEmpty() or interfacehigh.isEmpty())

    }

    private fun validateUUCW(): Boolean {

        val interfacelow = UUCW_simple.text.toString().trim { it <= ' ' }
        val interfaceavg = UUCW_average.text.toString().trim { it <= ' ' }
        val interfacehigh = UUCW_complex.text.toString().trim { it <= ' ' }

        return !(interfacelow.isEmpty() or interfaceavg.isEmpty() or interfacehigh.isEmpty())
    }

    private fun calUUCW(): Int {

        val UUCWSimple = UUCW_simple.text.toString().toInt()
        val UUCWAverage = UUCW_average.text.toString().toInt()
        val UUCWComplex = UUCW_complex.text.toString().toInt()

//        UUCW = (Total No. of Simple Use Cases x 5) + (Total No. Average Use Cases x 10) + (Total No. Complex Use Cases x 15)

        var total = (UUCWSimple * 5) + (UUCWAverage * 10) + (UUCWComplex * 15)
        return total

    }

    private fun calUAW(): Int {

        val UAWSimple = UAW_simple.text.toString().toInt()
        val UAWAverage = UAW_average.text.toString().toInt()
        val UAWComplex = UAW_complex.text.toString().toInt()

//        UAW = (Total No. of Simple actors x 1) + (Total No. Average actors x 2) + (Total No. Complex actors x 3)

        var total = (UAWSimple * 1) + (UAWAverage * 2) + (UAWComplex * 3)
        return total
    }

    private fun calTCF(): Double {

        val Distributedsystemdata = Distributed_system_data.text.toString().toInt()
        val responsetimedata = response_time_data.text.toString().toInt()
        val Enduserefficiencydata = End_user_efficiency_data.text.toString().toInt()
        val Internalprocessingcomplexitydata =
            Internal_processing_complexity_data.text.toString().toInt()
        val Codereusabilitydata = Code_reusability_data.text.toString().toInt()
        val Easytoinstalldata = Easy_to_install_data.text.toString().toInt()
        val Easytousedata = Easy_to_use_data.text.toString().toInt()
        val Portabilitytootherplatformsdata =
            Portability_to_other_platforms_data.text.toString().toInt()
        val Systemmaintenancedata = System_maintenance_data.text.toString().toInt()
        val parallelprocessingdata = parallel_processing_data.text.toString().toInt()
        val Securityfeaturesdata = Security_features_data.text.toString().toInt()
        val Accessforthirdpartiesdata = Access_for_third_parties_data.text.toString().toInt()
        val Endusertrainingdata = End_user_training_data.text.toString().toInt()

        // Sum after weights
        var TF =
            Distributedsystemdata * 2 + responsetimedata * 1 + Enduserefficiencydata * 1 + Internalprocessingcomplexitydata * 1 + Codereusabilitydata * 1 + Easytoinstalldata * 0.5 +
                    Easytousedata * 0.5 + Portabilitytootherplatformsdata * 2 + Systemmaintenancedata * 1 + parallelprocessingdata * 1 + Securityfeaturesdata * 1 +
                    Accessforthirdpartiesdata * 1 + Endusertrainingdata * 1

//        TCF = 0.6 + (TF/100)
        var total = 0.6 + (TF / 100)

        return total
    }

    private fun calECF(): Double {

        val Familiarity_with_development_process_used_data =
            Familiarity_with_development_process_used_data.text.toString().toInt()
        val Application_experience_data = Application_experience_data.text.toString().toInt()
        val Objectorientedexperienceofteam_data =
            Objectorientedexperienceofteam_data.text.toString().toInt()
        val Lead_analyst_capability_data = Lead_analyst_capability_data.text.toString().toInt()
        val Motivation_of_the_team_data = Motivation_of_the_team_data.text.toString().toInt()
        val Stability_of_requirements_data = Stability_of_requirements_data.text.toString().toInt()
        val Part_time_staff_data = Part_time_staff_data.text.toString().toInt()
        val Difficult_programming_language_data =
            Difficult_programming_language_data.text.toString().toInt()


        // Sum after weights
        var EF =
            Familiarity_with_development_process_used_data * 1.5 + Application_experience_data * 0.5 +
                    Objectorientedexperienceofteam_data * 1 + Lead_analyst_capability_data * 0.5 +
                    Motivation_of_the_team_data * 1 + Stability_of_requirements_data * 2 +
                    Part_time_staff_data * -1 + Difficult_programming_language_data * -1

//        ECF = 1.4 + (-0.03 x EF)
        var total = 1.4 + (-0.03 * EF)

        return total
    }

    private fun calculateUCP(): Double {

//        UCP = (UUCW + UAW) x TCF x ECF

        var total = (calUUCW() + calUAW()) * calTCF() * calECF()
        return total
    }


}
