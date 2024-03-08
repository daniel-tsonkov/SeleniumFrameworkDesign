package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    WebDriver driver;

    public LandingPage() {
        this.driver = driver;
    }
    WebElement userEmail = driver.findElement(By.id("userEmail"));
}
