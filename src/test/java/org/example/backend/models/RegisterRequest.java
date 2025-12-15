package org.example.backend.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

// Аннотации Lombok для автоматической генерации геттеров, сеттеров, конструкторов и других методов
@Data
@AllArgsConstructor
@Builder
public class RegisterRequest {

    // Поля класса, представляющие данные для регистрации пользователя
    String name;
    String email;
    String password;

    // Метод для генерации экземпляра RegisterRequest с случайными данными
    // Используется паттерн Builder для создания объекта
    // email генерируется как текущее время в миллисекундах + "@email.com"
    // name генерируется как "user_" + текущее время в миллисекундах
    // password генерируется как "pass_" + текущее время в миллисекундах
    public static RegisterRequest generate() {
        return RegisterRequest.builder()
                .email(System.currentTimeMillis() + "@email.com")
                .name("user_" + System.currentTimeMillis())
                .password("pass_" + System.currentTimeMillis())
                .build();
    }
}

