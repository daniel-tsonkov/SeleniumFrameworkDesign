package rahulshettyacademy;

import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rahulshettyacademy.pageobjects.*;

public class SubmitOrderTest extends BaseTest {
    String productName = "ZARA COAT 3";
    @Test(dataProvider = "getData", groups = {"Purchase"})
    public void submitOrder(String email, String password, String productName) throws InterruptedException {
        ProductCatalogue productCatalogue = landingPage.loginApplication(email, password);

        productCatalogue.addProductToCart(productName);

        CartPage cartPage = productCatalogue.goToCartPage();
        Boolean match = cartPage.VerifyProductDisplay(productName);
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.selectCountry("bulgaria");
        ConfirmationPage confirmationPage = checkoutPage.submitOrder();

        String confirmMessage = confirmationPage.getConfirmatonMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));//second way
    }

    @Test(dependsOnMethods = {"submitOrder"})
    public void orderHistoryTest() {
        ProductCatalogue productCatalogue = landingPage.loginApplication("testmilenatson@test.bg", "12345678A1!a");
        OrderPage orderPage = productCatalogue.goToOrdersPade();
        Assert.assertTrue(orderPage.VerifyOrderDisplay(productName));
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][] {{"testmilenatson@test.bg", "12345678A1!a", "ZARA COAT 3"}, {"anshika@gmail.com", "Iamking@000", "ADIDAS ORIGINAL"}};
    }
}
