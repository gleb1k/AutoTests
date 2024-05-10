package ru.itis

import actions.Actions
import org.junit.Test
import pages.LoginPage
import pages.StoragePage
import pages.StartPage
import ru.itis.base.BaseTest
import kotlin.random.Random

class Test : BaseTest() {

    private val actions = Actions()

    @Test
    fun signIn() {
        waitLoading(2)
        actions.navigateToLoginPage()
        waitLoading(4)
        actions.login(LoginPage.EMAIL, LoginPage.PASSWORD)
        waitLoading(6)

        actions.logout()
    }

    @Test
    fun signInAndCreateFolder() {
        waitLoading(2)
        actions.navigateToLoginPage()
        waitLoading(4)
        actions.login(LoginPage.EMAIL, LoginPage.PASSWORD)
        waitLoading(6)
        actions.createFolder(StoragePage.FOLDER_NAME + Random.nextInt())

        actions.logout()
    }
    @Test
    fun signInAndEditFolder() {

    }
    @Test
    fun signInAndDeleteFolder() {

    }
}