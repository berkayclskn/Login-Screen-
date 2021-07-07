package com.example.androidstaj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.*

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    val Gender = resources.getStringArray(R.array.Gender),

    val spinner = findViewById<Spinner>(R.id.spinner)

    if (spinner != null)
    {
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item, Gender
        )
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {
                Toast.makeText(
                    this@MainActivity,
                    getString(R.string.item) + " " +
                            "" + Gender[position], Toast.LENGTH_SHORT
                ).show()
            }

            fun toastMessage(view: View) {
                val messageEditText = findViewById<EditText>(R.id.messageEditText)
                val message = messageEditText.text.toString()
                var toast = Toast.makeText(this, message, Toast.LENGTH_LONG)
                toast.show()
            }
        }
    }
}




