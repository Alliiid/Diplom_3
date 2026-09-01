package tests;

import config.DriverSetup;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ButtonTest {

    @Test
    public void testClickButton() throws Exception {
        WebDriver driver = DriverSetup.getChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get(DriverSetup.BASE_URL);
        Thread.sleep(3000);

        // 1. Клик на "Войти"
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(), 'Войти')]")
        ));
        loginBtn.click();
        Thread.sleep(2000);

        // 2. Вводим email
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@name='name' and @type='text']")
        ));
        emailField.sendKeys("testuser@test.ru");
        System.out.println("Email введен: " + emailField.getAttribute("value"));

        // 3. Вводим пароль
        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        passwordField.sendKeys("password123");
        System.out.println("Пароль введен: " + passwordField.getAttribute("value"));

        // 4. Пробуем нажать "Войти" разными способами
        System.out.println("\n=== ПРОБУЕМ НАЖАТЬ КНОПКУ ===\n");

        // Способ 1: обычный клик
        try {
            WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(@class, 'button_button__') and contains(text(), 'Войти')]")
            ));
            submitBtn.click();
            System.out.println("Способ 1: обычный клик - выполнен");
        } catch (Exception e) {
            System.out.println("Способ 1: обычный клик - НЕ РАБОТАЕТ");
        }

        Thread.sleep(2000);

        // Способ 2: JavaScript клик
        try {
            WebElement submitBtn = driver.findElement(
                    By.xpath("//button[contains(@class, 'button_button__') and contains(text(), 'Войти')]")
            );
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitBtn);
            System.out.println("Способ 2: JavaScript клик - выполнен");
        } catch (Exception e) {
            System.out.println("Способ 2: JavaScript клик - НЕ РАБОТАЕТ");
        }

        Thread.sleep(5000);

        // Проверяем, что на главной
        try {
            boolean isMain = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//h1[contains(text(), 'Соберите бургер')]")
            )).isDisplayed();
            System.out.println("На главной: " + isMain);
        } catch (Exception e) {
            System.out.println("На главной: НЕТ");
        }

        driver.quit();
    }
}