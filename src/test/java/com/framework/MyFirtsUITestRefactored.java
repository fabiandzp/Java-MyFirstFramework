package com.framework;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.testautomation.DriverFactory.getChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyFirtsUITestRefactored {


    public static final String BASE_URL = "https://github.com/";
    static WebDriver driver;

    //@BeforeEach // In TestNG it's called @BeforeMethod
    @BeforeAll
    static void setup(){
        driver = getChromeDriver();
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
