package Pages;

import Utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class RoleManagementPage {

    WebDriver driver;
    Random random = new Random();
    public By classroomManagementLink = By.id("nav-dropdown");
    public By setRoleLink = By.id("roleManage");
    public By arrowToAddTeacherRole = By.id("Teacher");
    public By arrowToAddRequestorRole = By.id("Requestor");
    public By arrowToRemoveTeacherRole = By.id("TeacherDel");
    public By arrowToRemoveRequestorRole = By.id("RequestorDel");
    public By teachersList = By.xpath(".//*[@id='teach']//option");
    public By requestorList = By.xpath(".//*[@id='req']//option");

    public RoleManagementPage(WebDriver driver){
        this.driver = driver;
    }
    public void clickOnSetRoleLink() {
        WaitUtils.waitUntilElementToBeClickable(driver, classroomManagementLink, 10);
        driver.findElement(classroomManagementLink).click();
        WaitUtils.waitUntilElementToBeClickable(driver, setRoleLink, 10);
        driver.findElement(setRoleLink).click();
    }
    public void clickAddArrowToAssignTeacherRole(){
        WaitUtils.waitUntilElementToBeClickable(driver, arrowToAddTeacherRole, 10);
        driver.findElement(arrowToAddTeacherRole).click();
    }
    public void clickAddArrowToAssignRequestorRole(){
        WaitUtils.waitUntilElementToBeClickable(driver, arrowToAddRequestorRole, 10);
        driver.findElement(arrowToAddRequestorRole).click();
    }
    public void clickArrowToRemoveTeacherRole(){
        WaitUtils.waitUntilElementToBeClickable(driver, arrowToRemoveTeacherRole, 10);
        driver.findElement(arrowToRemoveTeacherRole).click();
    }
    public void clickArrowToRemoveRequestorRole(){
        WaitUtils.waitUntilElementToBeClickable(driver, arrowToRemoveRequestorRole, 10);
        driver.findElement(arrowToRemoveRequestorRole).click();
    }
    public void selectRandomUserWithTeacherRole(){
        WaitUtils.waitUntilVisibilityOfElementLocated(driver, teachersList, 10);
        List<WebElement> allUsers = driver.findElements(teachersList);
        int randomUser = random.nextInt(allUsers.size());
        allUsers.get(randomUser).click();
    }
    public void selectRandomUserWithRequestorRole(){
        WaitUtils.waitUntilVisibilityOfElementLocated(driver, requestorList, 10);
        List<WebElement> allUsers = driver.findElements(requestorList);
        int randomUser = random.nextInt(allUsers.size());
        allUsers.get(randomUser).click();
    }
}

