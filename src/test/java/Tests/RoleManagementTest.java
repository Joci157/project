package Tests;

import Pages.LoginPage;
import Pages.MainPage;
import Pages.RoleManagementPage;
import Utils.WindowHandles;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RoleManagementTest extends BaseTest{

    @DataProvider(name = "loginCredentials")
    public static Object[][] loginData() {
        return new Object[][]{
                new Object[]{("admin.test@kitm.lt"),("Akademija20")}
        };
    }

    @Test(priority = 1, dataProvider = "loginCredentials")
    public void setRoles(String username, String password) throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RoleManagementPage roleManagementPage = new RoleManagementPage(driver);
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

        roleManagementPage.clickOnSetRoleLink();
        mainPage.selectRandomUser();
        int numberOfUsersWithTeacherRole = driver.findElements(By.xpath(".//*[@id='teach']//option")).size();
        roleManagementPage.clickAddArrowToAssignTeacherRole();
        Thread.sleep(5000);
        int numberOfUsersWithTeacherRoleAfterAdding = driver.findElements(By.xpath(".//*[@id='teach']//option")).size();
        Assert.assertNotEquals(numberOfUsersWithTeacherRole, numberOfUsersWithTeacherRoleAfterAdding, "Number of users with teacher role did not change after adding new user");

        mainPage.selectRandomUser();
        int numberOfUsersWithRequestorRole = driver.findElements(By.xpath(".//*[@id='req']//option")).size();
        roleManagementPage.clickAddArrowToAssignRequestorRole();
        Thread.sleep(5000);
        int numberOfUsersWithRequestorRoleAfterAdding = driver.findElements(By.xpath(".//*[@id='req']//option")).size();
        Assert.assertNotEquals(numberOfUsersWithRequestorRole, numberOfUsersWithRequestorRoleAfterAdding, "Number of users with requestor role did not change after adding new user");
    }

    @Test(priority = 2, dataProvider = "loginCredentials")
    public void removeRole(String username, String password) throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RoleManagementPage roleManagementPage = new RoleManagementPage(driver);
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

        roleManagementPage.clickOnSetRoleLink();
        roleManagementPage.selectRandomUserWithTeacherRole();
        int numberOfUsersWithTeacherRole = driver.findElements(By.xpath(".//*[@id='teach']//option")).size();
        roleManagementPage.clickArrowToRemoveTeacherRole();
        Thread.sleep(5000);
        int numberOfUsersWithTeacherRoleAfterRemovingRole = driver.findElements(By.xpath(".//*[@id='teach']//option")).size();
        Assert.assertNotEquals(numberOfUsersWithTeacherRole, numberOfUsersWithTeacherRoleAfterRemovingRole, "Number of users with teacher role did not change after removing user");
        roleManagementPage.selectRandomUserWithRequestorRole();
        int numberOfUsersWithRequestorRole = driver.findElements(By.xpath(".//*[@id='req']//option")).size();
        roleManagementPage.clickArrowToRemoveRequestorRole();
        Thread.sleep(5000);
        int numberOfUsersWithRequesorRoleAfterRemovingRole = driver.findElements(By.xpath(".//*[@id='req']//option")).size();
        Assert.assertNotEquals(numberOfUsersWithRequestorRole, numberOfUsersWithRequesorRoleAfterRemovingRole, "Number of users with requestor role did not change after removing user");
    }
}
