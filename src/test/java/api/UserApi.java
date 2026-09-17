package api;

import api.model.User;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserApi {

    private static final String BASE_URL = "https://stellarburgers.education-services.ru";
    private static final String REGISTER = "/api/auth/register";
    private static final String LOGIN = "/api/auth/login";
    private static final String USER = "/api/auth/user";

    @Step("Создать пользователя через API: {user.email}")
    public static Response createUser(User user) {
        return given()
                .header("Content-Type", "application/json")
                .body(user)
                .post(BASE_URL + REGISTER);
    }

    @Step("Залогинить пользователя через API")
    public static Response loginUser(User user) {
        return given()
                .header("Content-Type", "application/json")
                .body(user)
                .post(BASE_URL + LOGIN);
    }

    @Step("Удалить пользователя по токену")
    public static Response deleteUser(String accessToken) {
        return given()
                .header("Authorization", accessToken)
                .delete(BASE_URL + USER);
    }
}