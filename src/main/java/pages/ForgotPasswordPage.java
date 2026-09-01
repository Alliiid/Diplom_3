package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ForgotPasswordPage extends BasePage {

    @FindBy(xpath = "//button[contains(text(), 'Восстановить')]")
    private WebElement restoreButton;

    @FindBy(xpath = "//a[contains(@href, 'login')]")
    private WebElement loginLink;

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickLoginLink() {
        try {
            Thread.sleep(500);
            wait.until(ExpectedConditions.elementToBeClickable(loginLink)).click();
        } catch (Exception e) {
            WebElement element = driver.findElement(By.xpath("//a[contains(@href, 'login')]"));
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }
}