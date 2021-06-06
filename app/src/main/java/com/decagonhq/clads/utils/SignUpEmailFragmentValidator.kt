package com.decagonhq.clads.utils

import java.util.regex.Pattern

class SignUpEmailFragmentValidator {

    companion object {

        private const val NAME_PATTERN = "[a-zA-Z]{1,}"
        private const val EMAIL_PATTERN = "[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,64}"
        private const val PASSWORD_PATTERN = ".{6,}"

        fun nameValidator(name: String): Boolean {

            return matcher(NAME_PATTERN, name)
        }

        fun emailValidator(email: String): Boolean {
            return matcher(EMAIL_PATTERN, email)
        }

        fun accountCategoryValidator(account_Category: String): Boolean {
            return when {
                account_Category.toUpperCase() == AccountCategory.CLIENT.name ||
                    account_Category.toUpperCase() == AccountCategory.WEAVER.name ||
                    account_Category.toUpperCase() == AccountCategory.TAILOR.name -> {
                    true
                }
                else -> false
            }
        }

        fun passwordValidator(password: String): Boolean {
            return matcher(PASSWORD_PATTERN, password)
        }

        fun passwordsMatcher(password: String, confirmPassword: String): Boolean {
            return confirmPassword == password
        }

        private fun matcher(pattern: String, stringToMatch: String): Boolean {

            return Pattern.compile(pattern).matcher(stringToMatch).matches()
        }
    }
}
