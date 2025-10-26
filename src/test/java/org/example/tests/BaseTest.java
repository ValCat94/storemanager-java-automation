package org.example.tests;

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

}
