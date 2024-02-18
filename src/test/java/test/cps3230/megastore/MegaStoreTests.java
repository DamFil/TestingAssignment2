package test.cps3230.megastore;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MegaStoreTests {
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
        acceptBtn.click();
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }

    // cameras category
    @Test
    public void testCamerasCategory() {
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

    // SSD category
    @Test
    public void testSSDCategory() {
        // setup
        // find the electronics button and hover over it for the submenu to appear
        WebElement electronicsBtn = driver.findElement(By.id("hcategory_674"));
        Actions hoverOver = new Actions(driver);
        hoverOver.moveToElement(electronicsBtn).perform();
        // wait for the submenu to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement ssdBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/ul/li[@id='hcategory_163034']")));
        // move the mouse over the cameras category and click on it
        hoverOver.moveToElement(ssdBtn).click().perform();

        // verify
        // wait for the product container element to appear and check that the category name is "Cameras"
        WebElement parentContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("s-grid-9")));
        WebElement categoryName = parentContainer.findElement(By.className("category-name"));
        Assertions.assertEquals(categoryName.getText(), "SSD");

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

    // power banks category
    @Test
    public void testPowerBankCategory() {
        // setup
        // find the electronics button and hover over it for the submenu to appear
        WebElement electronicsBtn = driver.findElement(By.id("hcategory_674"));
        Actions hoverOver = new Actions(driver);
        hoverOver.moveToElement(electronicsBtn).perform();
        // wait for the submenu to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement powerBanksBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/ul/li[@id='hcategory_1460']")));
        // move the mouse over the cameras category and click on it
        hoverOver.moveToElement(powerBanksBtn).click().perform();

        // verify
        // wait for the product container element to appear and check that the category name is "Cameras"
        WebElement parentContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("s-grid-9")));
        WebElement categoryName = parentContainer.findElement(By.className("category-name"));
        Assertions.assertEquals(categoryName.getText(), "POWER BANKS");

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

    // michelin tyre category
    @Test
    public void testMichellinTyresCategory() {
        // setup
        // find the electronics button and hover over it for the submenu to appear
        WebElement tyresBtn = driver.findElement(By.id("headlink88"));
        Actions hoverOver = new Actions(driver);
        hoverOver.moveToElement(tyresBtn).perform();
        // wait for the submenu to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement michellinBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/ul/li[@id='hcategory_69556']")));
        // move the mouse over the cameras category and click on it
        hoverOver.moveToElement(michellinBtn).click().perform();

        // verify
        // wait for the product container element to appear and check that the category name is "Cameras"
        WebElement parentContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("s-grid-9")));
        WebElement categoryName = parentContainer.findElement(By.className("category-name"));
        Assertions.assertEquals(categoryName.getText(), "MICHELIN");

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

    // fencing category
    @Test
    public void testFaceCareCategory() {
        // setup
        // find the electronics button and hover over it for the submenu to appear
        WebElement tyresBtn = driver.findElement(By.id("hcategory_698"));
        Actions hoverOver = new Actions(driver);
        hoverOver.moveToElement(tyresBtn).perform();
        // wait for the submenu to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement fencingBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/ul/li[@id='hcategory_74706']")));
        // move the mouse over the cameras category and click on it
        hoverOver.moveToElement(fencingBtn).click().perform();

        // verify
        // wait for the product container element to appear and check that the category name is "Cameras"
        WebElement parentContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("s-grid-9")));
        WebElement categoryName = parentContainer.findElement(By.className("category-name"));
        Assertions.assertEquals(categoryName.getText(), "FENCING");

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

    // test for searching
    @Test
    public void testSearch() {
        WebElement searchField = driver.findElement(By.className("search-input"));
        searchField.sendKeys("standing desk");
        WebElement searchButton = driver.findElement(By.className("search-btn"));
        searchButton.click();

        // check that the search results container is displayed
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement searchResultsContainer = wait.until(ExpectedConditions.elementToBeClickable(By.className("s-grid-9")));
        Assertions.assertTrue(searchResultsContainer.isDisplayed());

        // check that the number of products is greater or equal to 5
        WebElement products = searchResultsContainer.findElement(By.className("products"));
        List<WebElement> productList = products.findElements(By.xpath(".//div[contains(@class, 'product')]"));
        int numProducts = productList.size();
        Assertions.assertTrue(numProducts >= 5);

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
