package org.last.fm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditDetailsOfPlayList {

    WebDriver driver;
    @FindBy(tagName = "h1")
            private WebElement PlayListName;
    @FindBy(xpath = "//div[@id='content']")
            private WebElement OuterBdy;

    public EditDetailsOfPlayList(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setPlayListName(){
        PlayListName.click();
        PlayListName.clear();
        PlayListName.sendKeys("Demo Playlist");
    }

    public void clickOuterBdy(){
        OuterBdy.click();
    }

}
