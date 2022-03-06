package Pages;

import Utils.WaitUtils;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class AuthorizationPage {

    WebDriver driver;

    public By homeLink = By.id("home");
    public By newRequestLink = By.id("newReq");
    public By classroomsManagementLink = By.id("classMan");
    public By learningHistoryLink = By.id("learnHis");
    public By helpLink = By.id("help");
    public By homePageTitle = By.xpath("//h1['This is Home page']");
    public By newReqPageTitle =  By.className("hText");
    public By learnHisPageTitle = By.xpath("//h1['Mokymosi Istorija']");
    public By helpPageTitle = By.xpath("//h1['Pagalba']");


    public AuthorizationPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickOnHomeLink(){
        WaitUtils.waitUntilElementToBeClickable(driver, homeLink, 5);
        driver.findElement(homeLink).click();
    }
    public void clickOnNewRequestLink(){
        WaitUtils.waitUntilElementToBeClickable(driver, newRequestLink, 5);
        driver.findElement(newRequestLink).click();
    }
    public void clickOnClassroomsManagementLink(){
        WaitUtils.waitUntilElementToBeClickable(driver, classroomsManagementLink, 5);
        driver.findElement(classroomsManagementLink).click();
    }
    public void clickOnLearningHistoryLink(){
        WaitUtils.waitUntilElementToBeClickable(driver, learningHistoryLink, 5);
        driver.findElement(learningHistoryLink).click();
    }
    public void clickOnHelpLink(){
        WaitUtils.waitUntilElementToBeClickable(driver, helpLink, 5);
        driver.findElement(helpLink).click();
    }
    public void getHomePageTitleText(){
        WaitUtils.waitUntilVisibilityOfElementLocated(driver, homePageTitle, 5);
        String homePageTitleIsDisplayed = driver.findElement(homePageTitle).getText();
        Assert.assertTrue(homePageTitleIsDisplayed.contains("This is Home page"),"Home link is not found");
    }
    public void getNewReqPageTitleText(){
        WaitUtils.waitUntilVisibilityOfElementLocated(driver, newReqPageTitle, 5);
        String actualNewReqPageTitle = driver.findElement(newReqPageTitle).getText();
        Assert.assertTrue(actualNewReqPageTitle.contains("New Request"), "New request link is not found");
    }
    public void getLearnHisPageTitleText(){
        WaitUtils.waitUntilVisibilityOfElementLocated(driver, learnHisPageTitle, 5);
        String learnHisPageTitleIsDisplayed = driver.findElement(learnHisPageTitle).getText();
        Assert.assertTrue(learnHisPageTitleIsDisplayed.contains("Mokymosi Istorija"), "Learning history link is not found");
    }
    public void getHelpPageTitleText(){
        WaitUtils.waitUntilVisibilityOfElementLocated(driver, helpPageTitle, 5);
        String helpPageTitleIsDisplayed = driver.findElement(homePageTitle).getText();
        Assert.assertTrue(helpPageTitleIsDisplayed.contains("Pagalba"), "Help link is not found");
    }
}
