package org.last.fm;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class LogOutTest extends TestBase {
    LogOut logout;

    @Test(priority = 9)
    public void logoutVerification() throws InterruptedException {
        logout = new LogOut(driver);

        TimeUnit.SECONDS.sleep(3);
        logout.hoverMainProfileButton();
        TimeUnit.SECONDS.sleep(3);
        logout.LogOutBttn();
        TimeUnit.SECONDS.sleep(3);

    }

    @AfterClass
    void tearDown () {
        driver.quit();
    }
}