package ru.itis

import actions.Actions
import org.junit.Assert
import org.junit.Test
import pages.LoginPage
import pages.StoragePage
import ru.itis.base.BaseTest
import kotlin.random.Random
import kotlin.random.nextInt

class Test : BaseTest() {

    private val actions = Actions()

    private fun toStartThenLogin() {
        actions.navigateToStartPage()
        val loginButton = actions.getLoginButton()
        Assert.assertTrue(loginButton.isDisplayed)

        actions.navigateToLoginPage()
        actions.login(LoginPage.EMAIL, LoginPage.PASSWORD)
    }

    @Test
    fun signIn() {
        toStartThenLogin()
        Assert.assertEquals(driver.title, "MEGA")
        actions.logout()
    }

    @Test
    fun signInAndCreateFolder() {
        toStartThenLogin()
        waitLoading(6)
        val folderName = StoragePage.FOLDER_NAME + Random.nextInt()
        actions.createFolder(folderName)
        Assert.assertNotNull(actions.getFolderByTitle(folderName))
        actions.logout()
    }

    @Test
    fun signInAndEditFolder() {
        toStartThenLogin()
        val folderName = StoragePage.FOLDER_NAME + Random.nextInt()
        actions.createFolder(folderName)
        val folderBeforeRenaming = actions.getFolderByTitle(folderName)
        val renamedFolderName = "folderRenamed" + Random.nextInt()
        actions.renameFolder(folderName, renamedFolderName)
        val folderAfterRenaming = actions.getFolderByTitle(renamedFolderName)
        Assert.assertNotEquals(folderBeforeRenaming, folderAfterRenaming)
        actions.logout()
    }

    @Test
    fun signInAndDeleteFolder() {
        toStartThenLogin()
        val folderName = StoragePage.FOLDER_NAME + Random.nextInt()
        actions.createFolder(folderName)
        actions.deleteFolder(folderName)
        Assert.assertThrows(org.openqa.selenium.NoSuchElementException::class.java) { actions.getFolderByTitle(folderName) }
        actions.logout()
    }
}