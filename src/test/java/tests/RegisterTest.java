package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;

import static org.junit.Assert.assertTrue;

public class RegisterTest extends BaseTest {

    @Test
    @DisplayName("Успешная регистрация")
    @Description("Проверка успешной регистрации нового пользователя")
    public void testSuccessfulRegistration() {
        String email = "new_" + System.currentTimeMillis() + "@test.ru";
        String password = "password123";
        String name = "Test User";

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegisterLink();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register(name, email, password);

        assertTrue("Должна быть страница входа", loginPage.isLoginButtonVisible());
    }

    @Test
    @DisplayName("Ошибка при коротком пароле")
    @Description("Проверка ошибки при пароле короче 6 символов")
    public void testShortPasswordError() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegisterLink();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register("Test User",
                "short_" + System.currentTimeMillis() + "@test.ru", "12345");

        assertTrue("Должно быть сообщение об ошибке", registerPage.isErrorMessageVisible());
    }
}