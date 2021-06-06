package com.decagonhq.clads.utils

object ForgotPasswordFragmentsValidationObject {
    // function to validate correctness of email input
    fun validateEmail(email: CharSequence): Boolean {
        val pattern = "\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,6}".toRegex()
        return email.matches(pattern)
    }
    // function to validate the equality of both passwords
    fun validatePasswords(password: String, confirmPassword: String): Boolean {
        if (password == confirmPassword) {
            return true
        }
        return false
    }
}
