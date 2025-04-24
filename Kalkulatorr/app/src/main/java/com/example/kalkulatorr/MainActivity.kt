package com.example.kalkulatorr // Pastikan ini sesuai dengan package-mu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var etNumber1: EditText
    private lateinit var etNumber2: EditText
    private lateinit var tvResult: TextView
    private lateinit var btnAdd: Button
    private lateinit var btnSubtract: Button
    private lateinit var btnMultiply: Button
    private lateinit var btnDivide: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNumber1 = findViewById(R.id.etNumber1)
        etNumber2 = findViewById(R.id.etNumber2)
        tvResult = findViewById(R.id.tvResult)
        btnAdd = findViewById(R.id.btnAdd)
        btnSubtract = findViewById(R.id.btnSubtract)
        btnMultiply = findViewById(R.id.btnMultiply)
        btnDivide = findViewById(R.id.btnDivide)

        btnAdd.setOnClickListener { calculate('+') }
        btnSubtract.setOnClickListener { calculate('-') }
        btnMultiply.setOnClickListener { calculate('*') }
        btnDivide.setOnClickListener { calculate('/') }
    }

    private fun calculate(op: Char) {
        val num1 = etNumber1.text.toString().toDoubleOrNull()
        val num2 = etNumber2.text.toString().toDoubleOrNull()

        if (num1 == null || num2 == null) {
            Toast.makeText(this, "Masukkan angka yang valid", Toast.LENGTH_SHORT).show()
            return
        }

        val result = when (op) {
            '+' -> num1 + num2
            '-' -> num1 - num2
            '*' -> num1 * num2
            '/' -> if (num2 != 0.0) num1 / num2 else "Tidak bisa dibagi 0"
            else -> "Error"
        }

        tvResult.text = "Hasil: $result"
    }
}
