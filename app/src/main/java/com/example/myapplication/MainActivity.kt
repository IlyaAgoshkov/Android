package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn: Button = findViewById(R.id.btnResult)
        btn.setOnClickListener {
            val num2 = findViewById<EditText>(R.id.etNumber2)
            var n2 : Float? = null
            try
            {
                val n2 = num2.text.toString().toFloat()
            }
            catch (nfe: NumberFormatException){
                num2.error = "Введите число"
                num2.requestFocus()
            }
            val etOp = findViewById<EditText>(R.id.etOperation)
            var oper: String = etOp.text.toString()

            if (oper.isBlank() or (oper.length > 1) or (!("+-*/".contains(oper))))
            {
                etOp.error = "Укажите верную операцию"
                etOp.requestFocus()
                oper = ""
            }
            val num1 = findViewById<EditText>(R.id.etNumber1)
            var n1 : Float? = null
            try
            {
                val n1 = num1.text.toString().toFloat()
            }
            catch (nfe: NumberFormatException){
                num1.error = "Введите число"
                num1.requestFocus()
            }
            if ((n1 == null) or (n2 == null) or oper.isBlank()) return@setOnClickListener
            findViewById<TextView>(R.id.tvAnswer).text = when(oper){
                "*"-> {(n1!! *n2!!).toString()}
                "/"-> {(n1!! *n2!!).toString()}
                "+"-> {(n1!! *n2!!).toString()}
                "-"-> {(n1!! *n2!!).toString()}
                else -> ""
            }

        }
    }
}
