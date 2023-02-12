package com.example.tiptime

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

import androidx.test.espresso.assertion.ViewAssertions.matches
import junit.runner.Version.id
import org.hamcrest.Matchers.containsString

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class CalculatorTests {

    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)

    //this was written origially nd in the codelabe they were working as if it didn't exist maybe they didn't have it in their older verdion of android studio
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.tiptime", appContext.packageName)
    }

    @Test
    fun calculate_20_percent_tip() {

        onView(withId(R.id.cost_of_service_edit_text))
            .perform(typeText("50.00")) //type in the cost of service textfeild

        onView(withId(R.id.calculate_button))
            .perform(click()) //click calculate

        onView(withId(R.id.tip_result))
            .check(matches(withText(containsString("$10.00"))))  //check if result is as expected

    }

    @Test
    fun calculate_18_percent_tip() {

        onView(withId(R.id.cost_of_service_edit_text))
            .perform(typeText("50.00")) //type in the cost of service textfeild

        onView(withId(R.id.option_eighteen_percent))
            .perform(click())

        onView(withId(R.id.calculate_button))
            .perform(click()) //click calculate

        onView(withId(R.id.tip_result))
            .check(matches(withText(containsString("$9.00"))))  //check if result is as expected

    }

    @Test
    fun calculate_15_percent_tip() {

        onView(withId(R.id.cost_of_service_edit_text))
            .perform(typeText("50.00")) //type in the cost of service textfeild

        onView(withId(R.id.option_fifteen_percent))
            .perform(click())

        onView(withId(R.id.round_up_switch))
            .perform(click()) //click calculate

        onView(withId(R.id.calculate_button))
            .perform(click()) //click calculate

        onView(withId(R.id.tip_result))
            .check(matches(withText(containsString("$7.50"))))  //check if result is as expected

    }


}