package com.example.urticariacrnica

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import im.dacer.androidcharts.LineView
import kotlinx.android.synthetic.main.activity_results.*
import java.io.File


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
            lateinit var fileName : String
            fileName = if (scaleSelectorName=="uas7_selector") {
                "/storage/emulated/0/Android/data/com.example.urticariacrnica/files/uas7_scores.csv"
            } else {
                "/storage/emulated/0/Android/data/com.example.urticariacrnica/files/uct_scores.csv"
            }
            println(fileName)

            val scoreList = mutableListOf<String>()

            File(fileName).useLines { lines -> scoreList.addAll(lines) }
            val samplesSelected = scoreList.takeLast(samplesNumber.toInt())

            samplesSelected.forEachIndexed { i, line -> println("${i}: " + line) }
            val dateList = mutableListOf<String>()
            val sumList = java.util.ArrayList<Int>()

            for (sample in samplesSelected){
                val sampleDivided = sample.split(",")
                println(sampleDivided)
                dateList.add(sampleDivided.first().take(5))
                sumList.add(sampleDivided.last().toInt())

            }
            println(dateList)
            println(sumList)

            val lineView = findViewById<LineView>(R.id.line_view)
            lineView.setBottomTextList(ArrayList(dateList))
            lineView.setDataList(arrayListOf(sumList))
            lineView.setShowPopup(Int.MAX_VALUE)
            lineView.showPopup







            Toast.makeText(applicationContext,"Gráfica mostrada", Toast.LENGTH_SHORT).show()
        }

    }

}

