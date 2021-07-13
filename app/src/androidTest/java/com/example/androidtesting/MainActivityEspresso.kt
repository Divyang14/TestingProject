package com.example.androidtesting

import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.hamcrest.CoreMatchers.allOf
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test

class MainActivityEspresso {

    @get:Rule //get: for public
    val rule = ActivityScenarioRule(MainActivity::class.java)//class reference

    //first check my layout are proper or not
    @Test
    fun testLayout(){

        //1...import Espresso.*  note {*}  for onView-----ignore Espresso.onView
        // 2....import viewMatcher.*  note {*}  for withId-----ignore ViewMatcher.withId
        // 3.....import ViewAssertions  note {*}  for matches-----ignore ViewAssertions.matches
       onView(withId(R.id.tv)).check(matches(withText("Hello World!")))// "" for expected

//        onView(withText("oK")).check(matches(withId(R.id.button))) ...exception
        onView(withText("OK")).check(matches(withId(R.id.button)))//..correct

        //onView(withId(R.id.nameE)).check(matches(withText("DIVYANG")))//..exception
        onView(withId(R.id.nameE)).check(matches(withText("")))//...correct

        //perform the action
        onView(withId(R.id.nameE)).perform(ViewActions.typeText("DIVYANG"))
            //close that soft keyboard programmatically
            .perform(ViewActions.closeSoftKeyboard())
           //close that soft keyboard programmatically

//        onView(withId(R.id.button)).perform(ViewActions.click())

        //edit text should empty when clicked
//        onView(withId(R.id.tv)).check(matches(withText("Hello DIVYANG")))
//        onView(withId(R.id.nameE)).check(matches(withText("")))
//
        //check more than one assertions or conditions
        //after text it becoming empty again but with that also enabled
        //1empty text
        //2enabled or not
        //allOf for apply import allOf of hamcrest.Matchers
//        onView(withId(R.id.nameE)).check(matches(allOf(withText(""), isEnabled())))

    }
    @Ignore
    @Test
    fun testButtonClicked(){


        onView(withId(R.id.nameE)).perform(ViewActions.typeText("DIVYANG"))
            .perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.button)).perform(ViewActions.click())
        onView(withId(R.id.nameE)).check(matches(allOf(withText(""), isEnabled())))


    }

    @Test // for next Activity after onclick
    fun testNextActivity(){

        onView(withId(R.id.nameE)).perform(ViewActions.typeText("DIVYANG"))
            .perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.button)).perform(ViewActions.click())
        //next Activity
//        onView(withText("DIVYANG")).check(matches(isDisplayed()))

    }


}