package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@type='text' and @name='name']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[text()='Войти']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[contains(@href, 'register')]")
    private WebElement registerLink;

    @FindBy(xpath = "//a[contains(@href, 'forgot-password')]")
    private WebElement forgotPasswordLink;

    @FindBy(xpath = "//a[contains(@class, 'Auth_link')]")
    private WebElement loginLink;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ввести email: {email}")
    public void setEmail(String email) {
        type(emailInput, email);
    }

    @Step("Ввести пароль")
    public void setPassword(String password) {
        type(passwordInput, password);
    }

    @Step("Кликнуть 'Войти'")
    public void clickLoginButton() {
        click(loginButton);
    }

    @Step("Залогиниться под {email}")
    public void login(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickLoginButton();
    }

    @Step("Кликнуть ссылку 'Зарегистрироваться'")
    public void clickRegisterLink() {
        click(registerLink);
    }

    @Step("Кликнуть ссылку 'Восстановить пароль'")
    public void clickForgotPasswordLink() {
        click(forgotPasswordLink);
    }

    @Step("Кликнуть ссылку 'Войти'")
    public void clickLoginLink() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginLink);
    }

    @Step("Проверить, что кнопка 'Войти' видна")
    public boolean isLoginButtonVisible() {
        return isVisible(loginButton);
    }
}