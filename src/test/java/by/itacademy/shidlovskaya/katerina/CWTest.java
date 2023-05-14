package by.itacademy.shidlovskaya.katerina;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CWTest {
    ChromeDriver driver;

    @BeforeEach
    public void warmUp() {
        driver = new ChromeDriver();
        driver.get("https://svyatoslav.biz/testlab/wt/index.php");
    }

    @Test
    public void testFillFormWithEmptyData() {
        String buttonCalculateXpath = "//tbody/tr[6]/td/input";
        WebElement buttonCalculateWebElement = driver.findElement(By.xpath(buttonCalculateXpath));
        buttonCalculateWebElement.click();

        String actualMassageXpath = "/html/body/table/tbody/tr[2]/td[2]/form/table/tbody/tr[1]/td/b";
        WebElement actualMassageWebElement = driver.findElement(By.xpath(actualMassageXpath));

        String expectedMassageTest = "Не указано имя.\n" +
                "Рост должен быть в диапазоне 50-300 см.\n" +
                "Вес должен быть в диапазоне 3-500 кг.\n" +
                "Не указан пол.";
        String actualMassageTest = actualMassageWebElement.getText();

        Assertions.assertEquals(expectedMassageTest, actualMassageTest);
    }

    @AfterEach
    public void tearsDown() {
        driver.quit();
    }
}

