package rahulshettyacademy.pageobjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalogue extends AbstractComponent {
    WebDriver driver;

    public ProductCatalogue(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

    //PageFactory
    @FindBy(css = ".mb-3")
    List<WebElement> products;

}
