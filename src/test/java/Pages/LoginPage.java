package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Utils.WaitUtils;

public class LoginPage {

    WebDriver driver;

    public By passwordInput = By.name("passwd");
    public By signInBtn = By.id("idSIButton9");
    public By disagreeStaySignedInButton = By.id("idBtn_Back");
    public By nextButton = By.id("idSIButton9");
    public By usernameInput = By.name("loginfmt");
    public By passwordError = By.id("passwordError");
    public By userInfo = By.className("table");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickSignInButton(){
        WaitUtils.waitUntilElementToBeClickable(driver,signInBtn, 10);
        driver.findElement(signInBtn).click();
    }

    public void enterUsername(String username){
        WaitUtils.waitUntilVisibilityOfElementLocated(driver, usernameInput, 10);
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password){
        WaitUtils.waitUntilVisibilityOfElementLocated(driver, passwordInput, 10);
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickOnDisagreeStaySignedInButton(){
        WaitUtils.waitUntilVisibilityOfElementLocated(driver, disagreeStaySignedInButton, 10);
        driver.findElement(disagreeStaySignedInButton).click();
    }

    public void clickOnNextButton(){
        driver.findElement(nextButton).click();
    }

    public void checkIfPasswordErrorIsDisplayed(){
        WaitUtils.waitUntilVisibilityOfElementLocated(driver, passwordError, 10);
    }

    public void clickOnUserInfoToLogOut(){
        WaitUtils.waitUntilTextToBePresentInElementLocated(driver,userInfo,"teamlead.test@kitm.lt", 10);
        driver.findElement(userInfo).click();
    }

}
