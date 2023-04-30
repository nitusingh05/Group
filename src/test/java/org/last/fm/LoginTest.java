package org.last.fm;

import org.testng.annotations.Test;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class LoginTest extends TestBase {
    Login login;
    ResourceBundle bundle = ResourceBundle.getBundle("config");

    @Test(priority = 2)
    public void loginVerification() throws InterruptedException {
        login = new Login(driver);
        String username = bundle.getString("username");
        String password = bundle.getString("password");
        TimeUnit.SECONDS.sleep(6);
        login.clickMainLoginButton();
        TimeUnit.SECONDS.sleep(4);
        login.enterUsername(username);
        login.enterPassword(password);
        login.clickLetMeInButton();
    }
}