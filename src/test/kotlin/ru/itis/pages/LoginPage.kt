package ru.itis.pages

import ru.itis.manager.DriverManager
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

object LoginPage {
    fun loginField(): WebElement = DriverManager.chromeDriver.findElement(By.id("login-name2"))
    fun passwordField(): WebElement = DriverManager.chromeDriver.findElement(By.id("login-password2"))
    fun signInButton(): WebElement = DriverManager.chromeDriver.findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/div[2]/div[2]/div[1]/form/button"))

}