package com.decagonhq.clads

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.decagonhq.clads.fragments.authentication.SignupChoicesFragment
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SignupChoicesFragmentTest : TestCase() {

    private lateinit var scenario: FragmentScenario<SignupChoicesFragment>

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
    fun is_Signup_Choices_Fragment_Imageview_Visible() {
        Espresso.onView(ViewMatchers.withId(R.id.fragment_signup_choices_imageview))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun is_Signup_Choices_Fragment_Google_Button_Visible() {
        Espresso.onView(ViewMatchers.withId(R.id.fragment_signup_choices_button_with_google))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun is_Signup_Choices_Fragment_Email_Button_Visible() {
        Espresso.onView(ViewMatchers.withId(R.id.fragment_signup_choices_button_with_email))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun is_Signup_Choices_Fragment_Have_Account_Textview_Visible() {
        Espresso.onView(ViewMatchers.withId(R.id.fragment_signup_choices_textview_have_account))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}
