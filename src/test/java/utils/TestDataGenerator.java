package utils;

import api.model.User;
import com.github.javafaker.Faker;

public class TestDataGenerator {

    private static final Faker faker = new Faker();

    public static User generateUniqueUser() {
        return User.builder()
                .email(faker.internet().emailAddress())
                .password("password123")
                .name(faker.name().firstName())
                .build();
    }
}