package Pages;

import Utils.WaitUtils;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;



public class AuthorizationPage {

    WebDriver driver;

    public By homeLink = By.id("home");
    public By newRequestLink = By.id("newReq");
    public By classroomsManagementLink = By.id("nav-dropdown");
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
        WaitUtils.waitUntilElementToBeClickable(driver, homeLink, 10);
        driver.findElement(homeLink).click();
    }
    public void clickOnNewRequestLink(){
        WaitUtils.waitUntilElementToBeClickable(driver, newRequestLink, 10);
        driver.findElement(newRequestLink).click();
    }
    public void clickOnClassroomsManagementLink(){
        WaitUtils.waitUntilElementToBeClickable(driver, classroomsManagementLink, 10);
        driver.findElement(classroomsManagementLink).click();
    }
    public void clickOnLearningHistoryLink(){
        WaitUtils.waitUntilElementToBeClickable(driver, learningHistoryLink, 10);
        driver.findElement(learningHistoryLink).click();
    }
    public void clickOnHelpLink(){
        WaitUtils.waitUntilElementToBeClickable(driver, helpLink, 10);
        driver.findElement(helpLink).click();
    }
    public void getHomePageTitleText(){
        WaitUtils.waitUntilVisibilityOfElementLocated(driver, homePageTitle, 10);
        String homePageTitleIsDisplayed = driver.findElement(homePageTitle).getText();
        Assert.assertTrue(homePageTitleIsDisplayed.contains("This is Home page"),"Home link is not found");
    }
    public void getNewReqPageTitleText(){
        WaitUtils.waitUntilVisibilityOfElementLocated(driver, newReqPageTitle, 10);
        String actualNewReqPageTitle = driver.findElement(newReqPageTitle).getText();
        Assert.assertTrue(actualNewReqPageTitle.contains("New Request"), "New request link is not found");
    }
    public void getLearnHisPageTitleText(){
        WaitUtils.waitUntilVisibilityOfElementLocated(driver, learnHisPageTitle, 10);
        String learnHisPageTitleIsDisplayed = driver.findElement(learnHisPageTitle).getText();
        Assert.assertTrue(learnHisPageTitleIsDisplayed.contains("Mokymosi Istorija"), "Learning history link is not found");
    }
    public void getHelpPageTitleText(){
        WaitUtils.waitUntilVisibilityOfElementLocated(driver, helpPageTitle, 10);
        String helpPageTitleIsDisplayed = driver.findElement(homePageTitle).getText();
        Assert.assertTrue(helpPageTitleIsDisplayed.contains("Pagalba"), "Help link is not found");
    }
    public void checkIfNewRequestAndClassroomsManagementLinksAreNotDisplayed(){
        SoftAssert softAssert = new SoftAssert();
        int elements = driver.findElements(newRequestLink).size();
        int ele = driver.findElements(classroomsManagementLink).size();
        softAssert.assertEquals(elements, 0, "New Request link is visible");
        softAssert.assertEquals(ele, 0, "Classroom Management Link is visible");
        softAssert.assertAll();

    }
    public void checkIfClassroomManagementLinkIsNotDisplayed(){
        SoftAssert softAssert = new SoftAssert();
        int elements = driver.findElements(classroomsManagementLink).size();
        softAssert.assertEquals(elements, 0, "Classroom Management Link is visible");
        softAssert.assertAll();


    }
}
