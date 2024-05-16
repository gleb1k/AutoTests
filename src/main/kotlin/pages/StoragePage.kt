package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

class StoragePage {

    private val driver: WebDriver = DriverManager.chromeDriver

    fun startCreateFolderButton(): WebElement = driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[3]/div[1]/div[7]/div[4]/div[3]/button[1]"))
    fun nameField(): WebElement = driver.findElement(By.xpath("/html/body/div[13]/div[2]/div[1]/input"))
    fun endCreateFolderButton(): WebElement = driver.findElement(By.xpath("/html/body/div[13]/div[3]/button[1]"))
    fun profile() : WebElement = driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[3]/div[1]/div[4]/section[1]/div[7]/div[8]/button/div[1]"))
    fun exitButtonInProfile(): WebElement =driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[3]/div[1]/div[4]/section[1]/div[7]/div[8]/div/div/div[2]/ul/li[7]/button"))

    //delete
    fun folder(title: String): WebElement = driver.findElement(By.xpath("//span[contains(text(), '$title')]"))
    fun deleteFolderButton() : WebElement = driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[3]/div[1]/div[7]/div[46]/div/button[19]"))

    //edit
    fun moreButton(): WebElement = driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[3]/div[1]/div[7]/div[46]/div/button[21]"))
    fun renameButtonStart(): WebElement = driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[2]/div[10]/a[1]"))
    fun renameField(): WebElement = driver.findElement(By.name("dialog-rename"))
    fun renameButtonEnd(): WebElement = driver.findElement(By.xpath("/html/body/section[5]/div[15]/footer/div/button[2]"))



    companion object {
        const val FOLDER_NAME = "test folder"
    }
}