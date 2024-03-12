package rahulshettyacademy;

import TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import rahulshettyacademy.pageobjects.*;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class SubmitOrderTest extends BaseTest{
    //public static void main(String[] args) throws InterruptedException{
    @Test
    public void submitOrder() throws InterruptedException, IOException {
        String productName = "ZARA COAT 3";
        LandingPage landingPage = launchApplication();

        ProductCatalogue productCatalogue = landingPage.loginApplication("testmilenatson@test.bg", "12345678A1!a");
        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(productName);

        CardPage cartPage = productCatalogue.goToCartPage();
        Boolean match = cartPage.VerifyProductDisplay(productName);
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.selectCountry("bulgaria");
        ConfirmationPage confirmationPage = checkoutPage.submitOrder();

        String confirMessage = confirmationPage.getConfirmatonMessage();
        Assert.assertTrue(confirMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));//second way

        driver.close();
    }
}
