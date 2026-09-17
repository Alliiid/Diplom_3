package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.MainPage;

import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BaseTest {

    @Test
    @DisplayName("Переход к разделу 'Булки'")
    @Description("Проверка активации таба 'Булки' через className")
    public void testBunsSection() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSaucesTab();   // сначала переключаемся на другой
        mainPage.clickBunsTab();     // потом возвращаемся
        assertTrue("Таб 'Булки' должен быть активен", mainPage.isBunsTabActive());
    }

    @Test
    @DisplayName("Переход к разделу 'Соусы'")
    @Description("Проверка активации таба 'Соусы' через className")
    public void testSaucesSection() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSaucesTab();
        assertTrue("Таб 'Соусы' должен быть активен", mainPage.isSaucesTabActive());
    }

    @Test
    @DisplayName("Переход к разделу 'Начинки'")
    @Description("Проверка активации таба 'Начинки' через className")
    public void testFillingsSection() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickFillingsTab();
        assertTrue("Таб 'Начинки' должен быть активен", mainPage.isFillingsTabActive());
    }
}