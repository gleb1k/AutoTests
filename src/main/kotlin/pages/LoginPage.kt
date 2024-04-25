package pages

import DriverManager
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

class LoginPage {

    private val driver: WebDriver = DriverManager.chromeDriver()

   // fun loginField(): WebElement = driver.findElement(By.cssSelector("input[name='susi_email']"))"/html/body/div[1]/div[2]/div/div/div/div/div/div/div/div[2]/form/div[1]/div[1]/input[1]"

    fun loginField(): WebElement = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/div/div/div[2]/form/div[1]/div[1]/input[1]"))
    fun passwordField(): WebElement = driver.findElement(By.cssSelector("input[name='login_password']"))

    fun continueButton(): WebElement = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/div/div/div[2]/form/div[2]/div/button"))

    fun singInButton(): WebElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div/div/div/div/div/div[3]/div/div/form/button"))

    companion object {
        const val EMAIL = "gleb.gafeev2@gmail.com"
        const val PASSWORD = "super_good_password1"
    }
}