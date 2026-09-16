package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    @FindBy(xpath = "//input[@type='text' and @name='name']")
    private WebElement nameInput;

    @FindBy(xpath = "(//input[@type='text'])[2]")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[text()='Зарегистрироваться']")
    private WebElement registerButton;

    @FindBy(xpath = "//a[text()='Войти']")
    private WebElement loginLink;

    @FindBy(xpath = "//p[text()='Некорректный пароль']")
    private WebElement errorMessage;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ввести имя: {name}")
    public void enterName(String name) {
        type(nameInput, name);
    }

    @Step("Ввести email: {email}")
    public void enterEmail(String email) {
        type(emailInput, email);
    }

    @Step("Ввести пароль")
    public void enterPassword(String password) {
        type(passwordInput, password);
    }

    @Step("Кликнуть 'Зарегистрироваться'")
    public void clickRegisterButton() {
        click(registerButton);
    }

    @Step("Зарегистрировать пользователя {email}")
    public void register(String name, String email, String password) {
        enterName(name);
        enterEmail(email);
        enterPassword(password);
        clickRegisterButton();
    }

    @Step("Кликнуть ссылку 'Войти'")
    public void clickLoginLink() {
        click(loginLink);
    }

    @Step("Проверить, что сообщение об ошибке видно")
    public boolean isErrorMessageVisible() {
        return isVisible(errorMessage);
    }
}