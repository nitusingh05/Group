package org.last.fm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeletePlaylist {

    WebDriver driver;

    @FindBy(xpath = "//button[contains(text(),'More actions')]")
            private WebElement DropDownPlaylist;
    @FindBy(xpath = "//button[contains(text(),'Delete')]")
            private WebElement DelPlaylist;
    @FindBy(xpath = "//button[contains(@class,'btn-primary')][contains(text(),'Delete')]")
        private WebElement DelBttn2;

    public DeletePlaylist(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setDropDownPlaylist(){
        DropDownPlaylist.click();
    }
    public void setDelPlaylist(){
        DelPlaylist.click();
    }
    public void setDelBttn2(){
        DelBttn2.click();
    }


}
