package org.last.fm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FakeLogin {

        WebDriver driver;

        //Main Page Login Button
        @FindBy(xpath = "//a[contains(@class, 'site-auth-control')]")
        WebElement MainLoginBttn;

        //Form - username box
        @FindBy(xpath = "//input[contains(@name, 'username_or_email')]")
        WebElement usernameFake;

        //Form - password box
        @FindBy(xpath = "//input[@id='id_password']")
        WebElement passwordFake;

        //LetMeIn Button
        @FindBy(xpath = "//button[@class=\"btn-primary\"]")
        WebElement LetMeInBttn;

        public FakeLogin(WebDriver driver) {
                this.driver = driver;
                PageFactory.initElements(driver, this);
        }

        public void MainLoginButton() {
                MainLoginBttn.click();
        }

        public void enterUsername(String username) {
                usernameFake.sendKeys(username);
        }

        public void enterPassword(String password) {
                passwordFake.sendKeys(password);
        }

        public void LetMeInButton() {
                LetMeInBttn.click();
        }
}