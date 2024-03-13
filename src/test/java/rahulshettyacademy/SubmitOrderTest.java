package rahulshettyacademy;

import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rahulshettyacademy.pageobjects.*;

import java.util.HashMap;

public class SubmitOrderTest extends BaseTest {
    String productName = "ZARA COAT 3";
    @Test(dataProvider = "getData", groups = {"Purchase"})
    public void submitOrder(HashMap<String, String> input) throws InterruptedException {
        ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));

        productCatalogue.addProductToCart(input.get("product"));

        CartPage cartPage = productCatalogue.goToCartPage();
        Boolean match = cartPage.VerifyProductDisplay(input.get("product"));
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
       /* HashMap<String, String> map = new HashMap<>();
        map.put("email", "testmilenatson@test.bg");
        map.put("password", "12345678A1!a");
        map.put("product", "ZARA COAT 3");

        HashMap<String, String> map1 = new HashMap<>();
        map1.put("email", "anshika@gmail.com");
        map1.put("password", "Iamking@000");
        map1.put("product", "ADIDAS ORIGINAL");*/

        return new Object[][] {{map}, {map1}};
    }
}
