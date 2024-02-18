package test.cps3230.megastore;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

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
        // find the electronics button and hover over it for the submenu to appear
        WebElement electronicsBtn = driver.findElement(By.id("hcategory_674"));
        Actions hoverOver = new Actions(driver);
        hoverOver.moveToElement(electronicsBtn).perform();
        // wait for the submenu to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement camerasBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/ul/li[@id='hcategory_1446']")));
        // move the mouse over the cameras category and click on it
        hoverOver.moveToElement(camerasBtn).click().perform();

        // verify
        // wait for the product container element to appear and check that the category name is "Cameras"
        WebElement parentContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("s-grid-9")));
        WebElement categoryName = parentContainer.findElement(By.className("category-name"));
        Assertions.assertEquals(categoryName.getText(), "CAMERAS");

        // verify that there are at least 3 products
        WebElement products = parentContainer.findElement(By.className("products"));
        List<WebElement> productList = products.findElements(By.xpath(".//div[contains(@class, 'product')]"));
        int numProducts = productList.size();
        Assertions.assertTrue(numProducts >= 3);

        // verify that clicking on the first product in the results we get the details page of that product
        WebElement firstProduct = productList.getFirst();
        WebElement firstProductClickable = firstProduct.findElement(By.className("product-inner-wrap"));
        String firstProductName = firstProduct.findElement(By.className("productname")).getText();
        firstProductClickable.click();

        WebElement nameOfClickedProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("name")));
        String detailsPageName = nameOfClickedProduct.getText();
        Assertions.assertEquals(firstProductName.toUpperCase(), detailsPageName.toUpperCase());
    }
}
