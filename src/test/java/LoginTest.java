import Pages.LoginPage;
import Pages.MainPage;
import Utils.WindowHandles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @DataProvider(name = "credentials")
    public static Object[][] createData() {
        return new Object[][]{
                new Object[]{("admin.test@kitm.lt"),("Akademija20"), ("Coordinator")},
                new Object[]{("regularuser.test@kitm.lt"),("Akademija20"), ("Requestor")},
                new Object[]{("teamlead.test@kitm.lt"),("Akademija20"), ("Teacher")},
                new Object[]{("blockuser.test@kitm.lt"),("Akademija20"), ("Student")}
        };
    }


    @Test(dataProvider = "credentials")
    public void HappyPathLoginWithDifferentUsers(String username, String password, String role)  {

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
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
        String userNameAndRoleText = mainPage.getUserNameAndRoleText(role);

        Assert.assertTrue(userNameAndRoleText.contains(role),"Users role was not displayed in the header.");
    }


    @Test
    public void loginWithIncorrectCredentials(){

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        WindowHandles windowHandles= new WindowHandles(driver);

        mainPage.clickLoginButton();
        windowHandles.switchToPopUpWindow();
        loginPage.enterUsername("teamlead.test@kitm.lt");
        loginPage.clickOnNextButton();
        loginPage.enterPassword("incorrectPassword");
        loginPage.clickSignInButton();
        if (windowHandles.countWindows() != 1) {
            loginPage.clickOnDisagreeStaySignedInButton();
        }
        loginPage.checkIfPasswordErrorIsDisplayed();
        driver.close();
        windowHandles.switchToMainWindow();
        WebElement userNameAndRole = driver.findElement(By.className("log-in-festo"));
        String userNameAndRoleText = userNameAndRole.getText();

        Assert.assertFalse(userNameAndRoleText.contains("Teacher"),"Users role was displayed in the header.");

    }


}
