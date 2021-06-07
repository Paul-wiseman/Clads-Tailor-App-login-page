package com.decagonhq.clads

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.decagonhq.clads.fragments.authentication.SignupEmailFragment
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.verify

@RunWith(AndroidJUnit4ClassRunner::class)
class SignUpEmailFragmentUITest {

    private lateinit var firstNameToBetyped: String
    private lateinit var lastNameToBetyped: String
    private lateinit var emailToBetyped: String
    private lateinit var passwordToBeTyped: String
    private lateinit var accountItemToBeSelected: String

    @Test
    fun is_email_sign_Up_fragment_create_account_text_view_in_view() {
        onView(withId(R.id.email_sign_up_fragment_create_an_account_text_view))
            .check(matches(isDisplayed()))
    }

    @Test
    fun is_email_sign_up_fragment_description_text_view_in_view() {
        onView(withId(R.id.email_sign_up_fragment_description_text_view))
            .check(matches(isDisplayed()))
    }

    @Test
    fun is_email_sign_up_fragment_firstname_in_view() {
        onView(withId(R.id.email_sign_up_fragment_firstname_text_input_edit_text))
            .check(matches(isDisplayed()))
    }

    @Test
    fun is_email_sign_up_fragment_lastname_in_view() {
        onView(withId(R.id.email_sign_up_fragment_lastname_text_input_edit_text))
            .check(matches(isDisplayed()))
    }

    @Test
    fun is_email_sign_up_fragment_other_name_in_view() {
        onView(withId(R.id.email_sign_up_fragment_other_name_text_input_edit_text))
            .check(matches(isDisplayed()))
    }

    @Test
    fun is_email_sign_up_fragment_choose_category_in_view() {
        onView(withId(R.id.email_sign_up_fragment_account_category_text_input_layout))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_email_sign_up_fragment_choose_category_is_selected() {
        onView(withId(R.id.email_sign_up_fragment_account_category_text_input_layout)).perform(click())
            .check(matches(isDisplayed()))
    }

    @Test
    fun is_email_sign_up_fragment_email_text_view_in_view() {
        onView(withId(R.id.email_sign_up_fragment_email_address_text_input_edit_text))
            .check(matches(isDisplayed()))
    }

    @Test
    fun is_email_sign_up_fragment_password_text_view_in_view() {
        onView(withId(R.id.email_sign_up_fragment_password_text_input_edit_text))
            .check(matches(isDisplayed()))
    }

    @Test
    fun is_email_sign_up_fragment_confirm_password_text_view_in_view() {
        onView(withId(R.id.email_sign_up_fragment_confirm_password_text_input_edit_text))
            .check(matches(isDisplayed()))
    }

    @Test
    fun is_email_sign_up_fragment_sign_up_button_in_view() {
        onView(withId(R.id.email_sign_up_fragment_sign_up_button))
            .check(matches(isDisplayed()))
    }

    @Test
    fun is_email_sign_up_fragment_already_have_account_in_view() {
        onView(withId(R.id.email_sign_up_fragment_already_have_an_account_text_view))
            .check(matches(isDisplayed()))
    }

    @Test
    fun is_email_sign_up_fragment_login_in_view() {
        onView(withId(R.id.email_sign_up_fragment_login_text_view))
            .check(matches(isDisplayed()))
    }

    /*Test Navigation to Profile Activity*/
    @Before
    @Test
    fun test_sign_up_button_fragment_navigation_to_email_verification_fragment() {

        firstNameToBetyped = "Benklins"
        lastNameToBetyped = "Omoyibo"
        emailToBetyped = "Jonesbenklins@gmail.com"
        accountItemToBeSelected = "Client"
        passwordToBeTyped = "Benklins"
        val navController = Mockito.mock(NavController::class.java)

        launchFragmentInContainer(themeResId = R.style.Base_Theme_MaterialComponents) {
            SignupEmailFragment().also { fragment ->
                fragment.viewLifecycleOwnerLiveData.observeForever { viewLifecycleOwner ->
                    if (viewLifecycleOwner != null) {
                        // The fragment’s view has just been created
                        Navigation.setViewNavController(fragment.requireView(), navController)
                    }
                }
            }
        }

        // get the name edittextview view  and perform a text typing action on it
        onView(withId(R.id.email_sign_up_fragment_firstname_text_input_edit_text))
            .perform(replaceText(firstNameToBetyped), ViewActions.closeSoftKeyboard())

        // get the phoneNumber phoneedittextview view and perform a text typing action on it
        onView(withId(R.id.email_sign_up_fragment_lastname_text_input_edit_text))
            .perform(replaceText(lastNameToBetyped), ViewActions.closeSoftKeyboard())

//
        onView(withId(R.id.email_sign_up_fragment_account_category_auto_text_view)).perform(
            replaceText(accountItemToBeSelected)
        )

        // get the email edittextview and perform a text typing action on it
        onView(withId(R.id.email_sign_up_fragment_email_address_text_input_edit_text))
            .perform(replaceText(emailToBetyped), ViewActions.closeSoftKeyboard())

        onView(withId(R.id.email_sign_up_fragment_password_text_input_edit_text))
            .perform(replaceText(passwordToBeTyped), swipeUp())

        onView(withId(R.id.email_sign_up_fragment_confirm_password_text_input_edit_text))
            .perform(replaceText(passwordToBeTyped), swipeUp())

        ViewActions.closeSoftKeyboard()
        Thread.sleep(250)

        onView(withId(R.id.email_sign_up_fragment_sign_up_button)).perform(swipeUp(), click())
        verify(navController).navigate(R.id.action_signupEmailFragment_to_emailVerificationFragment)
    }
}
