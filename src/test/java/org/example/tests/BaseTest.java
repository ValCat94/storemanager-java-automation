package org.example.tests;

import org.example.frontend.models.User;

public abstract class BaseTest {
    public static final String APP_UI_URL = "http://localhost:8001";

    // Константы для использования в API запросах
    public static final String BASE_URL = "";
    public static final String REGISTER_ENDPOINT = "";

    protected void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected void sleep(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected User useTestUser() {
        return User.builder().email("v2@v.ru").password("85456525").build();
    }

}
