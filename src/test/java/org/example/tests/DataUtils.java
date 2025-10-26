package org.example.tests;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DataUtils {

    public static String generateRandomLetters(int length) {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        return IntStream.range(0, length)
                .map(i -> random.nextInt(letters.length()))
                .mapToObj(index -> String.valueOf(letters.charAt(index)))
                .collect(Collectors.joining());
    }
}
