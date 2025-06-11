package com.example.recetas;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class IngredientesPageTest {

    private WebDriver driver;

    @BeforeEach // esta anotacion
        // le dice a selenium qwue debe correr este metodo antes de cada test
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    void testCrearIngrediente() throws InterruptedException {

        driver.get("http://localhost:8080/ingredientes");

        WebElement table = driver.findElement(By.xpath("//table"));
        List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));

        WebElement inputNombre = driver.findElement(By.xpath("//input[@name='nombre']"));
        inputNombre.sendKeys("Pollo");

        WebElement comboTipo = driver.findElement(By.xpath("//select[@name='tipo']"));
        Select dropdown = new Select(comboTipo);
        dropdown.selectByIndex(0);

        inputNombre.submit();

        Thread.sleep(3000);

        table = driver.findElement(By.xpath("//table"));
        List<WebElement> rows2 = table.findElements(By.xpath(".//tbody/tr"));

        Assertions.assertNotEquals(rows2.size(), rows.size());
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
