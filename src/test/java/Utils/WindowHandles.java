package Utils;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class WindowHandles {
    WebDriver driver;

    public WindowHandles(WebDriver driver){
        this.driver = driver;;
    }

    private void switchToWindow(String handle){
        driver.switchTo().window(handle);
    }

    public void switchToPopUpWindow(){
        ArrayList<String> handles = new ArrayList<>(driver.getWindowHandles());
        switchToWindow(handles.get(handles.size() - 1));
    }

    public void switchToMainWindow(){
        ArrayList<String> handles = new ArrayList<>(driver.getWindowHandles());
        switchToWindow(handles.get(handles.size() - 1));
    }

    public int countWindows(){
        ArrayList<String> handles = new ArrayList<>(driver.getWindowHandles());
        return handles.size();
    }
}
