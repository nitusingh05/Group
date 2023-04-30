package org.last.fm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOut {
    WebDriver driver;

    //Hover Main Profile
    @FindBy(xpath = "//a[contains(@class, 'auth-link')]")
    WebElement mainProfileHov;

    //Logout Button
    @FindBy(xpath = "//ul[contains(@class,'dropdown')]/li/form[@action=\"/logout\"]/a[contains(@class,'logout-button')][text()='Logout']")
    WebElement logOut;

    public LogOut(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void hoverMainProfileButton() {
        mainProfileHov.click();
    }

    public void LogOutBttn() {
        logOut.click();
    }

}