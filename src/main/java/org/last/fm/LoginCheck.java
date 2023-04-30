package org.last.fm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginCheck {

    WebDriver driver;

    @FindBy(xpath = "//a[contains(@class, 'auth-link')]")
             WebElement MainPage;
    @FindBy(xpath = "//h1[@class='header-title']")
             WebElement Check;


    public LoginCheck(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void MainUsername(){
        MainPage.click();
        String a = Check.getText();

        if("Us1jk23".equals(a)) System.out.println("Username matched");
        else {
            System.out.println("Wrong Account");
        }
    }

}
