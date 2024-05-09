package ru.itis

import org.junit.Test
import pages.LoginPage
import pages.StoragePage
import pages.StartPage
import ru.itis.base.BaseTest
import kotlin.random.Random

class Test : BaseTest() {

    private val loginPage = LoginPage()

    private val storagePage = StoragePage()

    private val startPage = StartPage()

    @Test
    fun signInAndCreateFolder() {
        waitLoading(2)
        startPage.loginButton().click()

        waitLoading(4)

        login(LoginPage.EMAIL, LoginPage.PASSWORD)

        storagePage.startCreateFolderButton().click()
        waitLoading(4)
        storagePage.nameField().sendKeys(StoragePage.FOLDER_NAME + Random.nextInt())
        waitLoading(4)
        storagePage.endCreateFolderButton().click()
    }

    private fun login(login: String, password: String) {
        loginPage.loginField().sendKeys(login)
        waitLoading(2)
        loginPage.passwordField().sendKeys(password)
        waitLoading(2)
        loginPage.singInButton().click()
        waitLoading(20)
    }

}