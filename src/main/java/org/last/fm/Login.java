package org.last.fm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    WebDriver driver;

    //Main Page Login Click
    @FindBy(xpath = "//a[contains(@class, 'site-auth-control')]")
    WebElement mainLoginBttn;

    //Username
    @FindBy(xpath = "//input[contains(@name, 'username_or_email')]")
    WebElement usernameReal;

    // Password
    @FindBy(xpath = "//input[@id='id_password']")
    WebElement passwordReal;

    //LetMeInClick
    @FindBy(xpath = "//button[@class='btn-primary']")
    WebElement letMeInBttn;

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickMainLoginButton() {
        mainLoginBttn.click();
    }

    public void enterUsername(String username) {
        usernameReal.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordReal.sendKeys(password);
    }

    public void clickLetMeInButton() {
        letMeInBttn.click();
    }
}