package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ForgotPasswordPage extends BasePage {

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    @Step("Кликнуть ссылку 'Войти' на странице восстановления пароля")
    public void clickLoginLink() {
        WebElement link = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//a[@href='/login']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", link);
    }
}