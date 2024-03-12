package rahulshettyacademy;

import TestComponents.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import rahulshettyacademy.pageobjects.CardPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class ErrorValidationsTestCase extends BaseTest {
    
    @Test
    public void submitOrder() {
        landingPage.loginApplication("testmilenatsoni@test.bg", "12345678A1!ai");

        String errorMessage = landingPage.getErrorMessage();
        Assert.assertEquals("Incorrect email or password.", errorMessage);
    }

    @Test
    public void ProductErrorValidationTestCase() throws InterruptedException {
        String productName = "ZARA COAT 3";
        ProductCatalogue productCatalogue = landingPage.loginApplication("testmilenatson@test.bg", "12345678A1!a");

        productCatalogue.addProductToCart(productName);

        CardPage cartPage = productCatalogue.goToCartPage();
        Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
        Assert.assertFalse(match);
    }
}