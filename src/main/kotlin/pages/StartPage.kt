package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

class StartPage {

    private val driver: WebDriver = DriverManager.chromeDriver()

    fun loginButton(): WebElement = driver.findElement(By.xpath("/html/body/div[1]/div/div/nav/div[2]/div[3]/a"))

}