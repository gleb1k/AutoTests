package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

class StartPage {

    private val driver: WebDriver = DriverManager.chromeDriver

    fun navigateToStartPage() = driver.navigate().to("https://mega.io/ru/storage")
    fun loginButton(): WebElement = driver.findElement(By.xpath("/html/body/header/div[1]/div/div[2]/a[3]"))

}