package rahulshettyacademy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

import java.time.Duration;
import java.util.List;

public class SubmitOrderTest {
    public static void main(String[] args) {
        String productName = "ZARA COAT 3";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToURL();
        landingPage.loginApplication("testmilenatson@test.bg", "12345678A1!a");
        ProductCatalogue productCatalogue = new ProductCatalogue(driver);
        List<WebElement>products = productCatalogue.getProductList();



        assert prod != null;
        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating"))); //this is too slow!
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating")))); //this is very fast use it!

        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

        List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));

        boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
        Assert.assertTrue(match);

        driver.findElement(By.cssSelector(".totalRow button")).click();

        Actions a = new Actions(driver);
        a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "Bulgaria").build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
        driver.findElement(By.cssSelector(".ta-item:nth-of-type(1)")).click();
        driver.findElement(By.cssSelector(".action__submit")).click();
        String confirMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
        //Assert.assertEquals(confirMessage,"THANKYOU FOR THE ORDER.");//one way
        Assert.assertTrue(confirMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));//second way

        driver.close();

        System.exit(0);
    }
}
