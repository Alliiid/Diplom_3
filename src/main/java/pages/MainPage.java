package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {

    // Кнопка "Войти в аккаунт" на главной
    @FindBy(xpath = "//button[contains(@class, 'button_button__') and contains(text(), 'Войти')]")
    private WebElement loginButtonMain;

    // Кнопка "Личный кабинет"
    @FindBy(xpath = "//p[contains(text(), 'Личный Кабинет')]")
    private WebElement personalAccountButton;

    // Заголовок "Соберите бургер"
    @FindBy(xpath = "//h1[contains(text(), 'Соберите бургер')]")
    private WebElement headerText;

    // Табы конструктора
    @FindBy(xpath = "//span[contains(text(), 'Булки')]/parent::div")
    private WebElement bunsTab;

    @FindBy(xpath = "//span[contains(text(), 'Соусы')]/parent::div")
    private WebElement saucesTab;

    @FindBy(xpath = "//span[contains(text(), 'Начинки')]/parent::div")
    private WebElement fillingsTab;

    // Секции
    @FindBy(xpath = "//h2[contains(text(), 'Булки')]")
    private WebElement bunsSection;

    @FindBy(xpath = "//h2[contains(text(), 'Соусы')]")
    private WebElement saucesSection;

    @FindBy(xpath = "//h2[contains(text(), 'Начинки')]")
    private WebElement fillingsSection;

    // Кнопка "Оформить заказ" - признак того, что пользователь авторизован
    @FindBy(xpath = "//button[contains(text(), 'Оформить заказ')]")
    private WebElement orderButton;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickLoginButton() {
        try {
            Thread.sleep(2000); // Ждём загрузки страницы
            wait.until(ExpectedConditions.elementToBeClickable(loginButtonMain)).click();
        } catch (Exception e) {
            // Пробуем найти через JavaScript
            WebElement element = driver.findElement(By.xpath("//button[contains(@class, 'button_button__') and contains(text(), 'Войти')]"));
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    public void clickPersonalAccount() {
        try {
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(personalAccountButton)).click();
        } catch (Exception e) {
            WebElement element = driver.findElement(By.xpath("//p[contains(text(), 'Личный Кабинет')]"));
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    public void clickBunsTab() {
        try {
            Thread.sleep(500);
            wait.until(ExpectedConditions.elementToBeClickable(bunsTab)).click();
        } catch (Exception e) {
            WebElement element = driver.findElement(By.xpath("//span[contains(text(), 'Булки')]/parent::div"));
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    public void clickSaucesTab() {
        try {
            Thread.sleep(500);
            wait.until(ExpectedConditions.elementToBeClickable(saucesTab)).click();
        } catch (Exception e) {
            WebElement element = driver.findElement(By.xpath("//span[contains(text(), 'Соусы')]/parent::div"));
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    public void clickFillingsTab() {
        try {
            Thread.sleep(500);
            wait.until(ExpectedConditions.elementToBeClickable(fillingsTab)).click();
        } catch (Exception e) {
            WebElement element = driver.findElement(By.xpath("//span[contains(text(), 'Начинки')]/parent::div"));
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    public boolean isBunsSectionVisible() {
        try {
            Thread.sleep(500);
            return wait.until(ExpectedConditions.visibilityOf(bunsSection)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isSaucesSectionVisible() {
        try {
            Thread.sleep(500);
            return wait.until(ExpectedConditions.visibilityOf(saucesSection)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isFillingsSectionVisible() {
        try {
            Thread.sleep(500);
            return wait.until(ExpectedConditions.visibilityOf(fillingsSection)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Проверка загрузки главной страницы
    public boolean isMainPageLoaded() {
        try {
            Thread.sleep(2000);
            wait.until(ExpectedConditions.visibilityOf(headerText));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Проверка, что пользователь авторизован
    public boolean isUserLoggedIn() {
        try {
            wait.until(ExpectedConditions.visibilityOf(orderButton));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}