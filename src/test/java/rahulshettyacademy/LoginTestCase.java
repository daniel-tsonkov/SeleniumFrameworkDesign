package rahulshettyacademy;

import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestCase extends BaseTest {
    
    @Test
    public void submitOrder() {
        landingPage.loginApplication("testmilenatsoni@test.bg", "12345678A1!ai");

        String errorMessage = landingPage.getErrorMessage();
        Assert.assertEquals("Incorrect email or password.", errorMessage);
    }
}
