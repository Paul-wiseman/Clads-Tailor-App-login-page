package com.decagonhq.clads

import android.content.Context
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.decagonhq.clads.fragments.ResetPassword
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito

@RunWith(AndroidJUnit4ClassRunner::class)
class ResetPasswordFragmentFragmentUiTest {
    @Before
    fun setUp() {
        val scenario = launchFragmentInContainer<ResetPassword>(themeResId = R.style.Theme_Clads)
        scenario.moveToState(Lifecycle.State.STARTED)
        val context = ApplicationProvider.getApplicationContext<Context>()
    }

    @Test
    fun reset_password_fragment_new_password_edittext_is_displayed() {
        Espresso.onView(ViewMatchers.withId(R.id.reset_password_fragment_new_password_edittext))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun reset_password_fragment_confirm_password_edittext_is_diplayed() {
        Espresso.onView(ViewMatchers.withId(R.id.reset_password_fragment_confirm_new_password_edittext))
            .check(
                ViewAssertions.matches(
                    ViewMatchers.isDisplayed()
                )
            )
    }

    @Test
    fun reset_password_fragment_reset_button_is_displayed() {
        Espresso.onView(ViewMatchers.withId(R.id.reset_password_fragment_reset_password_button))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun reset_password_fragment_login_textview_is_displayed() {
        Espresso.onView(ViewMatchers.withId(R.id.reset_password_fragment_login_textview))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun does_reset_password_button_navigate_to_login_fragment() {
        val navController = Mockito.mock(NavController::class.java)
        val scenario: FragmentScenario<ResetPassword> = launchFragmentInContainer(themeResId = R.style.Theme_Clads) {
            ResetPassword().also { fragment ->
                fragment.viewLifecycleOwnerLiveData.observeForever { viewLifecycleOwner ->
                    if (viewLifecycleOwner != null) {
                        Navigation.setViewNavController(fragment.requireView(), navController)
                    }
                }
            }
        }

        Espresso.onView(ViewMatchers.withId(R.id.reset_password_fragment_reset_password_button)).perform(
            ViewActions.click()
        )
        Mockito.verify(navController).navigate(R.id.action_resetPassword_to_loginFragment)
    }
}
