package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    // Поле Email
    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailInput;

    // Поле Пароль
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInput;

    // Кнопка "Войти"
    @FindBy(xpath = "//button[contains(@class, 'button_button__') and contains(text(), 'Войти')]")
    private WebElement loginButton;

    // Ссылка "Зарегистрироваться"
    @FindBy(xpath = "//a[contains(@href, 'register')]")
    private WebElement registerLink;

    // Ссылка "Восстановить пароль"
    @FindBy(xpath = "//a[contains(@href, 'forgot-password')]")
    private WebElement forgotPasswordLink;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void setEmail(String email) {
        try {
            Thread.sleep(500);
            WebElement element = wait.until(ExpectedConditions.visibilityOf(emailInput));
            element.clear();
            element.sendKeys(email);
        } catch (Exception e) {
            WebElement element = driver.findElement(By.xpath("//input[@name='email']"));
            element.clear();
            element.sendKeys(email);
        }
    }

    public void setPassword(String password) {
        try {
            Thread.sleep(500);
            WebElement element = wait.until(ExpectedConditions.visibilityOf(passwordInput));
            element.clear();
            element.sendKeys(password);
        } catch (Exception e) {
            WebElement element = driver.findElement(By.xpath("//input[@name='password']"));
            element.clear();
            element.sendKeys(password);
        }
    }

    public void clickLoginButton() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        } catch (Exception e) {
            WebElement element = driver.findElement(By.xpath("//button[contains(@class, 'button_button__') and contains(text(), 'Войти')]"));
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    public void login(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickLoginButton();
    }

    public void clickRegisterLink() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(registerLink)).click();
        } catch (Exception e) {
            WebElement element = driver.findElement(By.xpath("//a[contains(@href, 'register')]"));
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    public void clickForgotPasswordLink() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordLink)).click();
        } catch (Exception e) {
            WebElement element = driver.findElement(By.xpath("//a[contains(@href, 'forgot-password')]"));
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    public boolean isLoginButtonVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(loginButton)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}