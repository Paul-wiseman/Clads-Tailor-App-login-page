package com.decagonhq.clads

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import androidx.navigation.Navigation.setViewNavController
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class EmailVerificationUITest {
    @Before
    fun setUp() {
        val navController = Mockito.mock(NavController::class.java)
        val scenario: FragmentScenario<EmailVerificationFragment> =
            launchFragmentInContainer(themeResId = R.style.Theme_Clads) {
                EmailVerificationFragment().also { fragment ->
                    fragment.viewLifecycleOwnerLiveData.observeForever { viewLifeCycleOwner ->
                        if (viewLifeCycleOwner != null) {
                            setViewNavController(fragment.requireView(), navController)
                        }
                    }
                }
            }
        scenario.moveToState(Lifecycle.State.STARTED)
    }

    // check if clads logo is displayed
    @Test
    fun clads_logo_is_displayed() {
        onView(withId(R.id.email_verification_fragment_clads_image_view)).check(matches(isDisplayed()))
    }

    // check to see if view_in_browser prompt is displayed
    @Test
    fun browser_prompt_is_displayed() {
        onView(withId(R.id.email_verification_fragment_browser_prompt_text_view)).check(
            matches(
                isDisplayed()
            )
        )
    }

    // test to see if email in motion icon is displayed
    @Test
    fun email_in_motion_icon_is_displayed() {
        onView(withId(R.id.email_verification_fragment_email_in_motion_icon)).check(
            matches(
                isDisplayed()
            )
        )
    }

    // test to confirm if the email confirmation heading is displayed
    @Test
    fun email_confirmation_heading_is_displayed() {
        onView(withId(R.id.email_verification_fragment_email_confirmation_heading_text_view)).check(
            matches(isDisplayed())
        )
    }

    // test to see if prompt message is displayed
    @Test
    fun prompt_message_is_displayed() {
        onView(withId(R.id.email_verification_fragment_prompt_message_text_view)).check(
            matches(
                isDisplayed()
            )
        )
    }

    // test if verify email button is displayed
    @Test
    fun is_verify_email_address_button_in_view() {
        onView(withId(R.id.email_verification_fragment_verify_email_address_button)).check(
            matches(
                isDisplayed()
            )
        )
    }

    // test if facebook icon is displayed
    @Test
    fun is_facebook_icon_image_view_in_view() {
        onView(withId(R.id.email_verification_fragment_facebook_icon_image_view)).check(
            matches(
                isDisplayed()
            )
        )
    }

    // test to confirm if twitter icon is displayed
    @Test
    fun is_twitter_icon_image_view_in_view() {
        onView(withId(R.id.email_verification_fragment_twitter_icon_image_view)).check(
            matches(
                isDisplayed()
            )
        )
    }

    // test to confirm if verification button is displayed
    @Test
    fun is_email_verification_button_in_view() {
        onView(withId(R.id.email_verification_fragment_verify_email_address_button)).check(
            matches(
                isDisplayed()
            )
        )
    }

    // test the verify email button if it navigates to the login fragment
    @Test
    fun does_verify_button_navigate_to_login_fragment() {
        val navController = Mockito.mock(NavController::class.java)

        val scenario: FragmentScenario<EmailVerificationFragment> =
            launchFragmentInContainer(themeResId = R.style.Theme_Clads) {
                EmailVerificationFragment().also { fragment ->
                    fragment.viewLifecycleOwnerLiveData.observeForever { viewLifeCycleOwner ->
                        if (viewLifeCycleOwner != null) {
                            setViewNavController(fragment.requireView(), navController)
                        }
                    }
                }
            }

        onView(withId(R.id.email_verification_fragment_verify_email_address_button)).perform(click())
        Mockito.verify(navController)
            .navigate(R.id.action_emailVerificationFragment_to_loginFragment)
    }
}
