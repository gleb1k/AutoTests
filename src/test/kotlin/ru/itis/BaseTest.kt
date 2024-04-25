package ru.itis

import DriverManager
import org.junit.After
import org.junit.BeforeClass
import java.time.Duration

open class BaseTest {

    val driver = DriverManager.getChromeDriver()

    fun wait(seconds: Int) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2))
    }

    companion object {

        const val BASE_URL = "https://pikabu.ru/"

        @JvmStatic
        @BeforeClass
        fun open() {
            //когда тут указываю то ругается на версию хрома
            //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gleb\\IdeaProjects\\AutoTest\\chromedriver_win32\\chromedriver.exe")
            DriverManager.getChromeDriver().get(BASE_URL)
        }

        @After
        fun clearCock(){
            DriverManager.getChromeDriver().manage().deleteAllCookies()
        }

//        @JvmStatic
//        @AfterClass
//        fun close() {
//            driverInstance.close()
//        }

    }
}