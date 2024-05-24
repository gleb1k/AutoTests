package ru.itis.pages

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import ru.itis.manager.DriverManager

object StartPage {

    fun navigateToStartPage() = DriverManager.chromeDriver.navigate().to("https://mega.io/ru/storage")
    fun loginButton(): WebElement = DriverManager.chromeDriver.findElement(By.xpath("/html/body/header/div[1]/div/div[2]/a[3]"))

}