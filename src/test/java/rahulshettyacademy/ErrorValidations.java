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
        ProductCatalogue productCatalogue = landingPage.loginApplication("testmilenatsoni@test.bg", "12345678A1!ai");
        div[aria-label='Incorrect email or password.']
        id attribute is not available for this element
        name attribute is not available for this element
        div[aria-label='Incorrect email or password.']
        div[aria-label='Incorrect email or password.']
    }
}
