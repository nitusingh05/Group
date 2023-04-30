package org.last.fm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RemoveSongFromPlaylistTest extends TestBase{
    RemoveSongFromPlaylist Rm;

    @Test(priority = 7)
    public void removesongfromplaylist() throws InterruptedException {
        Rm = new RemoveSongFromPlaylist(driver);

        TimeUnit.SECONDS.sleep(4);
        Rm.setElement();
        TimeUnit.SECONDS.sleep(2);
        Rm.setMoreBttn();
        TimeUnit.SECONDS.sleep(2);
        Rm.setRmvBttn();

    }
}
