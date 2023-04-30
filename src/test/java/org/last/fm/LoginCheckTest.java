package org.last.fm;

import org.testng.annotations.Test;

public class LoginCheckTest extends TestBase {
    LoginCheck loginCheck;
    @Test(priority = 3)
    public void logincheck() throws InterruptedException {
        loginCheck = new LoginCheck(driver);

        Thread.sleep(2000);
        loginCheck.MainUsername();
        Thread.sleep(4000);

    }
}
