package com.framework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class MyFirtsUITest {


    @Test
    void usernameIsCorrectOnOverviewTab(){

        // Arrange
        System.setProperty("webdriver.chrome.driver", "C:\\Projects\\PluralSight\\MyFirstFramework\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions().addArguments("start-fullscreen");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String user = "fabiandzp";
        driver.get("https://github.com/" + user);


        // Act
        String actualUserName = driver.findElement(By.className("p-nickname")).getText();


        // Assert
        Assertions.assertEquals(user, actualUserName);

        driver.close();

    }



    @Test
    void repoLinkGoesToCorrectRepo(){

        // Arrange
        System.setProperty("webdriver.chrome.driver", "C:\\Projects\\PluralSight\\MyFirstFramework\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions().addArguments("start-fullscreen");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String user = "fabiandzp";
        driver.get("https://github.com/" + user);


        // Act
        String repo = "fwk-ebtn-ui-tests";
        WebElement repoLink = driver.findElement(By.linkText(repo));

        repoLink.click();

        String actualUrl = driver.getCurrentUrl();

        // Assert
        Assertions.assertEquals("https://github.com/" + user, actualUrl);

        driver.close();

    }
}
