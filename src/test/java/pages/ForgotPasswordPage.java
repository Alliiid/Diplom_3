package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BasePage {

    @FindBy(xpath = "//p[contains(text(), 'Вспомнили пароль?')]/a")
    private WebElement loginLink;

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    @Step("Кликнуть ссылку 'Войти' на странице восстановления пароля")
    public void clickLoginLink() {
        click(loginLink);
    }
}