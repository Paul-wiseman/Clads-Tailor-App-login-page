package com.decagonhq.clads

import com.decagonhq.clads.utils.ForgotPasswordFragmentsValidationObject
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Test

class ForgotPasswordUnitTest {
    @Test
    fun is_email_valid() {
        val email: CharSequence = "sabdulqohar9@gmail.com"
        assertTrue(ForgotPasswordFragmentsValidationObject.validateEmail(email))
    }

    @Test
    fun do_passwords_match() {
        val passwordOne = "dogheadman1@"
        val passwordTwo = "dogheadman1@"
        assertTrue(
            ForgotPasswordFragmentsValidationObject.validatePasswords(
                passwordOne,
                passwordTwo
            )
        )
    }

    @Test
    fun passwords_do_not_match() {
        val passwordOne = "dogheadman1@"
        val passwordTwo = "doheadman1@"
        assertFalse(
            ForgotPasswordFragmentsValidationObject.validatePasswords(
                passwordOne,
                passwordTwo
            )
        )
    }

    @Test
    fun email_field_is_empty() {
        val email = ""
        assertFalse(ForgotPasswordFragmentsValidationObject.validateEmail(email))
    }

    @Test
    fun email_is_invalid() {
        val email = "sabdulqohar9gmail.com"
        assertFalse(ForgotPasswordFragmentsValidationObject.validateEmail(email))
    }
}
