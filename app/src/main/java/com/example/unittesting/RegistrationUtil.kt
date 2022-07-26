package com.example.unittesting

import android.util.Patterns
import java.util.regex.Pattern

object RegistrationUtil {

    private var emailPattern: Pattern = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )

    /**
     * the input is not valid if...
     * username/password is empty
     * password contains less than 2 digits
     * confirmed password is not same as the real password
     */
    fun validateForm(
        username: String,
        password: String,
        confirmedPassword: String
    ): Boolean {
        if (username.isEmpty() || password.isEmpty())
            return false
        if (password.count { it.isDigit() } < 2)
            return false
        if (password != confirmedPassword)
            return false
        return true
    }

    /**
     * the input is not valid if...
     * email is empty
     * email has no Tld
     * email has no username
     * email has double dot
     */
    fun isValidEmail(email: String): Boolean {
        if (email.isEmpty())
            return false
        if (!emailPattern.matcher(email).matches())
            return false
        return true
    }
}