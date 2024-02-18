package test.cps3230.atoz;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AtozTests {
    WebDriver driver;
    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/home/damfil/WebTesting/chromedriver");
        driver = new ChromeDriver();

        // open megastore and allow cookies
        driver.get("https://www.megastore.com.mt/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement acceptBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("CybotCookiebotDialogBodyButtonAccept")));

        //5 tabs and enter
        driver.switchTo().activeElement().sendKeys(Keys.TAB);
        driver.switchTo().activeElement().sendKeys(Keys.TAB);
        driver.switchTo().activeElement().sendKeys(Keys.TAB);
        driver.switchTo().activeElement().sendKeys(Keys.TAB);
        driver.switchTo().activeElement().sendKeys(Keys.TAB);
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);

        acceptBtn.click();
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }

    @Test
    public void testTakenToCorrectCategory() throws Exception {
        // setup
        WebElement electronicsBtn = driver.findElement(By.id("hcategory_674"));
        Actions hoverOver = new Actions(driver);
        hoverOver.moveToElement(electronicsBtn).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement camerasBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/ul/li[@id='hcategory_1446']")));
        hoverOver.moveToElement(camerasBtn).click().perform();

        Thread.sleep(10000);
    }
}
