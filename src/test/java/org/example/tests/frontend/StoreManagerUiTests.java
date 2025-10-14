package org.example.tests.frontend;

import org.example.frontend.models.User;
import org.example.frontend.pages.LoginPage;
import org.example.frontend.pages.MainPage;
import org.example.tests.BaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StoreManagerUiTests extends BaseTest {

    User testUser;
    WebDriver driver;

    @BeforeEach
    void setupData() {
        testUser = useTestUser();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(APP_UI_URL);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);

        driver.findElement(By.cssSelector("#email")).sendKeys(testUser.getEmail());
        driver.findElement(By.cssSelector("#password")).sendKeys(testUser.getPassword());
        driver.findElement(By.cssSelector("button.btn")).click();

        assertTrue(driver.findElement(By.xpath("//a[contains(.,'Личный кабинет')]")).isDisplayed());
    }

    private User useTestUser() {
        return User.builder().email("v@v.ru").password("12345678").build();
    }
}
