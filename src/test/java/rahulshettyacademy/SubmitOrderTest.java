package rahulshettyacademy;

import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import rahulshettyacademy.pageobjects.*;

public class SubmitOrderTest extends BaseTest{
    @Test
    public void submitOrder() throws InterruptedException {
        String productName = "ZARA COAT 3";
        ProductCatalogue productCatalogue = landingPage.loginApplication("testmilenatson@test.bg", "12345678A1!a");

        productCatalogue.addProductToCart(productName);

        CardPage cartPage = productCatalogue.goToCartPage();
        Boolean match = cartPage.VerifyProductDisplay(productName);
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.selectCountry("bulgaria");
        ConfirmationPage confirmationPage = checkoutPage.submitOrder();

        String confirMessage = confirmationPage.getConfirmatonMessage();
        Assert.assertTrue(confirMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));//second way
    }

    @Test(dependsOnMethods = {"submitOrder"})
    public void orderHistoryTest() {
        ProductCatalogue productCatalogue = landingPage.loginApplication("testmilenatson@test.bg", "12345678A1!a");

    }
}
