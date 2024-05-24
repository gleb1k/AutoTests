package ru.itis.manager

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

object DriverManager {
    val chromeDriver: ChromeDriver

    init {
        val options = ChromeOptions()
        options.setAcceptInsecureCerts(true)
        chromeDriver = ChromeDriver(options)
    }

}