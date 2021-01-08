package com.example.urticariacrnica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_u_a_s7_scale.*
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class UAS7_scale : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_u_a_s7_scale)
        val buttonSave_UAS7 = findViewById<Button>(R.id.save_button_uas7)
        buttonSave_UAS7.setOnClickListener{
            val UASronchas = ronchasGroup.checkedRadioButtonId
            val UASronchasString = resources.getResourceEntryName(UASronchas)
            val UASprurito : Int = pruritoGroup.checkedRadioButtonId
            val UASpruritoString = resources.getResourceEntryName(UASprurito)
            val date = Calendar.getInstance().time
            val formatter = SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE)
            val formattedDate = formatter.format(date)

            val fileName = "uas7_scores.csv"

            val file = File(getExternalFilesDir(null), fileName)

            val fileExists = file.exists()

            if (!fileExists){
                file.appendText("Date, UAS7 Ronchas, UAS7 Prurito, Total\n")
            }
            val rScore = UASronchasString.takeLast(1).toInt()
            val pScore = UASpruritoString.takeLast(1).toInt()
            val totalScoreUAS7 = rScore+pScore
            val path = filesDir.absolutePath
            val file_path = File("$path/uas7_scores.csv")
            println(file_path)
            file.appendText("$formattedDate,$rScore,$pScore,$totalScoreUAS7\n")
            Toast.makeText(applicationContext,"Se han guardado las respuestas", Toast.LENGTH_SHORT).show()
        }
    }

}