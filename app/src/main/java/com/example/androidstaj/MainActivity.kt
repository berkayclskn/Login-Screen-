package com.example.androidstaj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.*

class Main : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


abstract class Spinner : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    abstract val spinner_sample: Spinner?
    var gender = arrayOf("Male", "Female", "Other")

    var spinner: Spinner? = null
    var textView_msg: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        spinner = this.spinner_sample
        spinner!!.setOnItemSelectedListener(this)


        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, gender)

        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner!!.setAdapter(aa)

    }

    abstract fun setAdapter(aa: ArrayAdapter<String>)

    abstract fun setOnItemSelectedListener(spinner: Spinner)

    override fun onItemSelected(arg0: AdapterView<*>, arg1: View, position: Int, id: Long) {
        textView_msg!!.text = "Selected : " + gender[position]
    }

    override fun onNothingSelected(arg0: AdapterView<*>) {


        fun toastMessage(view: View) {
            val messageEditText = findViewById<EditText>(R.id.messageEditText)
            val message = messageEditText.text.toString()
            var toast = Toast.makeText(this, message, Toast.LENGTH_LONG)
            toast.show()
        }
    }
}
}
