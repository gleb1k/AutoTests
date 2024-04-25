package pages

import DriverManager
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class LoginPage {

    val email = "gleb.gafeev2@gmail.com"
    val password = "super_good_password1"

    val driverManager: DriverManager = DriverManager

    //fun loginButton() : WebElement = driverManager.getChromeDriver().findElement(By.className())

}