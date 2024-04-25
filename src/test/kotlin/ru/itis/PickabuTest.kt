package ru.itis

import org.junit.Test
import org.openqa.selenium.By
import pages.LoginPage

class PickabuTest : BaseTest() {

    private val loginPage = LoginPage()

    @Test
    fun `Войти и поставить комментарий`() {
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys(loginPage.email)
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(loginPage.password)
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/aside/div[1]/div[1]/div/div[1]/div[2]/form/div[7]/button")).click();
        wait(5)

        driver.findElement(By.cssSelector("a[class='story__comments-link story__to-comments']")).click()
        driver.get(driver.currentUrl)
    }

}