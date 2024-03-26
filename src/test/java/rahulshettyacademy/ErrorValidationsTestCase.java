package rahulshettyacademy;

import rahulshettyacademy.TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class ErrorValidationsTestCase extends BaseTest {
    
    @Test(groups = {"ErrorHandling"})
    public void LoginErrorValidation() {
        landingPage.loginApplication("testmilenatsoni@test.bg", "12345678A1!ai");
        String errorMessage = landingPage.getErrorMessage();

        Assert.assertEquals("Incorrect email password.", errorMessage);
    }

    @Test
    public void ProductErrorValidationTestCase() throws InterruptedException {
        String productName = "ZARA COAT 3";
        ProductCatalogue productCatalogue = landingPage.loginApplication("testmilenatson@test.bg", "12345678A1!a");

        productCatalogue.addProductToCart(productName);

        CartPage cartPage = productCatalogue.goToCartPage();
        Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
        Assert.assertFalse(match);
    }
}
