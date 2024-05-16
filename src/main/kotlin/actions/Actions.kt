package actions

import org.openqa.selenium.WebElement
import pages.LoginPage
import pages.StartPage
import pages.StoragePage

class Actions {
    private val loginPage = LoginPage()

    private val storagePage = StoragePage()

    private val startPage = StartPage()

    fun navigateToStartPage() {
        startPage.navigateToStartPage()
        Thread.sleep(2000)
    }
    fun navigateToLoginPage() {
        startPage.loginButton().click()
        Thread.sleep(10000)
    }

    fun getLoginButton() : WebElement = startPage.loginButton()

    fun getFolderByTitle(title: String) : WebElement = storagePage.folder(title)

    fun login(login: String, password: String) {
        Thread.sleep(1000)
        loginPage.loginField().sendKeys(login)
        Thread.sleep(1000)
        loginPage.passwordField().sendKeys(password)
        Thread.sleep(1000)
        loginPage.signInButton().click()

        Thread.sleep(10000)
    }

    fun createFolder(folderName: String) {
        Thread.sleep(4000)
        storagePage.startCreateFolderButton().click()
        Thread.sleep(1000)
        storagePage.nameField().sendKeys(folderName)
        Thread.sleep(1000)
        storagePage.endCreateFolderButton().click()
        Thread.sleep(2000)
    }

    fun renameFolder(folderName: String, newName: String) {
        storagePage.folder(folderName).click()
        Thread.sleep(1000)
        storagePage.moreButton().click()
        Thread.sleep(1000)
        storagePage.renameButtonStart().click()
        Thread.sleep(1000)
        storagePage.renameField().sendKeys(newName)
        Thread.sleep(1000)
        storagePage.renameButtonEnd().click()
        Thread.sleep(4000)
    }

    fun deleteFolder(folderName: String) {
        storagePage.folder(folderName).click()
        Thread.sleep(2000)
        storagePage.deleteFolderButton().click()
        Thread.sleep(2000)
    }

    fun logout() {
        Thread.sleep(2000)
        storagePage.profile().click()
        Thread.sleep(2000)
        storagePage.exitButtonInProfile().click()
        Thread.sleep(2000)
        startPage.navigateToStartPage()
    }
}