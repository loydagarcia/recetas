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
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Eliminaringredients {
    private WebDriver driver;

    @BeforeEach

    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    void testEliminarIngrediente() throws InterruptedException {

        driver.get("http://localhost:8080/ingredientes");

        WebElement table = driver.findElement(By.xpath("//table"));
        List<WebElement> rowsBefore = table.findElements(By.xpath(".//tbody/tr"));


        WebElement Eliminarlink = driver.findElement(By.xpath("//html/body/table/tbody/tr[2]/td[3]"));
        Eliminarlink.click();

        Thread.sleep(3000);

        table = driver.findElement(By.xpath("//table"));
        List<WebElement> rows2 = table.findElements(By.xpath(".//tbody/tr"));


    }

        @AfterEach
        void tearDown() {
            if (driver != null) {
                driver.quit();
            }
        }
    }