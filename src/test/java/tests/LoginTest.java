package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    @DisplayName("Вход через кнопку 'Войти в аккаунт' на главной")
    @Description("Проверка входа через кнопку на главной странице")
    public void testLoginViaMainPageButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(testUser.getEmail(), testUser.getPassword());

        assertTrue("Пользователь должен быть авторизован", mainPage.isUserLoggedIn());
    }

    @Test
    @DisplayName("Вход через кнопку 'Личный кабинет'")
    @Description("Проверка входа через кнопку личного кабинета")
    public void testLoginViaPersonalAccount() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccount();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(testUser.getEmail(), testUser.getPassword());

        assertTrue("Пользователь должен быть авторизован", mainPage.isUserLoggedIn());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    @Description("Проверка входа через кнопку в форме регистрации")
    public void testLoginViaRegisterForm() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegisterLink();
        loginPage.clickLoginLink();      // ← единый локатор
        loginPage.login(testUser.getEmail(), testUser.getPassword());

        assertTrue("Пользователь должен быть авторизован", mainPage.isUserLoggedIn());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("Проверка входа через кнопку в форме восстановления пароля")
    public void testLoginViaForgotPasswordForm() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickForgotPasswordLink();
        loginPage.clickLoginLink();
        loginPage.login(testUser.getEmail(), testUser.getPassword());

        assertTrue("Пользователь должен быть авторизован", mainPage.isUserLoggedIn());
    }
}