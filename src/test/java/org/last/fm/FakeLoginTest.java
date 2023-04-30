package org.last.fm;

import org.testng.annotations.Test;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class FakeLoginTest extends TestBase {

        FakeLogin fakeLogin;
        ResourceBundle bundle = ResourceBundle.getBundle("config");

        @Test(priority = 1)
        public void loginVerification() throws InterruptedException {

                fakeLogin = new FakeLogin(driver);
                String fake_username = bundle.getString("usernameFake");
                String fake_password = bundle.getString("passwordFake");
                TimeUnit.SECONDS.sleep(6);
                fakeLogin.MainLoginButton();
                TimeUnit.SECONDS.sleep(4);
                fakeLogin.enterUsername(fake_username);
                fakeLogin.enterPassword(fake_password);
                fakeLogin.LetMeInButton();
                TimeUnit.SECONDS.sleep(4);

        }
}