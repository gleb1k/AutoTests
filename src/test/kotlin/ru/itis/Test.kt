package ru.itis

import ru.itis.actions.Actions
import org.junit.Assert
import org.junit.Test
import ru.itis.pages.StoragePage
import ru.itis.base.BaseTest
import kotlin.random.Random

class Test : BaseTest() {

    private fun toStartThenLogin() {
        Actions.navigateToStartPage()
        Actions.navigateToLoginPage()
        Actions.login(username, password)
    }

    @Test
    fun signIn() {
        toStartThenLogin()
        Actions.logout()
    }

    @Test
    fun signInAndCreateFolder() {
        toStartThenLogin()
        waitLoading(6)
        val folders = FolderParser.getFoldersFromFile("generated")
        folders.forEach {
            Actions.createFolder(it.name)
        }
        Actions.logout()
    }

    @Test
    fun signInAndEditFolder() {
        toStartThenLogin()
        val folderName = StoragePage.FOLDER_NAME + Random.nextInt()
        Actions.createFolder(folderName)
        val renamedFolderName = "folderRenamed" + Random.nextInt()
        Actions.renameFolder(folderName, renamedFolderName)
        Actions.logout()
    }

    @Test
    fun signInAndDeleteFolder() {
        toStartThenLogin()
        val folderName = StoragePage.FOLDER_NAME + Random.nextInt()
        Actions.createFolder(folderName)
        Actions.deleteFolder(folderName)
        Actions.logout()
    }
}