package rahulshettyacademy;

import TestComponents.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import rahulshettyacademy.pageobjects.CardPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

import java.io.IOException;
import java.util.List;

public class ErrorValidations extends BaseTest{
    //public static void main(String[] args) throws InterruptedException{
    @Test
    public void submitOrder() throws InterruptedException, IOException {
        String productName = "ZARA COAT 3";
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
    }
}
