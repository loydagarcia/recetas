package com.example.recetas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.jupiter.api.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HomepageTest {

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    void testCargaPaginaPrincipal() {
        driver.get("http://localhost:8080");
        Assertions.assertTrue(driver.getTitle().contains("Recetas - Inicio"));
    }

    @Test
    void testVerIngredientesButton(){
        driver.get("http://localhost:8080");
        WebElement link = driver.findElement(By.linkText("Ver ingredientes"));
        Assertions.assertTrue(link.getAttribute("href").equals("http://localhost:8080/ingredientes"));
        link.click();
        Assertions.assertEquals("Ingredientes",driver.getTitle());
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}