package com.decagonhq.clads

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.decagonhq.clads.fragments.authentication.LoginScreenFragment
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class LoginScreenFragmentTest {

    private lateinit var scenario: FragmentScenario<LoginScreenFragment>

    companion object {
        var email = "emeka.paul@decagon.dev"
        var password = "tictacttoe23"
    }

    @Before
    fun setup() {
        scenario =
            launchFragmentInContainer(themeResId = R.style.Theme_MaterialComponents)
    }

    // Testing for the visibility of the welcome Back textView
    @Test
    fun `is_login_screen_fragment_welcomeBack_textView_visible`() {
        onView(withId(R.id.fragment_login_screen_welcomeBack_text_view)).check(matches(isDisplayed()))
    }

    // Testing for the visibility of the login to continue textView
    @Test
    fun `is_login_screen_fragment_login_to_continue_textView_visible`() {
        onView(withId(R.id.fragment_login_screen_login_to_continue_text_view)).check(
            matches(
                isDisplayed()
            )
        )
    }

    // Testing for the visibility of the login with Google material button
    @Test
    fun `is_login_screen_fragment_loginWithGoogle_Material_button_visible`() {
        onView(withId(R.id.fragment_login_screen_login_with_google_material_button)).check(
            matches(
                isDisplayed()
            )
        )
    }

    // Testing for the visibility of the email Address edit text
    @Test
    fun `is_login_screen_fragment_emailAddress_editText_visible`() {
        onView(withId(R.id.fragment_login_screen_email_address_text_input_edit_text)).check(
            matches(
                isDisplayed()
            )
        )
    }

    // Testing for the visibility of the password edit text
    @Test
    fun `is_login_screen_fragment_password_editText_visible`() {
        onView(withId(R.id.fragment_login_screen_password_text_input_edit_text)).check(
            matches(
                isDisplayed()
            )
        )
    }

    // Testing for the visibility of the login button
    @Test
    fun `is_login_screen_fragment_login_button_visible`() {
        onView(withId(R.id.fragment_login_screen_login_button)).check(matches(isDisplayed()))
    }

    // Testing for the visibility of the NewUser textView
    @Test
    fun `is_login_screen_fragment_newUser_textView_visible`() {
        onView(withId(R.id.fragment_login_screen_newUser_text_view)).check(matches(isDisplayed()))
    }

    // Testing for the visibility of the signUp textView
    @Test
    fun `is_login_screen_fragment_signUp_textView_visible`() {
        onView(withId(R.id.fragment_login_screen_signup_text_view)).check(matches(isDisplayed()))
    }

    // Testing for the visibility of the forgot password textView
    @Test
    fun `is_login_screen_fragment_forgotPassword_textView_visible`() {
        onView(withId(R.id.fragment_login_screen_forgotPassword_text_view)).check(
            matches(
                isDisplayed()
            )
        )
    }

    // Testing for navigation between fragment
    @Test
    fun `does_login_page_login_Button_navigate_to_the_next_page`() {

        onView(withId(R.id.fragment_login_screen_email_address_text_input_edit_text)).perform(
            replaceText(
                email
            )
        )
        onView(withId(R.id.fragment_login_screen_password_text_input_edit_text)).perform(
            replaceText(
                password
            )
        )
        onView(withId(R.id.fragment_login_screen_login_button)).check(matches(isDisplayed()))
    }
}
