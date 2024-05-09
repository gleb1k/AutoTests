package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

class StoragePage {

    private val driver: WebDriver = DriverManager.chromeDriver

    fun startCreateFolderButton(): WebElement = driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[3]/div[1]/div[7]/div[4]/div[3]/button[1]"))
    fun nameField(): WebElement = driver.findElement(By.xpath("/html/body/div[13]/div[2]/div[1]/input"))

    fun endCreateFolderButton(): WebElement = driver.findElement(By.xpath("/html/body/div[13]/div[3]/button[1]"))
    companion object {
        const val FOLDER_NAME = "test folder"
    }
}