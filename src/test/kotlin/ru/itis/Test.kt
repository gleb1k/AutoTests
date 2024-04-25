package ru.itis

import org.junit.Test
import pages.LoginPage
import pages.MainPage
import pages.StartPage
import ru.itis.base.BaseTest
import kotlin.random.Random

class Test : BaseTest() {

    private val loginPage = LoginPage()

    private val mainPage = MainPage()

    private val startPage = StartPage()

    @Test
    fun signInAndCreateFolder() {
        waitLoading(2)
        startPage.loginButton().click()

        waitLoading(4)

        login(LoginPage.EMAIL, LoginPage.PASSWORD)

        mainPage.startCreateFolderButton().click()
        waitLoading(4)
        mainPage.nameField().sendKeys(MainPage.FOLDER_NAME + Random.nextInt())
        waitLoading(4)
        mainPage.endCreateFolderButton().click()
    }

    private fun login(login: String, password: String) {
        loginPage.loginField().sendKeys(login)
        waitLoading(2)
        loginPage.continueButton().click()
        waitLoading(4)
        loginPage.passwordField().sendKeys(password)
        waitLoading(2)
        loginPage.singInButton().click()
        waitLoading(20)

    }

}