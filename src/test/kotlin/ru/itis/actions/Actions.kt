package ru.itis.actions

import org.junit.Assert
import org.openqa.selenium.WebElement
import ru.itis.DriverManager
import ru.itis.pages.LoginPage
import ru.itis.pages.StartPage
import ru.itis.pages.StoragePage

object Actions {

    fun navigateToStartPage() {
        StartPage.navigateToStartPage()
        Thread.sleep(2000)
        val loginButton = getLoginButton()
        Assert.assertTrue(loginButton.isDisplayed)

    }
    fun navigateToLoginPage() {
        StartPage.loginButton().click()
        Thread.sleep(10000)
    }
    fun getLoginButton() : WebElement = StartPage.loginButton()

    fun getFolderByTitle(title: String) : WebElement = StoragePage.folder(title)

    fun login(login: String, password: String) {
        Thread.sleep(1000)
        LoginPage.loginField().sendKeys(login)
        Thread.sleep(1000)
        LoginPage.passwordField().sendKeys(password)
        Thread.sleep(1000)
        LoginPage.signInButton().click()
        Thread.sleep(10000)
        Assert.assertEquals(DriverManager.chromeDriver.title, "MEGA")
    }

    fun createFolder(folderName: String) {
        Thread.sleep(4000)
        StoragePage.startCreateFolderButton().click()
        Thread.sleep(1000)
        StoragePage.nameField().sendKeys(folderName)
        Thread.sleep(1000)
        StoragePage.endCreateFolderButton().click()
        Thread.sleep(2000)
        Assert.assertNotNull(getFolderByTitle(folderName))
    }

    fun renameFolder(folderName: String, newName: String) {
        val folderBeforeRenaming = getFolderByTitle(folderName)
        StoragePage.folder(folderName).click()
        Thread.sleep(1000)
        StoragePage.moreButton().click()
        Thread.sleep(1000)
        StoragePage.renameButtonStart().click()
        Thread.sleep(1000)
        StoragePage.renameField().sendKeys(newName)
        Thread.sleep(1000)
        StoragePage.renameButtonEnd().click()
        Thread.sleep(4000)

        val folderAfterRenaming = getFolderByTitle(newName)
        Assert.assertNotEquals(folderBeforeRenaming, folderAfterRenaming)
    }

    fun deleteFolder(folderName: String) {
        StoragePage.folder(folderName).click()
        Thread.sleep(2000)
        StoragePage.deleteFolderButton().click()
        Thread.sleep(2000)
        Assert.assertThrows(org.openqa.selenium.NoSuchElementException::class.java) {
            getFolderByTitle(folderName)
        }
    }

    fun logout() {
        Thread.sleep(2000)
        StoragePage.profile().click()
        Thread.sleep(2000)
        StoragePage.exitButtonInProfile().click()
        Thread.sleep(2000)
        StartPage.navigateToStartPage()
    }
}