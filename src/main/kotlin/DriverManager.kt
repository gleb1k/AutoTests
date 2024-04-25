import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

object DriverManager {
    @Volatile
    private var chromeDriver: ChromeDriver? = null

    fun getChromeDriver(): WebDriver = chromeDriver ?: synchronized(this) {
        chromeDriver ?: ChromeDriver().also { chromeDriver = ChromeDriver() }
    }

}