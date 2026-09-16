package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {

    @FindBy(xpath = "//button[text()='Выход']")
    private WebElement logoutButton;

    @FindBy(xpath = "//p[text()='Личный Кабинет']")
    private WebElement profileHeader;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @Step("Кликнуть 'Выход'")
    public void clickLogoutButton() {
        click(logoutButton);
    }

    @Step("Проверить, что страница профиля отображается")
    public boolean isProfilePageDisplayed() {
        return isVisible(profileHeader);
    }
}