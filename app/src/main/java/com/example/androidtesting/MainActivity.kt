package com.example.androidtesting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var nameEditText:EditText
    lateinit var tvTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEditText  =findViewById(R.id.nameE)
        tvTextView = findViewById(R.id.tv)
    }

    fun buttonClick(view: View) {
        val name = nameEditText.text.toString()
        tvTextView.text = "Hello $name"
        nameEditText.setText("")

        //launch the next activity for 3rd fun testing
        val i = Intent(this, DisplayActivity::class.java)
        i.putExtra("name",name)
        startActivity(i)
    }
}