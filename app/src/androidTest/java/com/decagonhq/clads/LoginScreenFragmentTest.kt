package com.decagonhq.clads

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class LoginScreenFragmentTest {

    @Test
    fun test_isLoginFragmentVisible() {
//        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
//        onView(withId(R.id.mainActivity)).check(matches(isDisplayed()))
//        onView(withId(R.id.fragment)).check(matches(isDisplayed()))
        val scenario = launchFragmentInContainer<LoginScreenFragment>(themeResId = R.style.Theme_MaterialComponents)

//        onView(withId(R.id.login_page_userName)).perform(replaceText(name))
//        onView(withId(R.id.login_page_phoneNumber)).perform(replaceText(phoneNumber))
//        onView(withId(R.id.login_page_Email)).perform(replaceText(email))
//        onView(withId(R.id.login_page_gender)).perform(click())
//        onData(anything()).atPosition(0).perform(click())
//        onView(withId(R.id.login_page_gender)).check(matches(withSpinnerText(containsString(gender))))
//        onView(withId(R.id.btnRegister)).perform(click())
//        onView(withId(R.id.profile_activity)).check(matches(isDisplayed()))
//        onView(withId(R.id.profile_page_userName)).check(matches(withText(name)))
//        onView(withId(R.id.profile_page_phoneNumber)).check(matches(withText(phoneNumber)))
//        onView(withId(R.id.profile_page_Email)).check(matches(withText(email)))
//        onView(withId(R.id.profile_page_gender)).check(matches(withText(gender)))
    }
}
