package pages

import DriverManager
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

class LoginPage {

    private val driver: WebDriver = DriverManager.chromeDriver

    fun loginField(): WebElement = driver.findElement(By.id("login-name2"))
    fun passwordField(): WebElement = driver.findElement(By.id("login-password2"))
    fun signInButton(): WebElement = driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/div[2]/div[2]/div[1]/form/button"))


    companion object {
        const val EMAIL = "gleb.gafeev2@gmail.com"
        const val PASSWORD = "super_good_password"
    }
}