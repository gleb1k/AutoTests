package ru.itis

import actions.Actions
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
        actions.navigateToLoginPage()
        actions.login(LoginPage.EMAIL, LoginPage.PASSWORD)
    }

    @Test
    fun signIn() {
        toStartThenLogin()
        actions.logout()
    }

    @Test
    fun signInAndCreateFolder() {
        toStartThenLogin()
        waitLoading(6)
        actions.createFolder(StoragePage.FOLDER_NAME + Random.nextInt())
        actions.logout()
    }
    @Test
    fun signInAndEditFolder() {
        toStartThenLogin()
        val folderName = StoragePage.FOLDER_NAME + Random.nextInt()
        actions.createFolder(folderName)
        actions.renameFolder(folderName, "folderRenamed" +  Random.nextInt())
        actions.logout()
    }
    @Test
    fun signInAndDeleteFolder() {
        toStartThenLogin()
        val folderName = StoragePage.FOLDER_NAME + Random.nextInt()
        actions.createFolder(folderName)
        actions.deleteFolder(folderName)
        actions.logout()
    }
}