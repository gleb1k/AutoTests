package ru.itis.test.base

import org.junit.After
import org.junit.AfterClass
import org.junit.Before
import org.junit.BeforeClass
import ru.itis.actions.Actions
import ru.itis.manager.AuthManager
import ru.itis.manager.DriverManager
import java.io.FileInputStream
import java.util.*

open class AuthBaseTest {
    companion object {

        private val properties = Properties()
        var url: String
        var username: String
        var password: String
        val authManager: AuthManager = AuthManager()

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
            DriverManager.chromeDriver.get(BaseTest.url)
        }

        @JvmStatic
        @AfterClass
        fun closeDriver() {
            DriverManager.chromeDriver.close()
        }

    }

    @Before
    fun setUp() {
        Actions.navigateToStartPage()
        Actions.navigateToLoginPage()
        authManager.login(username, password)
    }

    @After
    fun cleanUp() {
//        DriverManager.chromeDriver.manage().deleteAllCookies()
//        Thread.sleep(1000)
        authManager.logout()
    }
}