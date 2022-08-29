package com.example.submission1aplikasigithubuser.ui.splashScreen


import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.example.submission1aplikasigithubuser.R
import com.example.submission1aplikasigithubuser.ui.main.MainActivity
import org.junit.Before
import org.junit.Test


class MainActivityTest {


    @Before
    fun setup() {

        ActivityScenario.launch(MainActivity::class.java)

    }

    @Test
    fun imageCheck() {

        onView(withId(R.id.searchView)).check(matches(isDisplayed()))


    }
}