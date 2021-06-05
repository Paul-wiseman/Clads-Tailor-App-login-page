package com.decagonhq.clads

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.decagonhq.clads.fragments.ResetPasswordVerification
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito

@RunWith(AndroidJUnit4ClassRunner::class)
class ResetPasswordFragmentConfirmationFragmentUiTest {
    @Before
    fun setUp() {
        val navController = Mockito.mock(NavController::class.java)
        val scenario: FragmentScenario<ResetPasswordVerification> = launchFragmentInContainer(themeResId = R.style.Theme_Clads) {
            ResetPasswordVerification().also { fragment ->
                fragment.viewLifecycleOwnerLiveData.observeForever { viewLifecycleOwner ->
                    if (viewLifecycleOwner != null) {
                        Navigation.setViewNavController(fragment.requireView(), navController)
                    }
                }
            }
        }
        scenario.moveToState(Lifecycle.State.STARTED)
    }
    @Test
    fun clad_logo_imageview_is_displayed() {
        Espresso.onView(ViewMatchers.withId(R.id.reset_password_verification_fragment_clads_logo))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun twitter_logo_is_displayed() {
        Espresso.onView(ViewMatchers.withId(R.id.reset_password_verification_fragment_twitter_logo_imageview))
            .check(
                ViewAssertions.matches(ViewMatchers.isDisplayed())
            )
    }

    @Test
    fun instagram_logo_is_displayed() {
        Espresso.onView(ViewMatchers.withId(R.id.reset_password_verification_fragment_instagram_logo_imageview))
            .check(
                ViewAssertions.matches(ViewMatchers.isDisplayed())
            )
    }

    @Test
    fun facebook_logo_is_displayed() {
        Espresso.onView(ViewMatchers.withId(R.id.reset_password_verification_fragment_facebook_logo_imageview))
            .check(
                ViewAssertions.matches(ViewMatchers.isDisplayed())
            )
    }

    @Test
    fun body_text_is_displayed() {
        Espresso.onView(ViewMatchers.withId(R.id.reset_password_verification_fragment_almost_there_message_textview))
            .check(
                ViewAssertions.matches(ViewMatchers.isDisplayed())
            )
    }

    @Test
    fun does_reset_button_navigate_to_reset_password_fragment() {
        val navController = Mockito.mock(NavController::class.java)
        val scenario: FragmentScenario<ResetPasswordVerification> = launchFragmentInContainer(themeResId = R.style.Theme_Clads) {
            ResetPasswordVerification().also { fragment ->
                fragment.viewLifecycleOwnerLiveData.observeForever { viewLifecycleOwner ->
                    if (viewLifecycleOwner != null) {
                        Navigation.setViewNavController(fragment.requireView(), navController)
                    }
                }
            }
        }

        Espresso.onView(ViewMatchers.withId(R.id.reset_password_verification_fragment_reset_password_button))
            .perform(ViewActions.click())
        Mockito.verify(navController).navigate(R.id.action_resetPasswordVerification_to_resetPassword)
    }
}
