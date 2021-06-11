package com.decagonhq.clads

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ValidatorTest {
    /**
     * the user should not be able to login if the:
     * ... password field is empty
     * ... email field is empty
     * ... email input is not correct
     *
     */
    @Test
    fun `validateEmail returns true if the input is not empty and is a correct email pattern`() {
        val result = Validator.validateEmail("emeka.paul@decagon.dev")
        assertTrue(result)
    }

    @Test
    fun `ValidateEmail returns false if the email input is empty`() {
        val result = Validator.validateEmail(" ")
        assertFalse(result)
    }

    @Test
    fun `ValidateEmail returns false if the pattern of the email is not correct`() {
        val result = Validator.validateEmail("emeka")
        assertFalse(result)
    }

    /**
     * the user password is not valid if
     * ... it is empty
     */
    @Test
    fun `ValidatePassword returns true if the password is valid`() {
        val result = Validator.validatePassword("ticTactoe@tango1")
        assertTrue(result)
    }

    @Test
    fun `ValidatePassword returns false if the password input is empty`() {
        val result = Validator.validatePassword(" ")
        assertFalse(result)
    }
}
