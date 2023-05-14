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
        WebElement inputHeightWebElement = driver.findElement(By.xpath("//tbody/tr[3]/td[2]/input"));
        inputHeightWebElement.sendKeys("150");
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
    @Test
    public void testFillFormWithCorrectMaleData() {
        WebElement inputName = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]/input"));
        inputName.sendKeys("Алекс");

        String inputHeight = "//tbody/tr[3]/td[2]/input";
        WebElement inputHeightWebElement = driver.findElement(By.xpath(inputHeight));
        inputHeightWebElement.sendKeys("180");

        String inputWeight = "//tbody/tr[4]/td[2]/input";
        WebElement inputWeightWebElement = driver.findElement(By.xpath(inputWeight));
        inputWeightWebElement.sendKeys("80");

        String inputGenderMale = "//table/tbody/tr[5]/td[2]/input[1]";
        WebElement inputGenderFamaleWebElement = driver.findElement(By.xpath(inputGenderMale));
        inputGenderFamaleWebElement.click();

        String inputButtonXPath = "//tbody/tr[6]/td/input";
        WebElement inputButtonWebElement = driver.findElement(By.xpath(inputButtonXPath));
        inputButtonWebElement.click();

        WebElement actualMassage = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]"));
        String actualMassageText = actualMassage.getText();

        Assertions.assertEquals("Идеальная масса тела", actualMassageText);
    }
    @Test
    public void testFillFormWithoutGenderData(){
        WebElement inputNameWebElement = driver.findElement(By.xpath("//input[@name='name']"));
        inputNameWebElement.sendKeys("Елена");

        WebElement inputHeightWebElement = driver.findElement(By.xpath("//input[@name='height']"));
        inputHeightWebElement.sendKeys("167");

        WebElement inputWeightWebElement = driver.findElement(By.xpath("//input[@name='weight']"));
        inputWeightWebElement.sendKeys("65");

        WebElement buttonCalculateWebElement = driver.findElement(By.xpath("//input[@value='Рассчитать']"));
        buttonCalculateWebElement.click();

        WebElement actualMessageWebElement = driver.findElement(By.xpath("//table/tbody/tr[1]/td/b"));
        String actualMessage = actualMessageWebElement.getText();

        String expectedMessage = "Не указан пол.";

        Assertions.assertEquals(actualMessage,expectedMessage);
    }

    @AfterEach
    public void tearsDown() {
        driver.quit();
    }
}

