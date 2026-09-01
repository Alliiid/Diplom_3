package tests;

import config.DriverSetup;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class LoginTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private static final String TEST_EMAIL = "testuser@test.ru";
    private static final String TEST_PASSWORD = "password123";

    @Before
    public void setUp() {
        driver = DriverSetup.getChromeDriver();
        driver.get(DriverSetup.BASE_URL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    @DisplayName("Вход через кнопку «Войти в аккаунт» на главной")
    @Description("Проверка входа через кнопку на главной странице")
    public void testLoginViaMainPageButton() throws Exception {
        Thread.sleep(2000);

        // Клик на "Войти в аккаунт" на главной
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(), 'Войти')]")
        )).click();
        Thread.sleep(1000);

        // Ввод email
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@name='name' and @type='text']")
        )).sendKeys(TEST_EMAIL);

        // Ввод пароля
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(TEST_PASSWORD);

        // Клик на кнопку "Войти"
        driver.findElement(By.xpath("//button[contains(@class, 'button_button__') and contains(text(), 'Войти')]")).click();
        Thread.sleep(3000);

        // Проверка - появилась кнопка "Оформить заказ"
        boolean isLoggedIn = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[contains(text(), 'Оформить заказ')]")
        )).isDisplayed();

        assertTrue("Пользователь должен быть авторизован", isLoggedIn);
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    @Description("Проверка входа через кнопку личного кабинета")
    public void testLoginViaPersonalAccount() throws Exception {
        Thread.sleep(2000);

        // Клик на "Личный кабинет"
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//p[contains(text(), 'Личный Кабинет')]")
        )).click();
        Thread.sleep(1000);

        // Ввод email
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@name='name' and @type='text']")
        )).sendKeys(TEST_EMAIL);

        // Ввод пароля
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(TEST_PASSWORD);

        // Клик на кнопку "Войти"
        driver.findElement(By.xpath("//button[contains(@class, 'button_button__') and contains(text(), 'Войти')]")).click();
        Thread.sleep(3000);

        // Проверка
        boolean isLoggedIn = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[contains(text(), 'Оформить заказ')]")
        )).isDisplayed();

        assertTrue("Пользователь должен быть авторизован", isLoggedIn);
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    @Description("Проверка входа через кнопку в форме регистрации")
    public void testLoginViaRegisterForm() throws Exception {
        Thread.sleep(2000);

        // Клик на "Войти"
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(), 'Войти')]")
        )).click();
        Thread.sleep(1000);

        // Клик на "Зарегистрироваться"
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(), 'Зарегистрироваться')]")
        )).click();
        Thread.sleep(1000);

        // Клик на "Войти" на странице регистрации
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(), 'Войти')]")
        )).click();
        Thread.sleep(1000);

        // Ввод email
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@name='name' and @type='text']")
        )).sendKeys(TEST_EMAIL);

        // Ввод пароля
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(TEST_PASSWORD);

        // Клик на кнопку "Войти"
        driver.findElement(By.xpath("//button[contains(@class, 'button_button__') and contains(text(), 'Войти')]")).click();
        Thread.sleep(3000);

        // Проверка
        boolean isLoggedIn = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[contains(text(), 'Оформить заказ')]")
        )).isDisplayed();

        assertTrue("Пользователь должен быть авторизован", isLoggedIn);
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("Проверка входа через кнопку в форме восстановления пароля")
    public void testLoginViaForgotPasswordForm() throws Exception {
        Thread.sleep(2000);

        // Клик на "Войти"
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(), 'Войти')]")
        )).click();
        Thread.sleep(1000);

        // Клик на "Восстановить пароль"
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(), 'Восстановить пароль')]")
        )).click();
        Thread.sleep(1000);

        // Клик на "Войти" на странице восстановления
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(), 'Войти')]")
        )).click();
        Thread.sleep(1000);

        // Ввод email
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@name='name' and @type='text']")
        )).sendKeys(TEST_EMAIL);

        // Ввод пароля
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(TEST_PASSWORD);

        // Клик на кнопку "Войти"
        driver.findElement(By.xpath("//button[contains(@class, 'button_button__') and contains(text(), 'Войти')]")).click();
        Thread.sleep(3000);

        // Проверка
        boolean isLoggedIn = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[contains(text(), 'Оформить заказ')]")
        )).isDisplayed();

        assertTrue("Пользователь должен быть авторизован", isLoggedIn);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}