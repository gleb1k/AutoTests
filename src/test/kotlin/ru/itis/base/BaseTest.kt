package ru.itis.base

import DriverManager
import org.junit.After
import org.junit.AfterClass
import org.junit.BeforeClass
import java.io.FileInputStream
import java.time.Duration
import java.util.*

open class BaseTest {

    val driver = DriverManager.chromeDriver

    fun waitLoading(seconds: Long) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds))
    }

    companion object {

        private val properties = Properties()
        var url: String
        var username: String
        var password: String

        init {
            properties.load(FileInputStream("config.properties"))

            url = properties.getProperty("url")
            username = properties.getProperty("email")
            password = properties.getProperty("password")
        }

        @JvmStatic
        @BeforeClass
        fun open() {
            //ноут
            //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gleb\\IdeaProjects\\AutoTests2\\chromedriver_win64\\chromedriver.exe")
            //комп
            System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\gleb\\IdeaProjects\\AutoTests\\chromedriver_win64\\chromedriver.exe"
            )
            DriverManager.chromeDriver.get(url)
        }

        @After
        fun clearCookies() {
            DriverManager.chromeDriver.manage().deleteAllCookies()
            Thread.sleep(1000)
        }

        @JvmStatic
        @AfterClass
        fun close() {
            //DriverManager.chromeDriver.close()
        }

    }
}