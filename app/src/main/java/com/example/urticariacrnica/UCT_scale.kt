package com.example.urticariacrnica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_u_c_t_scale.*
import java.io.File
import java.text.SimpleDateFormat
import java.util.*


class UCT_scale : AppCompatActivity() {
    lateinit var editText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_u_c_t_scale)

        val buttonSave_UCT = findViewById<Button>(R.id.save_button_uct)
        buttonSave_UCT.setOnClickListener{
            val UCT1 = UCT1.checkedRadioButtonId
            val UCT1String = resources.getResourceEntryName(UCT1)
            val UCT2 : Int = UCT2.checkedRadioButtonId
            val UCT2String = resources.getResourceEntryName(UCT2)
            val UCT3 : Int = UCT3.checkedRadioButtonId
            val UCT3String = resources.getResourceEntryName(UCT3)
            val UCT4 : Int = UCT4.checkedRadioButtonId
            val UCT4String = resources.getResourceEntryName(UCT4)
            val date = Calendar.getInstance().time
            val formatter = SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE)
            val formattedDate = formatter.format(date)

            val fileName = "uct_scores.csv"

            val file = File(getExternalFilesDir(null), fileName)

            val fileExists = file.exists()

            if(!fileExists){
                file.appendText("Date, UCT1, UCT2, UCT3, UCT4, Total\n")
            }
            val u1Score = UCT1String.takeLast(1).toInt()
            val u2Score = UCT2String.takeLast(1).toInt()
            val u3Score = UCT3String.takeLast(1).toInt()
            val u4Score = UCT4String.takeLast(1).toInt()
            val totalScoreUCT = u1Score+u2Score+u3Score+u4Score
            file.appendText("$formattedDate,$u1Score,$u2Score,$u3Score,$u4Score,$totalScoreUCT\n")
            Toast.makeText(applicationContext,"Se han guardado las respuestas",Toast.LENGTH_SHORT).show()
        }
    }

}