package com.example.meuprimeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView



class ResultActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvclassification = findViewById<TextView>(R.id.textview_classification)


        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()


        var classification = if (result < 18.5f) {
            "Underweight "
        } else if (result in 18.5f..24.9f) {
            "Healthy Weight"
        } else if (result in 25f..29.9f) {
            "Overweight"
        } else if (result in 30f..39.9f) {
            "Obese"
        } else {
            "Severely Obese"
        }

        tvclassification.text = getString(R.string.message_classification, classification)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)

    }

}