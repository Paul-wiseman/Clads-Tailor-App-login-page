package com.decagonhq.clads.utils

/**
 * the user can only login if the input field for the email and password is:
 * ... not empty
 * ... contains valid format for email and password...
 *
 */
object LoginScreenFragmentValidator {

    // validation function for Email Address
    fun validateEmail(email: String): Boolean {
        val pattern = Regex("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")
        return pattern.matches(email)
    }

    // validation function Password
    fun validatePassword(
        password: String
    ): Boolean {

        return !password.trim().isEmpty()
    }
}
