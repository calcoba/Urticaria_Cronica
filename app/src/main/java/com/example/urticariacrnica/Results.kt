package com.example.urticariacrnica

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_results.*
import kotlinx.android.synthetic.main.activity_u_c_t_scale.*
import java.io.File
import java.text.SimpleDateFormat
import java.util.*


class Results : AppCompatActivity() {

    @SuppressLint("SdCardPath")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        val buttonShow = findViewById<Button>(R.id.button_show)
        buttonShow.setOnClickListener{
            val scaleSelector = scaleSelector.checkedRadioButtonId
            val scaleSelectorName = resources.getResourceEntryName(scaleSelector)
            val samplesNumber = samplesNumber.text.toString()
            println(scaleSelectorName)
            println(samplesNumber)
            lateinit var fileName: String
            if (scaleSelectorName=="uas7_selector") {
                fileName = "/storage/emulated/0/Android/data/com.example.urticariacrnica/files/uas7_scores.csv"
            }
            else {
                fileName = "/storage/emulated/0/Android/data/com.example.urticariacrnica/files/uct_scores.csv"
            }
            println(fileName)

            val scoreList = mutableListOf<String>()

            File(fileName).useLines { lines -> scoreList.addAll(lines) }
            val samplesSelected = scoreList.takeLast(samplesNumber.toInt())

            samplesSelected.forEachIndexed { i, line -> println("${i}: " + line) }

            Toast.makeText(applicationContext,"Se han guardado las respuestas", Toast.LENGTH_SHORT).show()
        }

    }

}

