package tests;

import api.UserApi;
import api.model.User;
import config.DriverSetup;
import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import utils.TestDataGenerator;

import static org.apache.http.HttpStatus.SC_OK;

public abstract class BaseTest {

    protected WebDriver driver;
    protected User testUser;
    protected String accessToken;

    @Before
    @Step("Подготовка: создание пользователя через API и открытие браузера")
    public void setUp() {
        testUser = TestDataGenerator.generateUniqueUser();
        var createResponse = UserApi.createUser(testUser);

        if (createResponse.statusCode() != SC_OK) {
            throw new RuntimeException("Не удалось создать пользователя: " + createResponse.asString());
        }

        accessToken = createResponse.jsonPath().getString("accessToken");
        driver = DriverSetup.getDriver();
        driver.get(DriverSetup.BASE_URL);
    }

    @After
    @Step("Очистка: удаление пользователя через API и закрытие браузера")
    public void tearDown() {
        if (accessToken != null) {
            UserApi.deleteUser(accessToken);
        }
        if (driver != null) {
            driver.quit();
        }
    }
}