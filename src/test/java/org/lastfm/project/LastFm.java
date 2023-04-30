package org.lastfm.project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class LastFm {
    WebDriver driver;
    public Properties prop;

    @BeforeTest
    public void setUp() throws IOException {
        // Loading config.properties file
        prop = new Properties();
        FileInputStream fis = new FileInputStream("E:/Maven/LastFmTesting/src/main/resources/config.properties");
        prop.load(fis);
    }

    @BeforeClass
    @Parameters({"browser","url"})
    void setupDriver (String browser, String link) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
//        else if(browser.equalsIgnoreCase("edge")){
//            WebDriverManager.edgedriver().setup();
//            driver=new EdgeDriver();
//        }
        driver.manage().window().maximize();
        driver.get("https://www.last.fm/");
    }
    @SuppressWarnings("deprecation")
    @Test(priority = 1)   //Test1
    void LastfmFakeLoginTest() throws InterruptedException {
        String usernameFake = prop.getProperty("usernameFake");
        String passwordFake = prop.getProperty("passwordFake");

        //Main Page Login Click
        driver.findElement(By.xpath("//a[contains(@class, 'site-auth-control')]")).click();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        //Form - UsernameFake
        WebElement emailInput = driver.findElement(By.xpath("//input[contains(@name, 'username_or_email')]"));
        emailInput.sendKeys(usernameFake);

        //Form - PasswordFake
        WebElement  passwordInput =driver.findElement(By.xpath("//input[@id='id_password']"));
        passwordInput.sendKeys(passwordFake);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //Form - LetMeIn Click
        driver.findElement(By.xpath("//button[@class=\"btn-primary\"]")).click();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);


        String a = driver.findElement(By.xpath("//div[@class=\"alert alert-danger\"]")).getText();
        if("Please enter a correct username/email and password. Note that both fields may be case-sensitive.".equals(a.toString())){
            System.out.println("Incorrect Credentials Entered - Unable to Login");
        }
        else tearDown();
    }
    @Test(priority = 2)      //Test2
    void LastfmLoginTest() throws InterruptedException {

        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        //Main Page Login Click
        driver.findElement(By.xpath("//a[contains(@class, 'site-auth-control')]")).click();
        Thread.sleep(4000);
        //Form - Username
        WebElement emailInput1 = driver.findElement(By.xpath("//input[contains(@name, 'username_or_email')]"));
        emailInput1.sendKeys(username);

        //Form - Password
        WebElement  passwordInput1 =driver.findElement(By.xpath("//input[@id='id_password']"));
        passwordInput1.sendKeys(password);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        //Form - LetMeIn Click
        driver.findElement(By.xpath("//button[@class=\"btn-primary\"]")).click();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    }
    @Test(priority = 3)        //Test3
    void LastfmLoginTestCheck() throws InterruptedException {
        Thread.sleep(4000);
        driver.findElement(By.xpath("//a[contains(@class, 'auth-link')]")).click();
        String a = driver.findElement(By.xpath("//h1[@class='header-title']")).getText();
        if("Us1jk23".equals(a)) System.out.println("Username matched");
        else {
            System.out.println("Wrong Account");
            Thread.sleep(4000);
            tearDown();
        }
    }
    @Test(priority = 4)           //Test4
    void LastfmAddPlaylistTest() throws InterruptedException{
        Thread.sleep(4000);

        //Double-Click on Playlist Nav Button
        WebElement PlaylistNav = driver.findElement(By.xpath("//li[contains(@class,'playlists')]/a[contains(text(),'Playlists')]"));
        PlaylistNav.click();
        PlaylistNav.click();

        //Click on New Playlist Button
        WebElement newPlaylistBttn = driver.findElement(By.xpath("//a[contains(text(),'New playlist')]"));
        newPlaylistBttn.click();

        //Click on Start From Scratch Button
        WebElement StartfrmScratch = driver.findElement(By.xpath("//button[contains(text(),'Start from scratch')]"));
        StartfrmScratch.click();

        Thread.sleep(4000);
    }

    @Test(priority = 5) //Test5
    void LastfmEditDetailsOfPlayList() throws InterruptedException{
        Thread.sleep(4000);
        WebElement PlayListName = driver.findElement(By.tagName("h1"));
        PlayListName.click();
        PlayListName.clear();
        PlayListName.sendKeys("Cool Stuff");
        Thread.sleep(2000);
        WebElement OuterBdy = driver.findElement(By.xpath("//div[@id='content']"));
        OuterBdy.click();
    }

    @Test(priority = 6) //Test 6
    void AddTrackInPlaylist() throws InterruptedException{
        Thread.sleep(4000);
        WebElement AddTrack = driver.findElement(By.xpath("//div[contains(@class,\"no-data-message--playlist-entries\")]/button[contains(@class, \"buffer-4\")]"));
        AddTrack.click();

        WebElement SearchBox = driver.findElement(By.xpath("//input[contains(@id, 'track-search')]"));
        SearchBox.click();
        SearchBox.sendKeys("Dua Lipa");
        Thread.sleep(2000);
        SearchBox.sendKeys(Keys.ENTER);
        SearchBox.sendKeys(Keys.ENTER);

//        WebElement Search = driver.findElement(By.xpath("//div[contains(@class, 'search-form')]/button[@class = 'search-submit']"));
//        Search.click();

        WebElement Add = driver.findElement(By.xpath("//tbody/tr[5]/td[6]/form[1]/button[1]"));
        Thread.sleep(3000);
        Add.click();

        WebElement AddSimilarTracks = driver.findElement(By.xpath("//form[contains(@class,'playlist-edit-add-similar-tracks')]/button[contains(text(),'Add Similar Tracks')]"));
        Thread.sleep(3000);
        AddSimilarTracks.click();

        Thread.sleep(5000);
    }

    @Test(priority = 7) //Test 7
    void RemoveSongFromPlaylist() throws InterruptedException {
        Thread.sleep(4000);
        Actions actions = new Actions(driver);
        Thread.sleep(3000);

        WebElement element = driver.findElement(By.xpath("//tbody/tr[1]/td[2]"));

//        actions.moveToElement(element);

        element.click();

        Thread.sleep(2000);
        WebElement moreBttn = driver.findElement(By.xpath("//tbody/tr[1]/td[9]/div[1]/button[1]"));
        actions.moveToElement(moreBttn);
        moreBttn.click();

        Thread.sleep(2000);

        WebElement RmvBttn = driver.findElement(By.xpath("//tbody/tr[1]/td[9]/div[1]/ul[1]/li[1]/form[1]/button[1]"));
        RmvBttn.click();
    }

    @Test(priority = 8) //Test 8
    void DeletePlaylist() throws InterruptedException{

        WebElement DropDownPlaylist = driver.findElement(By.xpath("//button[contains(text(),'More actions')]"));
        DropDownPlaylist.click();

        Thread.sleep(3000);
        WebElement DelPlaylist = driver.findElement(By.xpath("//button[contains(text(),'Delete')]"));
        DelPlaylist.click();

        Thread.sleep(2000);
        WebElement DelBttn2 = driver.findElement(By.xpath("//button[contains(@class,'btn-primary')][contains(text(),'Delete')]"));
        DelBttn2.click();

    }

    @AfterClass
    void tearDown () {
        driver.quit();
    }

}
