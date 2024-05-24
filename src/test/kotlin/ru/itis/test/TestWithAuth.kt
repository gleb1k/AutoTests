package ru.itis.test

import org.junit.Test
import ru.itis.actions.Actions
import ru.itis.pages.StoragePage
import ru.itis.test.base.AuthBaseTest
import kotlin.random.Random

class TestWithAuth : AuthBaseTest() {
    @Test
    fun createFolder() {
        val folders = FolderParser.getFoldersFromFile("generated")
        folders.forEach {
            Actions.createFolder(it.name)
        }
    }

    @Test
    fun editFolder() {
        val folderName = StoragePage.FOLDER_NAME + Random.nextInt()
        Actions.createFolder(folderName)
        val renamedFolderName = "folderRenamed" + Random.nextInt()
        Actions.renameFolder(folderName, renamedFolderName)
    }

    @Test
    fun deleteFolder() {
        val folderName = StoragePage.FOLDER_NAME + Random.nextInt()
        Actions.createFolder(folderName)
        Actions.deleteFolder(folderName)
    }
}