package org.example.tests.backend;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.backend.models.RegisterRequest;
import org.junit.jupiter.api.Test;

public class StoreManagerApiTests {

    public static final String BASE_URL = "http://localhost:8001/";
    public static final String REGISTER_ENDPOINT = "register/";
    public static final String BODY = """
            {
                "name": "new_name",
                "email": "new_email@example.com",
                "password": "123456"
            }
    """;

    @Test
    void firstApiTest() {
        /*
        В рамках этого теста нам потребуется реализовать первый API запрос и проверить результаты.

        1. Сначала можно написать первичную версию и убедиться, что запрос в целом работает
        2. Далее можно немного улучшать
        3. Добавляем сериализацию и десериализацию
        4. Используем константы с URL приложения и эндпоинтом
        5. Выносим отправку запроса в отдельный метод для более удобного использования
         */

        RegisterRequest request = new RegisterRequest("Valeria", "v@test.com", "123212345");

        Response response = RestAssured
                .given()
                    .baseUri(BASE_URL)
                    .basePath(REGISTER_ENDPOINT)
                    .contentType(ContentType.JSON)
                    .body(request)
                    .log()
                    .all()
                .when()
                    .post()
                .then()
                    .log()
                    .all()
                    .extract()
                    .response();
    }

}
