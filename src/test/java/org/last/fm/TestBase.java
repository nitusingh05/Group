package org.last.fm;

import com.browser.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestBase {

    public static WebDriver driver;

    @BeforeSuite
    public void setup() {
        driver = BrowserFactory.setupBrowser("chrome", "https://www.last.fm/");
    }


}