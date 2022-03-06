package Tests;

import Pages.AuthorizationPage;
import Pages.LoginPage;
import Pages.MainPage;
import Utils.WindowHandles;
import org.testng.annotations.Test;

public class AuthorizationModelTest extends BaseTest{


    @Test(priority = 1)
    public void CoordinatorVisibleHeaderLinks() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        WindowHandles windowHandles = new WindowHandles(driver);

        mainPage.clickLoginButton();
        windowHandles.switchToPopUpWindow();
        loginPage.enterUsername("admin.test@kitm.lt");
        loginPage.clickOnNextButton();
        loginPage.enterPassword("Akademija20");
        loginPage.clickSignInButton();
        if (windowHandles.countWindows() != 1) {
            loginPage.clickOnDisagreeStaySignedInButton();
        }
        windowHandles.switchToMainWindow();

        authorizationPage.clickOnHomeLink();
        authorizationPage.getHomePageTitleText();

        authorizationPage.clickOnNewRequestLink();
        authorizationPage.getNewReqPageTitleText();

        authorizationPage.clickOnClassroomsManagementLink();

        authorizationPage.clickOnLearningHistoryLink();
        authorizationPage.getLearnHisPageTitleText();

        authorizationPage.clickOnHelpLink();
        authorizationPage.getHelpPageTitleText();
    }

    @Test(priority = 2)
    public void RequestorVisibleHeaderLinks() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        WindowHandles windowHandles = new WindowHandles(driver);

        mainPage.clickLoginButton();
        windowHandles.switchToPopUpWindow();
        loginPage.enterUsername("regularuser.test@kitm.lt");
        loginPage.clickOnNextButton();
        loginPage.enterPassword("Akademija20");
        loginPage.clickSignInButton();
        if (windowHandles.countWindows() != 1) {
            loginPage.clickOnDisagreeStaySignedInButton();
        }
        windowHandles.switchToMainWindow();

        authorizationPage.clickOnHomeLink();
        authorizationPage.getHomePageTitleText();

        authorizationPage.clickOnNewRequestLink();
        authorizationPage.getNewReqPageTitleText();

        authorizationPage.clickOnLearningHistoryLink();
        authorizationPage.getLearnHisPageTitleText();

        authorizationPage.clickOnHelpLink();
        authorizationPage.getHelpPageTitleText();
    }

    @Test(priority = 3)
    public void TeacherVisibleHeaderLinks() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        WindowHandles windowHandles = new WindowHandles(driver);

        mainPage.clickLoginButton();
        windowHandles.switchToPopUpWindow();
        loginPage.enterUsername("teamlead.test@kitm.lt");
        loginPage.clickOnNextButton();
        loginPage.enterPassword("Akademija20");
        loginPage.clickSignInButton();
        if (windowHandles.countWindows() != 1) {
            loginPage.clickOnDisagreeStaySignedInButton();
        }
        windowHandles.switchToMainWindow();

        authorizationPage.clickOnHomeLink();
        authorizationPage.getHomePageTitleText();

        authorizationPage.clickOnLearningHistoryLink();
        authorizationPage.getLearnHisPageTitleText();

        authorizationPage.clickOnHelpLink();
        authorizationPage.getHelpPageTitleText();
    }
    @Test(priority = 4)
    public void StudentVisibleHeaderLinks() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        WindowHandles windowHandles = new WindowHandles(driver);

        mainPage.clickLoginButton();
        windowHandles.switchToPopUpWindow();
        loginPage.enterUsername("blockuser.test@kitm.lt");
        loginPage.clickOnNextButton();
        loginPage.enterPassword("Akademija20");
        loginPage.clickSignInButton();
        if (windowHandles.countWindows() != 1) {
            loginPage.clickOnDisagreeStaySignedInButton();
        }
        windowHandles.switchToMainWindow();

        authorizationPage.clickOnHomeLink();
        authorizationPage.getHomePageTitleText();

        authorizationPage.clickOnLearningHistoryLink();
        authorizationPage.getLearnHisPageTitleText();

        authorizationPage.clickOnHelpLink();
        authorizationPage.getHelpPageTitleText();
    }
}
