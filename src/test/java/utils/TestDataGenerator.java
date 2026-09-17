package utils;

import api.model.User;
import com.github.javafaker.Faker;

import java.util.UUID;

public class TestDataGenerator {

    private static final Faker faker = new Faker();

    public static User generateUniqueUser() {
        String uniqueId = UUID.randomUUID().toString().substring(0, 8);
        return User.builder()
                .email("test_" + uniqueId + "@example.com")
                .password("password123")
                .name("TestUser_" + uniqueId)
                .build();
    }
}