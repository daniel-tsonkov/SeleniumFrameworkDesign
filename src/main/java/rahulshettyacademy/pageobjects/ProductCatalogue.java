package rahulshettyacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCatalogue {
    WebDriver driver;

    public ProductCatalogue(WebDriver driver) {
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
    public void loginApplication(String email, String password) {
        userEmail.sendKeys(email);
        passwordElement.sendKeys(password);
        submit.click();
    }

    public void goToURL(){
        driver.get("https://rahulshettyacademy.com/client/");
    }
}
