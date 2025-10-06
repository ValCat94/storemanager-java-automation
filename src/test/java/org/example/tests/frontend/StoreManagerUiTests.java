package org.example.tests.frontend;

import org.example.tests.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StoreManagerUiTests extends BaseTest {

    /*
    http://localhost:8000
     */

    String email;
    String password;

    @BeforeEach
    void useUser() {
        email = "v@v.ru";
        password = "123456";
    }

    @Test
    void loginTest() {
        WebDriver driver = new ChromeDriver();

        /*

         */

        driver.quit();
    }
}
