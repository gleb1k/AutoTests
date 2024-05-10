package actions

import pages.LoginPage
import pages.StartPage
import pages.StoragePage

class Actions {
    private val loginPage = LoginPage()

    private val storagePage = StoragePage()

    private val startPage = StartPage()

    fun navigateToLoginPage() {
        startPage.loginButton().click()
    }

    fun login(login: String, password: String) {
        loginPage.loginField().sendKeys(login)
        loginPage.passwordField().sendKeys(password)
        loginPage.singInButton().click()

        Thread.sleep(8000)
    }

    fun createFolder(folderName: String) {
        Thread.sleep(2000)
        storagePage.startCreateFolderButton().click()
        storagePage.nameField().sendKeys(folderName)
        storagePage.endCreateFolderButton().click()
    }

    fun logout() {
        storagePage.profile().click()
        storagePage.exitButtonInProfile().click()
        startPage.navigateToStartPage()
    }
}