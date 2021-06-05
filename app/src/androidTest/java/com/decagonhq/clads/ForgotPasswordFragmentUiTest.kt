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
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.decagonhq.clads.fragments.ForgotPasswordFragment
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.verify

@RunWith(AndroidJUnit4::class)
class ForgotPasswordFragmentUiTest {
    @Before
    fun setUp() {
        val navController = Mockito.mock(NavController::class.java)
        val scenario: FragmentScenario<ForgotPasswordFragment> = launchFragmentInContainer(themeResId = R.style.Theme_Clads) {
            ForgotPasswordFragment().also { fragment ->
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
    fun forgot_password_textview_is_displayed() {
        Espresso.onView(withId(R.id.forgot_password_fragment_forgot_password_textview)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
    }

    @Test
    fun email_edittext_is_displayed() {
        Espresso.onView(withId(R.id.forgot_password_fragment_email_edittext))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun request_password_link_button_is_displayed() {
        Espresso.onView(withId(R.id.forgot_password_fragment_request_password_button)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
    }

    @Test
    fun can_remember_password_textview_is_displayed() {
        Espresso.onView(withId(R.id.forgot_password_can_remember_password_textview)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
    }

    @Test
    fun login_textview_is_displayed() {
        Espresso.onView(withId(R.id.forgot_password_fragment_login_textview))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun does_request_password_button_navigate_to_reset_password_verification_screen() {
        val navController = Mockito.mock(NavController::class.java)
        val scenario: FragmentScenario<ForgotPasswordFragment> = launchFragmentInContainer(themeResId = R.style.Theme_Clads) {
            ForgotPasswordFragment().also { fragment ->
                fragment.viewLifecycleOwnerLiveData.observeForever { viewLifecycleOwner ->
                    if (viewLifecycleOwner != null) {
                        Navigation.setViewNavController(fragment.requireView(), navController)
                    }
                }
            }
        }
        val email = "sabdulqohar9@gmail.com"
        Espresso.onView(withId(R.id.forgot_password_fragment_email_edittext))
            .perform(ViewActions.replaceText(email))
        Espresso.onView(withId(R.id.forgot_password_fragment_request_password_button))
            .perform(ViewActions.click())
        verify(navController).navigate(R.id.action_forgotPasswordFragment_to_resetPasswordVerification)
    }
}
