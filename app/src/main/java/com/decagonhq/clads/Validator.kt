package com.decagonhq.clads

import android.util.Patterns

/**
 * the user can only login if the input field for the email and password is:
 * ... not empty
 * ... contains valid formate for email and password...
 *
 */
object Validator {

    fun validateEmail(email: String): Boolean {
        return !(email.trim().isEmpty() && !Patterns.EMAIL_ADDRESS.matcher(email.trim()).matches())
    }

    fun validatePassword(
        password: String
    ): Boolean {

        return !password.trim().isEmpty()
    }
}
