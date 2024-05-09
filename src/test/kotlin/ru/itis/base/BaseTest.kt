package ru.itis.base

import DriverManager
import org.junit.After
import org.junit.BeforeClass
import java.time.Duration

open class BaseTest {

    val driver = DriverManager.chromeDriver

    fun waitLoading(seconds: Long) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds))
    }

    companion object {

        const val BASE_URL = "https://www.dropbox.com/"

        @JvmStatic
        @BeforeClass
        fun open() {
            //когда тут указываю то ругается на версию хрома
            //ноут
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gleb\\IdeaProjects\\AutoTests2\\chromedriver_win64\\chromedriver.exe")
            //комп
            //System.setProperty("webdriver.chrome.driver", "C:\\Users\\gleb\\IdeaProjects\\AutoTests\\chromedriver_win64\\chromedriver.exe")
            DriverManager.chromeDriver.get(BASE_URL)
            DriverManager.chromeDriver.get(BASE_URL)
        }

        @After
        fun clearCock(){
            DriverManager.chromeDriver.manage().deleteAllCookies()
        }

//        @JvmStatic
//        @AfterClass
//        fun close() {
//            driverInstance.close()
//        }

    }
}