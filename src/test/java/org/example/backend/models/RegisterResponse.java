package org.example.backend.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
// Аннотации Lombok для автоматической генерации геттеров, сеттеров, конструкторов и других методов
public class RegisterResponse {
    // Поля класса, представляющие данные для ответа об успешной регистрации пользователя
    String message;
    String name;

}
