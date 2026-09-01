package tests;

import config.DriverSetup;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class ConstructorTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        driver = DriverSetup.getChromeDriver();
        driver.get(DriverSetup.BASE_URL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void testBunsSection() throws Exception {
        Thread.sleep(2000);

        // Используем JavaScript для клика
        WebElement bunsTab = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[contains(text(),'Булки')]/parent::div")
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", bunsTab);

        Thread.sleep(500);

        boolean visible = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[contains(text(),'Булки')]")
        )).isDisplayed();

        assertTrue("Раздел 'Булки' должен быть виден", visible);
    }

    @Test
    public void testSaucesSection() throws Exception {
        Thread.sleep(2000);

        WebElement saucesTab = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[contains(text(),'Соусы')]/parent::div")
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saucesTab);

        Thread.sleep(500);

        boolean visible = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[contains(text(),'Соусы')]")
        )).isDisplayed();

        assertTrue("Раздел 'Соусы' должен быть виден", visible);
    }

    @Test
    public void testFillingsSection() throws Exception {
        Thread.sleep(2000);

        WebElement fillingsTab = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[contains(text(),'Начинки')]/parent::div")
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", fillingsTab);

        Thread.sleep(500);

        boolean visible = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[contains(text(),'Начинки')]")
        )).isDisplayed();

        assertTrue("Раздел 'Начинки' должен быть виден", visible);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}