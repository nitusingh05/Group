package org.last.fm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class RemoveSongFromPlaylist {

    WebDriver driver;

    @FindBy(xpath = "//tbody/tr[1]/td[2]")
             WebElement element;
    @FindBy(xpath = "//tbody/tr[1]/td[9]/div[1]/button[1]")
             WebElement moreBttn;
    @FindBy(xpath = "//tbody/tr[1]/td[9]/div[1]/ul[1]/li[1]/form[1]/button[1]")
             WebElement RmvBttn;

    public RemoveSongFromPlaylist(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setElement() throws InterruptedException {
        element.click();
    }
    public void setMoreBttn() throws InterruptedException {
        Actions actions = new Actions(driver);
        TimeUnit.SECONDS.sleep(4);
        actions.moveToElement(moreBttn);
        TimeUnit.SECONDS.sleep(2);
        moreBttn.click();
    }
    public void setRmvBttn(){
        RmvBttn.click();
    }

}
