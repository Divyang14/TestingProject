package com.example.androidtesting

import android.widget.EditText
import android.widget.TextView
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    //create rule to start activity
    @get:Rule
    var rule = ActivityScenarioRule(MainActivity::class.java)

    //test method-----
    @Test
    fun testLayout(){
        val scenario = rule.scenario

        scenario.onActivity {
            val tvTextView = it.findViewById<TextView>(R.id.tv)
           assertNotNull(tvTextView)

            val btn = it.findViewById<TextView>(R.id.button)
            assertNotNull(btn)

            val nameEditText = it.findViewById<EditText>(R.id.nameE)
            assertNotNull(nameEditText)

            val initialMsg = tvTextView.text.toString()
            assertEquals("Not matching","Hello World!", initialMsg)

            val initialName = nameEditText.text.toString()
            assertEquals("Name should be Empty","", initialName)


            nameEditText.setText("DIVYANG")

            assertTrue("button should be clickable",btn.isEnabled)
            btn.callOnClick()
            val updateText = tvTextView.text.toString()
            assertEquals("Hello DIVYANG", updateText)

            val updateName = nameEditText.text.toString()
            assertEquals("", updateName)
        }

    }
}