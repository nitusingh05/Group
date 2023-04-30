package org.last.fm;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddTrackinPlaylistTest extends TestBase {

    AddTrackInPlaylist addT;
    @Test(priority = 6)
    public void addtracktoplaylist() throws InterruptedException {

        addT = new AddTrackInPlaylist(driver);

        TimeUnit.SECONDS.sleep(4);

        addT.setAddTrack();
        TimeUnit.SECONDS.sleep(3);
        addT.setSearchBox();
        TimeUnit.SECONDS.sleep(2);
        addT.AddFunc();
        TimeUnit.SECONDS.sleep(3);
        addT.setAddSimilarTracks();
        TimeUnit.SECONDS.sleep(5);

    }
}
