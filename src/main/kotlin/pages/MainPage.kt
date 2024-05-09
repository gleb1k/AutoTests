package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

class MainPage {

    private val driver: WebDriver = DriverManager.chromeDriver

    fun startCreateFolderButton(): WebElement = driver.findElement(By.xpath("/html/body/div[2]/div[6]/div/div/div/div/div[2]/div/div[1]/div/div/div[3]/div/button"))
    fun nameField(): WebElement = driver.findElement(By.xpath("/html/body/div[10]/div/div/div/div[2]/div[1]/span/input"))

    fun endCreateFolderButton(): WebElement = driver.findElement(By.xpath("/html/body/div[10]/div/div/div/div[3]/button[2]"))
    companion object {
        const val FOLDER_NAME = "test folder"
    }
}