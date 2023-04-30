package org.last.fm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPlaylist {
    WebDriver driver;

    //Double-Click on Playlist Nav Button
    @FindBy(xpath = "//li[contains(@class,'playlists')]/a[contains(text(),'Playlists')]")
            private WebElement PlaylistNav;

    //Click on New Playlist Button
    @FindBy(xpath = "//a[contains(text(),'New playlist')]")
            private WebElement newPlaylistBttn;

    //Click on Start From Scratch Button
    @FindBy(xpath = "//button[contains(text(),'Start from scratch')]")
            private WebElement StartfrmScratch;

    public AddPlaylist(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public void PlaylistNavFunc(){
        PlaylistNav.click();
        PlaylistNav.click();
    }
    public void newPlaylistBttnFunc(){
        newPlaylistBttn.click();
    }
    public void startFrmScratchFunc(){
        StartfrmScratch.click();
    }
}
