package com.decagonhq.clads

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.* // ktlint-disable no-wildcard-imports
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.decagonhq.clads.fragments.authentication.SignupLoginFragment
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SignupLoginFragmentTest : TestCase() {

    private lateinit var scenario: FragmentScenario<SignupLoginFragment>

    @Before
    fun setup() {
        // Create a TestNavHostController
        val navController = TestNavHostController(ApplicationProvider.getApplicationContext())

        // Create a graphical FragmentScenario for the Signup_Login Fragment
        scenario = launchFragmentInContainer(themeResId = R.style.Theme_MaterialComponents)
        scenario.moveToState(Lifecycle.State.STARTED)

        scenario.onFragment { fragment ->
            navController.setGraph(R.navigation.authentication_nav_graph)

            // Make the NavController available via the findNavController() APIs
            Navigation.setViewNavController(fragment.requireView(), navController)
        }
    }

    @Test
    fun is_Signup_Fragment_Imageview_Visible() {
        onView(withId(R.id.fragment_signup_login_image_view)).check(matches(isDisplayed()))
    }

    @Test
    fun is_Signup_Fragment_Textview_Visible() {
        onView(withId(R.id.fragment_signup_login_textview)).check(matches(isDisplayed()))
    }

    @Test
    fun is_Signup_Fragment_Signup_Button_Visible() {
        onView(withId(R.id.fragment_signup_signup_button)).check(matches(isDisplayed()))
    }

    @Test
    fun is_Signup_Fragment_Login_Button_Visible() {
        onView(withId(R.id.fragment_signup_login_button)).check(matches(isDisplayed()))
    }

    @Test
    fun testNavigationToSignupChoicesScreen() {

        onView(withId(R.id.fragment_signup_signup_button)).perform(ViewActions.click())
    }
}
