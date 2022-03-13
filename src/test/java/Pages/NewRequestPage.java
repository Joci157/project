package Pages;

import Utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class NewRequestPage {

    WebDriver driver;

    public By user = By.id("Darius  Kuzmickas");
    public By language = By.xpath("//*[@id=\"root\"]/div/main/div/form/div/div[2]/div[1]/select");
    public By costCenter = By.id("inputList");
    public By target = By.xpath("//*[@id=\"root\"]/div/main/div/form/div/div[2]/div[3]/select");
    public By semester = By.xpath("//*[@id=\"root\"]/div/main/div/form/div/div[2]/div[4]/select");
    public By comments = By.xpath("//*[@id=\"root\"]/div/main/div/form/div/div[3]/div[1]/textarea");
    public By saveButton = By.xpath("//*[@id=\"root\"]/div/main/div/form/div/div[3]/div[2]/div[2]/button[1]");
    public By cancelButton = By.xpath("//*[@id=\"root\"]/div/main/div/form/div/div[3]/div[2]/div[2]/button[2]");
    public By alertMessage = By.className("modal-body");
    public By alertYesButton = By.xpath("/html/body/div[3]/div/div/div[3]/button[2]");

    public NewRequestPage(WebDriver driver){
        this.driver = driver;
    }
    public void selectUser(){
        WaitUtils.waitUntilVisibilityOfElementLocated(driver, user, 10);
        driver.findElement(user).click();
    }
    public void selectLanguage(){
        driver.findElement(language).click();
        Select langDropdown = new Select(driver.findElement(language));
        langDropdown.selectByValue("Spanish");
    }
    public void enterDataToCostCenterField(){
        driver.findElement(costCenter).sendKeys("485324");
    }
    public void selectTarget(){
        driver.findElement(target).click();
        Select targetDropdown = new Select(driver.findElement(target));
        targetDropdown.selectByValue("Work");
    }
    public void selectSemester(){
        driver.findElement(semester).click();
        Select semesterDropdown = new Select(driver.findElement(semester));
        semesterDropdown.selectByValue("Apr-Jun (II)");
    }
    public void writeComment(){
        driver.findElement(comments).sendKeys("automation test");
    }
    public void clickSaveButton(){
        driver.findElement(saveButton).click();
    }
    public void clickCancelButton(){
        driver.findElement(cancelButton).click();
    }
    public void getAlertMessageText(){
        WaitUtils.waitUntilVisibilityOfElementLocated(driver, alertMessage, 10);
        String alertMessageText = driver.findElement(alertMessage).getText();
        Assert.assertTrue(alertMessageText.contains("Do you really want to delete this element?"), "Alert message was different or not displayed");
    }
    public void clickAlertYesButtonToCancelNewRequest(){
        driver.findElement(alertYesButton).click();
    }
}
