package ru.itis.base

import DriverManager
import org.junit.After
import org.junit.AfterClass
import org.junit.BeforeClass
import java.time.Duration

open class BaseTest {

    val driver = DriverManager.chromeDriver

    fun waitLoading(seconds: Long) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds))
    }

    companion object {

        private const val BASE_URL = "https://mega.io/ru/storage"

        @JvmStatic
        @BeforeClass
        fun open() {
            //когда тут указываю то ругается на версию хрома
            //ноут
            //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gleb\\IdeaProjects\\AutoTests2\\chromedriver_win64\\chromedriver.exe")
            //комп
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\gleb\\IdeaProjects\\AutoTests\\chromedriver_win64\\chromedriver.exe")
            DriverManager.chromeDriver.get(BASE_URL)
        }

        @After
        fun clearCookies(){
            DriverManager.chromeDriver.manage().deleteAllCookies()
            Thread.sleep(2000)
           // DriverManager.chromeDriver.navigate().to(BASE_URL)
        }

        @JvmStatic
        @AfterClass
        fun close() {
            //DriverManager.chromeDriver.close()
        }

    }
}