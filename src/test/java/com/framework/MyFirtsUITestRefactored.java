package com.framework;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyFirtsUITestRefactored {


    public static final String BASE_URL = "https://github.com/";
    static WebDriver driver;

    //@BeforeEach // In TestNG it's called @BeforeMethod
    @BeforeAll
    static void setup(){
        // Create the driver object
        System.setProperty("webdriver.chrome.driver", "C:\\Projects\\PluralSight\\MyFirstFramework\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions().addArguments("start-fullscreen");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    //@AfterEach
    @AfterAll
    static void cleanUp(){
        driver.close();
    }


    @Test
    void usernameIsCorrectOnOverviewTab(){

        // Arrange
        String user = "fabiandzp";
        driver.get(BASE_URL + user);

        // Act
        String actualUserName = driver.findElement(By.className("p-nickname")).getText();

        // Assert
        assertEquals(user, actualUserName);
    }



    @Test
    void repoLinkGoesToCorrectRepo(){

        // Arrange
        String user = "fabiandzp";
        driver.get(BASE_URL + user);

        // Act
        String repo = "fwk-ebtn-ui-tests";
        WebElement repoLink = driver.findElement(By.linkText(repo));
        repoLink.click();
        String actualUrl = driver.getCurrentUrl();

        // Assert
        assertEquals(BASE_URL + user, actualUrl);
    }


    @Test
    void repositoryCountIsCorrect(){

        // Arrange

        // Act
        driver.get("https://github.com/fabiandzp?tab=repositories");
        List<WebElement> repos = driver.findElements(By.xpath("//div[@id='user-repositories-list']//li"));

        // Assert
        assertEquals(30, repos.size());
    }

}
