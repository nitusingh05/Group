package org.last.fm;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DeletePlaylistTest extends TestBase{

    DeletePlaylist del;
    @Test(priority = 8)
    public void deleteplaylist() throws InterruptedException {
        del = new DeletePlaylist(driver);

        TimeUnit.SECONDS.sleep(3);
        del.setDropDownPlaylist();
        TimeUnit.SECONDS.sleep(3);
        del.setDelPlaylist();
        TimeUnit.SECONDS.sleep(2);
        del.setDelBttn2();

    }

}
