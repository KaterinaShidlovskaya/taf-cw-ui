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

        String expectedMassageText = "Не указано имя.\n" +
                "Рост должен быть в диапазоне 50-300 см.\n" +
                "Вес должен быть в диапазоне 3-500 кг.\n" +
                "Не указан пол.";
        String actualMassageText = actualMassageWebElement.getText();

        Assertions.assertEquals(expectedMassageText, actualMassageText);
    }

    @Test
    public void testFillFormWithoutName() {
        WebElement inputHeighWebElement = driver.findElement(By.xpath("//tbody/tr[3]/td[2]/input"));
        inputHeighWebElement.sendKeys("150");
        WebElement inputWeightWebElement = driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]/input"));
        inputWeightWebElement.sendKeys("50");
        WebElement inputGenderFemaleWebElement = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]/input[2]"));
        inputGenderFemaleWebElement.click();
        WebElement buttonCalculateWebElement = driver.findElement(By.xpath("//table/tbody/tr[6]/td/input"));
        buttonCalculateWebElement.click();

       String actualMessageXPath = "/html/body/table/tbody/tr[2]/td[2]/form/table/tbody/tr[1]/td/b";
        WebElement actualMessageWebElement = driver.findElement(By.xpath(actualMessageXPath));
        String actualMessageText = actualMessageWebElement.getText();
        String expectedMessageText = "Не указано имя.";

        Assertions.assertEquals(expectedMessageText,actualMessageText);

    }

    @AfterEach
    public void tearsDown() {
        driver.quit();
    }
}

