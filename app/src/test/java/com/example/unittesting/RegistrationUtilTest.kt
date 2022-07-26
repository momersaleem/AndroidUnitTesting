package com.example.unittesting

import com.google.common.truth.Truth.assertThat
import org.junit.Test


internal class RegistrationUtilTest {

    @Test
    fun `empty username returns false`() {
        val result = RegistrationUtil.validateForm(
            "",
            "ab1cd3ef",
            "ab1cd3ef"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `empty password returns false`() {
        val result = RegistrationUtil.validateForm(
            "username",
            "",
            "ab1cd3ef"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `less than 2 digits password returns false`() {
        val result = RegistrationUtil.validateForm(
            "",
            "ab1cd3ef",
            "ab1cd3ef"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `incorrectly confirmed password returns false`() {
        val result = RegistrationUtil.validateForm(
            "",
            "ab1cd3ef",
            "ab1cd3eff"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `valid username and repeated password returns true`() {
        val result = RegistrationUtil.validateForm(
            "username",
            "ab1cd3ef",
            "ab1cd3ef"
        )
        assertThat(result).isTrue()
    }

    @Test
    fun emailValidator_EmptyString_ReturnsFalse() {
        assertThat(RegistrationUtil.isValidEmail("")).isFalse()
    }

    @Test
    fun emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertThat(RegistrationUtil.isValidEmail("name@email.com")).isTrue()
    }

    @Test
    fun emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
        assertThat(RegistrationUtil.isValidEmail("name@email.co.uk")).isTrue()
    }

    @Test
    fun emailValidator_InvalidEmailNoTld_ReturnsFalse() {
        assertThat(RegistrationUtil.isValidEmail("name@email")).isFalse()
    }

    @Test
    fun emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
        assertThat(RegistrationUtil.isValidEmail("name@email..com")).isFalse()
    }

    @Test
    fun emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
        assertThat(RegistrationUtil.isValidEmail("@email.com")).isFalse()
    }
}