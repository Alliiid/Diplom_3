package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ForgotPasswordPage extends BasePage {

    @FindBy(xpath = "//a[contains(@href, '/login') and text()='Войти']")
    private WebElement loginLink;

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    @Step("Кликнуть ссылку 'Войти' на странице восстановления пароля")
    public void clickLoginLink() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginLink);
        wait.until(ExpectedConditions.urlContains("/login"));
    }
}