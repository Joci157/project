package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Utils.WaitUtils;

public class MainPage {

    WebDriver driver;

    public By loginLogoutBtn = By.className("logIn");
    public By roleInHeader = By.className("log-in-festo");

    public MainPage(WebDriver driver){
        this.driver = driver;
    }


    public void clickLoginButton(){
        driver.findElement(loginLogoutBtn).click();
    }

    public String getUserNameAndRoleText(String role){
        WaitUtils.waitUntilTextToBePresentInElementLocated(driver,roleInHeader,role, 10);
        WebElement userNameAndRole = driver.findElement(roleInHeader);
        return userNameAndRole.getText();
    }

    public void clickOnLogoutButton(String role){
        WaitUtils.waitUntilTextToBePresentInElementLocated(driver,roleInHeader,role, 10);
        driver.findElement(loginLogoutBtn).click();
    }



}
