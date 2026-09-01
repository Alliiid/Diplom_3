package tests;

import config.DriverSetup;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DebugTest {

    @Test
    public void debugPage() throws Exception {
        WebDriver driver = DriverSetup.getChromeDriver();
        driver.get(DriverSetup.BASE_URL);
        Thread.sleep(3000);

        // Нажимаем "Войти"
        System.out.println("=== НАЖИМАЕМ ВОЙТИ ===");
        driver.findElement(By.xpath("//button[contains(text(), 'Войти')]")).click();
        Thread.sleep(2000);

        // Выводим ВСЕ поля на странице
        System.out.println("\n=== ВСЕ ПОЛЯ INPUT ===");
        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        for (int i = 0; i < inputs.size(); i++) {
            WebElement input = inputs.get(i);
            System.out.println("Поле " + (i+1) + ":");
            System.out.println("  type = " + input.getAttribute("type"));
            System.out.println("  name = " + input.getAttribute("name"));
            System.out.println("  class = " + input.getAttribute("class"));
            System.out.println("  placeholder = " + input.getAttribute("placeholder"));
            System.out.println("---");
        }

        // Выводим ВСЕ кнопки
        System.out.println("\n=== ВСЕ КНОПКИ BUTTON ===");
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        for (int i = 0; i < buttons.size(); i++) {
            WebElement button = buttons.get(i);
            System.out.println("Кнопка " + (i+1) + ":");
            System.out.println("  текст = " + button.getText());
            System.out.println("  class = " + button.getAttribute("class"));
            System.out.println("  type = " + button.getAttribute("type"));
            System.out.println("---");
        }

        // Выводим ВСЕ ссылки
        System.out.println("\n=== ВСЕ ССЫЛКИ A ===");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (int i = 0; i < links.size(); i++) {
            WebElement link = links.get(i);
            System.out.println("Ссылка " + (i+1) + ":");
            System.out.println("  текст = " + link.getText());
            System.out.println("  href = " + link.getAttribute("href"));
            System.out.println("---");
        }

        Thread.sleep(5000);
        driver.quit();
    }
}