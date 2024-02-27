package rahulshettyacademy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class StandAloneTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/client/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.id("userEmail")).sendKeys("testmilenatson@test.bg");
        driver.findElement(By.id("userPassword")).sendKeys("12345678A1!a");
        driver.findElement(By.id("login")).click();

        List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

       /* for (WebElement product : products) {
            System.out.println(product.getText());
        }*/

        WebElement prod = products.stream().filter(product ->
                product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null); //filter to finde only one product

        assert prod != null;
        System.out.println(prod.findElement(By.cssSelector(".card-body button:last-of-type")).getText());
        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

        System.exit(0);
    }
}
