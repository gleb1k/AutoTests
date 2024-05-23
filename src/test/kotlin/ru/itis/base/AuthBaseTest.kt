package ru.itis.base

import org.junit.AfterClass
import org.junit.Before
import ru.itis.DriverManager
import java.io.FileInputStream
import java.util.*

open class AuthBaseTest {
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
        @AfterClass
        fun closeDriver() {
            DriverManager.chromeDriver.close()
        }
    }

    @Before
    fun setUp() {
        DriverManager.chromeDriver.get(url)

//        val authManager = AuthManager()
//        val user = User()
//        authManager.login(user.username, user.password)
    }
}