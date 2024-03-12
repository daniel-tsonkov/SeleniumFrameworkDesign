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
        landingPage.loginApplication("testmilenatsoni@test.bg", "12345678A1!ai");

        String errorMessage = landingPage.getErrorMessage();
        Assert.assertEquals("Incorrect email or password.", errorMessage);
    }
}
