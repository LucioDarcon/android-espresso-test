package com.example.espressotestcourse.ui.activity

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.example.espressotestcourse.LoginActivity
import com.example.espressotestcourse.R
import org.junit.Rule
import org.junit.Test

class LoginActivityTest {

    @get:Rule
    public val mActivityRul = ActivityTestRule<LoginActivity>(
        LoginActivity::class.java)

    @Test
    public fun whenActivityNoShowFieldsOnDocumentation(){
        Espresso.onView(withId(R.id.edtEmail)).check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.edtPassword)).check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.btnLogin)).check(matches(isDisplayed()))
    }

}