package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(xpath = "//button[text()='Войти в аккаунт']")
    private WebElement loginButtonMain;

    @FindBy(xpath = "//p[text()='Личный Кабинет']")
    private WebElement personalAccountButton;

    @FindBy(xpath = "//h1[text()='Соберите бургер']")
    private WebElement headerText;

    @FindBy(xpath = "//span[text()='Булки']/parent::div")
    private WebElement bunsTab;

    @FindBy(xpath = "//span[text()='Соусы']/parent::div")
    private WebElement saucesTab;

    @FindBy(xpath = "//span[text()='Начинки']/parent::div")
    private WebElement fillingsTab;

    @FindBy(xpath = "//button[text()='Оформить заказ']")
    private WebElement orderButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Кликнуть 'Войти в аккаунт'")
    public void clickLoginButton() {
        click(loginButtonMain);
    }

    @Step("Кликнуть 'Личный кабинет'")
    public void clickPersonalAccount() {
        click(personalAccountButton);
    }

    @Step("Кликнуть таб 'Булки'")
    public void clickBunsTab() {
        click(bunsTab);
    }

    @Step("Кликнуть таб 'Соусы'")
    public void clickSaucesTab() {
        click(saucesTab);
    }

    @Step("Кликнуть таб 'Начинки'")
    public void clickFillingsTab() {
        click(fillingsTab);
    }

    @Step("Проверить, что таб 'Булки' активен")
    public boolean isBunsTabActive() {
        return bunsTab.getAttribute("class").contains("tab_tab_type_current");
    }

    @Step("Проверить, что таб 'Соусы' активен")
    public boolean isSaucesTabActive() {
        return saucesTab.getAttribute("class").contains("tab_tab_type_current");
    }

    @Step("Проверить, что таб 'Начинки' активен")
    public boolean isFillingsTabActive() {
        return fillingsTab.getAttribute("class").contains("tab_tab_type_current");
    }

    @Step("Проверить, что главная загружена")
    public boolean isMainPageLoaded() {
        return isVisible(headerText);
    }

    @Step("Проверить, что пользователь авторизован")
    public boolean isUserLoggedIn() {
        return isVisible(orderButton);
    }
}