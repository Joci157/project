package Pages;

import Utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;
import java.util.Random;

public class  NewRequestPage {

    WebDriver driver;


    public By randomLanguages = By.xpath(".//*[@id='lang']//option");
    public By costCenter = By.id("inputList");
    public By randomTargets = By.xpath(".//*[@id='targ']//option");
    public By randomSemesters = By.xpath(".//*[@id='sem']//option");
    public By comments = By.id("com");
    public By saveButton = By.id("sav");
    public By cancelButton = By.id("canc");
    public By alertMessage = By.className("modal-body");
    public By alertYesButton = By.xpath("/html/body/div[3]/div/div/div[3]/button[2]");
    public By messageAfterSavingNewRequest = By.className("ajs-message");

    public NewRequestPage(WebDriver driver){
        this.driver = driver;
    }
    public void selectRandomLanguage() {
        WaitUtils.waitUntilVisibilityOfElementLocated(driver, randomLanguages, 10);
        List<WebElement> allLanguages = driver.findElements(randomLanguages);
        Random random = new Random();
        int randomLanguage = random.nextInt(1, allLanguages.size());
        allLanguages.get(randomLanguage).click();
    }
    public void selectRandomTarget() {
        WaitUtils.waitUntilVisibilityOfElementLocated(driver, randomTargets, 10);
        List<WebElement> allTargets = driver.findElements(randomTargets);
        Random random = new Random();
        int randomTarget = random.nextInt(1, allTargets.size());
        allTargets.get(randomTarget).click();
    }
    public void selectRandomSemester() {
        WaitUtils.waitUntilVisibilityOfElementLocated(driver, randomSemesters, 10);
        List<WebElement> allSemesters = driver.findElements(randomSemesters);
        Random random = new Random();
        int randomSemester = random.nextInt(1, allSemesters.size());
        allSemesters.get(randomSemester).click();
    }
    public void enterDataToCostCenterField() {
        Random random = new Random();
        String costCenterInput ="";
        int inputLength = random.nextInt(1, 10);
        for (int i = 1; i < inputLength; i++) {
            int randomNumber = random.nextInt(0, 9);
            costCenterInput = costCenterInput + randomNumber;
        }
        driver.findElement(costCenter).sendKeys(costCenterInput);
    }
    public void writeComment(){
        driver.findElement(comments).sendKeys("automated testing");
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
    public void checkIfRequestCreatedMessageIsDisplayed(){
        WaitUtils.waitUntilVisibilityOfElementLocated(driver, messageAfterSavingNewRequest, 10);
        String messageText = driver.findElement(messageAfterSavingNewRequest).getText();
        Assert.assertTrue(messageText.contains("Request Created"), "Message was not displayed");
    }
}
