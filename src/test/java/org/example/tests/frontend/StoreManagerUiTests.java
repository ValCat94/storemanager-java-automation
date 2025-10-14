package org.example.tests.frontend;

import org.example.frontend.models.User;
import org.example.tests.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StoreManagerUiTests extends BaseTest {

    User testUser;
    String email;
    String password;

    @BeforeEach
    void useUser() {
        testUser = useTestUser();
    }

    private User useTestUser() {
        return User.builder().email("v@v.ru").password("12345678").build();
    }

    @Test
    void loginTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(APP_UI_URL);

        driver.findElement(By.cssSelector("#email")).sendKeys(email);
        driver.findElement(By.cssSelector("#password")).sendKeys(password);
        driver.findElement(By.cssSelector("button.btn")).click();

        assertTrue(driver.findElement(By.xpath("//a[contains(.,'Личный кабинет')]")).isDisplayed());

        driver.quit();
    }
}
