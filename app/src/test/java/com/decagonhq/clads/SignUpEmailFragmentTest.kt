package com.decagonhq.clads

import com.decagonhq.clads.utils.SignUpEmailFragmentValidator
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class SignUpEmailFragmentTest {

    companion object {

        private const val FIRSTNAME: String = "Jones"
        private const val LASTNAME: String = "Omoyibo"
        private const val EMAIL: String = "Jonesbenklins@gmail.com"
        private const val PASSWORD: String = "Benklins"
        private const val CONFIRMPASSWORD: String = "Benklins"
        private const val ACCOUNTCATEGORY: String = "Client"
    }

    @Test
    fun is_FirstName_Not_Empty() {

        assertTrue(SignUpEmailFragmentValidator.nameValidator(FIRSTNAME))
    }

    @Test
    fun is_LastName_Not_Empty() {

        assertTrue(SignUpEmailFragmentValidator.nameValidator(LASTNAME))
    }

    @Test
    fun is_EmailAddress_Valid() {

        assertTrue(SignUpEmailFragmentValidator.emailValidator(EMAIL))
    }

    @Test
    fun is_Password_Valid() {

        assertTrue(SignUpEmailFragmentValidator.passwordValidator(PASSWORD))
    }

    @Test
    fun is_Confirm_Password_Valid() {

        assertTrue(SignUpEmailFragmentValidator.passwordValidator(CONFIRMPASSWORD))
    }

    @Test
    fun do_Passwords_Match() {

        assertTrue(SignUpEmailFragmentValidator.passwordsMatcher(PASSWORD, CONFIRMPASSWORD))
    }

    @Test
    fun is_Account_Category_Valid() {

        assertTrue(SignUpEmailFragmentValidator.accountCategoryValidator(ACCOUNTCATEGORY))
    }
}
