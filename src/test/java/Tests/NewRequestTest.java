package Tests;

import Pages.AuthorizationPage;
import Pages.LoginPage;
import Pages.MainPage;
import Pages.NewRequestPage;
import Utils.WindowHandles;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewRequestTest extends BaseTest{

    @DataProvider(name = "loginCredentials")
    public static Object[][] loginData() {
        return new Object[][]{
                new Object[]{("admin.test@kitm.lt"),("Akademija20")},
                new Object[]{("regularuser.test@kitm.lt"),("Akademija20")},
        };
    }
    @Test(priority = 1, dataProvider = "loginCredentials")
    public void createNewRequest(String username, String password) throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        NewRequestPage newRequestPage = new NewRequestPage(driver);
        WindowHandles windowHandles = new WindowHandles(driver);

        mainPage.clickLoginButton();
        windowHandles.switchToPopUpWindow();
        loginPage.enterUsername(username);
        loginPage.clickOnNextButton();
        loginPage.enterPassword(password);
        loginPage.clickSignInButton();
        if (windowHandles.countWindows() != 1) {
            loginPage.clickOnDisagreeStaySignedInButton();
        }
        windowHandles.switchToMainWindow();

        authorizationPage.clickOnNewRequestLink();
        newRequestPage.selectUser();
        newRequestPage.selectLanguage();
        newRequestPage.enterDataToCostCenterField();
        newRequestPage.selectTarget();
        newRequestPage.selectSemester();
        newRequestPage.writeComment();
        newRequestPage.clickSaveButton();
    }

    @Test(priority = 2, dataProvider = "loginCredentials")
        public void cancelNewRequest(String username, String password){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        NewRequestPage newRequestPage = new NewRequestPage(driver);
        WindowHandles windowHandles = new WindowHandles(driver);

        mainPage.clickLoginButton();
        windowHandles.switchToPopUpWindow();
        loginPage.enterUsername(username);
        loginPage.clickOnNextButton();
        loginPage.enterPassword(password);
        loginPage.clickSignInButton();
        if (windowHandles.countWindows() != 1) {
            loginPage.clickOnDisagreeStaySignedInButton();
        }
        windowHandles.switchToMainWindow();

        authorizationPage.clickOnNewRequestLink();
        newRequestPage.selectUser();
        newRequestPage.selectLanguage();
        newRequestPage.enterDataToCostCenterField();
        newRequestPage.selectTarget();
        newRequestPage.selectSemester();
        newRequestPage.writeComment();
        newRequestPage.clickCancelButton();
        newRequestPage.getAlertMessageText();
        newRequestPage.clickAlertYesButtonToCancelNewRequest();
    }
}
