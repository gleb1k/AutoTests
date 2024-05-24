package ru.itis.test

import org.junit.Assert.assertFalse
import ru.itis.actions.Actions
import org.junit.Test
import ru.itis.pages.StoragePage
import ru.itis.test.base.AuthBaseTest.Companion.authManager
import ru.itis.test.base.BaseTest
import kotlin.random.Random

class TestWithoutAuth : BaseTest() {

    @Test
    fun signIn() {
        Actions.navigateToStartPage()
        Actions.navigateToLoginPage()
        Actions.login(username, password)
        Actions.logout()
    }

    @Test
    fun signInFail() {
        Actions.navigateToStartPage()
        Actions.navigateToLoginPage()
        Actions.loginFailed("oaoaao", "aoasosa")

        assertFalse(authManager.getCurrentUserLogin() != null)
    }

}