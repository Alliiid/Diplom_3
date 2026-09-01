package tests;

import config.DriverSetup;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class RegisterTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        driver = DriverSetup.getChromeDriver();
        driver.get(DriverSetup.BASE_URL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void testSuccessfulRegistration() throws Exception {
        Thread.sleep(3000);

        // Клик на "Войти"
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(), 'Войти')]")
        )).click();
        Thread.sleep(2000);

        // Клик на "Зарегистрироваться"
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(), 'Зарегистрироваться')]")
        )).click();
        Thread.sleep(2000);

        String email = "test_" + System.currentTimeMillis() + "@test.ru";

        // Ввод имени - на странице регистрации поле Имя
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@name='name' and @type='text']")
        )).sendKeys("Test User");

        // Ввод Email - на странице регистрации поле Email тоже type='text'!
        // Но оно второе по счёту, используем другой локатор
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(email);

        // Ввод пароля
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("password123");

        // Клик на "Зарегистрироваться"
        driver.findElement(By.xpath("//button[contains(text(), 'Зарегистрироваться')]")).click();
        Thread.sleep(3000);

        // Проверка - появилась страница входа
        boolean isLoginPage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[contains(text(), 'Войти')]")
        )).isDisplayed();

        assertTrue("Должна быть страница входа", isLoginPage);
    }

    @Test
    public void testShortPasswordError() throws Exception {
        Thread.sleep(3000);

        // Клик на "Войти"
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(), 'Войти')]")
        )).click();
        Thread.sleep(2000);

        // Клик на "Зарегистрироваться"
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(), 'Зарегистрироваться')]")
        )).click();
        Thread.sleep(2000);

        String email = "test_" + System.currentTimeMillis() + "@test.ru";

        // Ввод имени
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@name='name' and @type='text']")
        )).sendKeys("Test User");

        // Ввод Email
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(email);

        // Ввод короткого пароля
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("12345");

        // Клик на "Зарегистрироваться"
        driver.findElement(By.xpath("//button[contains(text(), 'Зарегистрироваться')]")).click();
        Thread.sleep(2000);

        // Проверка сообщения об ошибке
        boolean errorVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[contains(text(), 'Некорректный пароль')]")
        )).isDisplayed();

        assertTrue("Должно быть сообщение об ошибке", errorVisible);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}