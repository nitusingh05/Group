package org.last.fm;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class AddTrackInPlaylist {

    WebDriver driver;

    @FindBy(xpath = "//div[contains(@class,\"no-data-message--playlist-entries\")]/button[contains(@class, \"buffer-4\")]")
            private WebElement AddTrack;
    @FindBy(xpath = "//input[contains(@id, 'track-search')]")
            private WebElement SearchBox;
    @FindBy(xpath = "//tbody/tr[5]/td[6]/form[1]/button[1]")
            private WebElement Add;
    @FindBy(xpath = "//form[contains(@class,'playlist-edit-add-similar-tracks')]/button[contains(text(),'Add Similar Tracks')]")
            private WebElement AddSimilarTracks;

    public AddTrackInPlaylist(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void setAddTrack() {
        AddTrack.click();
    }
    public void setSearchBox() throws InterruptedException {

        SearchBox.click();
        TimeUnit.SECONDS.sleep(2);
        SearchBox.sendKeys("Dua Lipa");
        TimeUnit.SECONDS.sleep(4);
        SearchBox.sendKeys(Keys.ENTER);
        SearchBox.sendKeys(Keys.ENTER);
    }

    public void AddFunc(){
        Add.click();
    }

    public void setAddSimilarTracks(){
        AddSimilarTracks.click();
    }

}
