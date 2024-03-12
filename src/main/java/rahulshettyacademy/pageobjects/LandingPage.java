package rahulshettyacademy.pageobjects;

import rahulshettyacademy.AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponent {
    WebDriver driver;

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //WebElement userEmail = driver.findElement(By.id("userEmail"));

    //PageFactory
    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "userPassword")
    WebElement passwordElement;

    @FindBy(id = "login")
    WebElement submit;

    //ActionMethods
    public ProductCatalogue loginApplication(String email, String password) {
        userEmail.sendKeys(email);
        passwordElement.sendKeys(password);
        submit.click();
        ProductCatalogue productCatalogue = new ProductCatalogue(driver);
        return productCatalogue;
    }

    public void goToURL(){
        driver.get("https://rahulshettyacademy.com/client/");
    }
}
