package com.example.espressotestcourse.ui.activity

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.isDialog
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.example.espressotestcourse.LoginActivity
import com.example.espressotestcourse.R
import org.junit.Rule
import org.junit.Test

class LoginActivityTest {

    @get:Rule
    public val mActivityRul = ActivityTestRule<LoginActivity>(
        LoginActivity::class.java
    )

    @Test
    public fun whenActivityNoShowFieldsOnDocumentation() {
        Espresso.onView(withId(R.id.edtEmail)).check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.edtPassword)).check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.btnLogin)).check(matches(isDisplayed()))
        Espresso.onView(withText("Android test")).check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.edtEmail)).check(matches(withHint("Email")))
    }

    @Test
    public fun verifyTextInDialog() {
        Espresso.onView(withId(R.id.btnLogin)).perform(click())
        Espresso.onView(withText("Pensando denovo pensando")).inRoot(isDialog()).check(
            matches(
                isDisplayed()
            )
        )
    }

    @Test
    public fun verifyPasswordEmptyField(){
        Espresso.onView(withId(R.id.edtEmail)).perform(typeText("luciodarcon@gmail.com"))
        Espresso.closeSoftKeyboard()
        verifyTextInDialog()
    }

    @Test
    public fun verifyEmailEmptyField(){
        Espresso.onView(withId(R.id.edtPassword)).perform(typeText("123456"))
        Espresso.closeSoftKeyboard()
        verifyTextInDialog()
    }

    @Test
    public fun verifyTitleInMainActivity(){
        Espresso.onView(withId(R.id.edtEmail)).perform(typeText("luciiodarcon@gmail.com"))
        Espresso.closeSoftKeyboard()
        Espresso.onView(withId(R.id.edtPassword)).perform(typeText("123456"))
        Espresso.closeSoftKeyboard()
        Espresso.onView(withId(R.id.btnLogin)).perform(click())
        Espresso.onView(withText("Ola mundo espresso"))
    }

    @Test
    public fun verifyPressedBackButtonInMainActivity(){
        verifyTitleInMainActivity()
        Espresso.pressBack()
        whenActivityNoShowFieldsOnDocumentation()
    }

    @Test
    public fun verifyScrolViewInRecyclerView(){
        login()
        Espresso.onView(withId(R.id.recyclerViewCustomer)).perform(swipeUp(), click())
        Thread.sleep(4000)
    }

    fun login(){
        Espresso.onView(withId(R.id.edtEmail)).perform(typeText("luciiodarcon@gmail.com"))
        Espresso.closeSoftKeyboard()
        Espresso.onView(withId(R.id.edtPassword)).perform(typeText("123456"))
        Espresso.closeSoftKeyboard()
        Espresso.onView(withId(R.id.btnLogin)).perform(click())
    }

}